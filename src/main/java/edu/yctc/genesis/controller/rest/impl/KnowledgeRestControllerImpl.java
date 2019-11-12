package edu.yctc.genesis.controller.rest.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import edu.yctc.genesis.entity.*;
import edu.yctc.genesis.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import edu.yctc.genesis.constant.ResultCode;
import edu.yctc.genesis.controller.rest.KnowledgeRestController;
import edu.yctc.genesis.controller.session.SessionContentHolder;
import edu.yctc.genesis.service.KnowledgeIService;

import static edu.yctc.genesis.constant.ResultCode.MSG_SUCCESS;
import static edu.yctc.genesis.constant.ResultCode.SUCCESS;

@RestController
@ComponentScan({"edu.yctc.genesis.service"})
@RequestMapping("/restknowledge")
public class KnowledgeRestControllerImpl implements KnowledgeRestController {

    private final static Logger LOG = LoggerFactory.getLogger("restcontrollerLog");

    @Autowired
    private KnowledgeIService knowledgeService;

    private static final String FILL_KNOWLEDGE_STEP_B = "/genesis/teaching/fill-knowledge-step-b?id=";

    @Override
    @PostMapping("get-lesson-and-knowledge")
    public ResultDO<List<LessonAndKnowledgeVO>> getLessonAndKnowledgeByTeacherId(HttpSession httpSession) {
        long userId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
        if (userId <= 0) {
            return new ResultDO<List<LessonAndKnowledgeVO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        // lessonDO集
        ResultDO<List<LessonDO>> getLessonDOListByUserIdResultDO =
            knowledgeService.getLessonDOListByUserId4Teacher(userId);
        if (getLessonDOListByUserIdResultDO.isSuccess() == false) {
            return new ResultDO<List<LessonAndKnowledgeVO>>(false, getLessonDOListByUserIdResultDO.getCode(),
                getLessonDOListByUserIdResultDO.getMsg(), null);
        }
        List<LessonDO> lessonDOList = getLessonDOListByUserIdResultDO.getModule();
        for (LessonDO lessonDO : lessonDOList) {
            // 参数验证
            if (lessonDO.getId() <= 0 || lessonDO.getNumber() <= 0 || lessonDO.getClassroomId() <= 0
                || lessonDO.getCourseId() <= 0) {
                return new ResultDO<List<LessonAndKnowledgeVO>>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
            }
            // 存在性验证
            ResultDO<CourseDO> getCourseDOByIdResultDO = knowledgeService.getCourseDOById(lessonDO.getCourseId());
            if (getCourseDOByIdResultDO.isSuccess() == false) {
                return new ResultDO<List<LessonAndKnowledgeVO>>(false, getCourseDOByIdResultDO.getCode(),
                    getCourseDOByIdResultDO.getMsg(), null);
            }
            ResultDO<ClassroomDO> getClassroomDOByIdResultDO =
                knowledgeService.getClassroomDOById(lessonDO.getClassroomId());
            if (getClassroomDOByIdResultDO.isSuccess() == false) {
                return new ResultDO<List<LessonAndKnowledgeVO>>(false, getClassroomDOByIdResultDO.getCode(),
                    getClassroomDOByIdResultDO.getMsg(), null);
            }
        }
        // 构建VO
        List<LessonAndKnowledgeVO> lessonAndKnowledgeVOs = new ArrayList<>();
        for (LessonDO lessonDO : lessonDOList) {
            LessonAndKnowledgeVO lessonAndKnowledgeVO = new LessonAndKnowledgeVO();
            CourseDO courseDO = knowledgeService.getCourseDOById(lessonDO.getCourseId()).getModule();
            ClassroomDO classroomDO = knowledgeService.getClassroomDOById(lessonDO.getClassroomId()).getModule();
            List<KnowledgeDO> knowledgeDOs = knowledgeService.getKnowledgeDOsByLessonId(lessonDO.getId()).getModule();
            lessonAndKnowledgeVO.setClassroom(classroomDO.getNumber());
            lessonAndKnowledgeVO.setBegin(lessonDO.getBegin());
            lessonAndKnowledgeVO.setCourseName(courseDO.getName());
            lessonAndKnowledgeVO.setLessonId(lessonDO.getId());
            lessonAndKnowledgeVO.setKnowledgeDOs(knowledgeDOs);
            lessonAndKnowledgeVO.setUrl(FILL_KNOWLEDGE_STEP_B + lessonDO.getId());
            lessonAndKnowledgeVOs.add(lessonAndKnowledgeVO);
        }
        return new ResultDO<List<LessonAndKnowledgeVO>>(true, SUCCESS, ResultCode.MSG_SUCCESS,
            lessonAndKnowledgeVOs);
    }

    @Override
    @PostMapping("get-knowledgedos-by-lessonid")
    public ResultDO<List<KnowledgeDO>> getKnowledgeDOsByLessonId(@RequestBody long lessonId) {
        if (lessonId <= 0) {
            return new ResultDO<List<KnowledgeDO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        return knowledgeService.getKnowledgeDOsByLessonId(lessonId);
    }

    //通过知识点id返回知识点图片集合  restknowledge/get-picture-knowlegde
    @Override
    @GetMapping("get-picture-knowlegde")
    public ResultDO<List<KnowledgePictureDO>> getKnowledgePictureDOsByLessonId(long knowledgeid){
//        int knowledgeid=2;
        System.out.println("开始查找图片");
        if (knowledgeid <= 0) {
            return new ResultDO<List<KnowledgePictureDO>>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<List<KnowledgePictureDO>> knowledgePictureDOsByKnowledgeIdId=new ResultDO<>();
        /*
        获取知识点图片集合
         */
        knowledgePictureDOsByKnowledgeIdId = knowledgeService.getKnowledgePictureDOsByKnowledgeId(knowledgeid);
        if (knowledgePictureDOsByKnowledgeIdId.isSuccess() == false) {
            return new ResultDO<List<KnowledgePictureDO>>(false, knowledgePictureDOsByKnowledgeIdId.getCode(), knowledgePictureDOsByKnowledgeIdId.getMsg(), null);
        }
        List<KnowledgePictureDO> pictureDOsByKnowledgeIdIdModule = knowledgePictureDOsByKnowledgeIdId.getModule();
        LOG.info("knowledgePictureDOsByKnowledgeIdId success, module={}", knowledgePictureDOsByKnowledgeIdId.getModule());
        return new ResultDO<List<KnowledgePictureDO>>(true, SUCCESS, ResultCode.MSG_SUCCESS,
                pictureDOsByKnowledgeIdIdModule);
    }

    //通过课程id返回该课程的知识点图片  restknowledge/get-picture-lessonId-knowlegde
    @Override
    @RequestMapping("get-picture-lessonId-knowlegde")
    public ResultDO<List<GetPictureVO>> getAllPictureByLessonId(@RequestParam  long lessonId){
        System.out.println("开始查找某课程知识点对应的所有图片");
        if (lessonId <= 0) {
            return new ResultDO<List<GetPictureVO>>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<List<KnowledgePictureDO>> knowledgePictureDOsByKnowledgeIdId=new ResultDO<>();
        /*
        获取知识点图片集合
         */
        ResultDO<List<KnowledgeDO>> knowledgeDOsByLessonId = knowledgeService.getKnowledgeDOsByLessonId(lessonId);
        List<KnowledgeDO> knowledgeDOS = knowledgeDOsByLessonId.getModule();
        LOG.info("knowledgeDOS pictureDOS success, knowledgeDOS={}", knowledgeDOS);
        //遍历所有知识点
        List<GetPictureVO> getPictureVOS=new ArrayList<>();
        System.out.println("遍历所有知识点数量"+knowledgeDOS.size());
        for (int i = 0;i<knowledgeDOS.size()-1;i++){
            long l = knowledgeDOS.get(i).getId();
            System.out.println(knowledgeDOS.get(i).getContent());
            List<KnowledgePictureDO> pictureDOS = knowledgeService.getKnowledgePictureDOsByKnowledgeId(l).getModule();
            GetPictureVO getPictureVO=new GetPictureVO();
            getPictureVO.setPicture(pictureDOS);
            getPictureVOS.add(getPictureVO);
        }
        LOG.info("knowledgePictureDOsByKnowledgeId pictureDOS success, knowledgePictureDOsByKnowledgeId={}", getPictureVOS);
        return new ResultDO<List<GetPictureVO>>(true, SUCCESS, ResultCode.MSG_SUCCESS,
                getPictureVOS);
    }

    //通过知识点id和课程id返回学生状态人数  restknowledge/get-students-Lesson-State
    //@RequestBody long lessonId,@RequestBody long knowledgeId
    @Override
    @GetMapping("get-students-Lesson-State")
    public ResultDO<StudentsLessonStateVO> studentsLessonStateVO(@RequestParam long lessonId,@RequestParam long knowledgeId){
//        long lessonId=33;
//        long knowledgeId=360;
        if (lessonId <= 0) {
            return new ResultDO<StudentsLessonStateVO>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID,
                    null);
        }
        ResultDO<StudentsLessonStateVO> lessonStateVO = null;
        StudentsLessonStateVO stateVOModule = null;
        try {
            lessonStateVO = knowledgeService.getStudentsLessonStateVO(lessonId, knowledgeId);
            stateVOModule = lessonStateVO.getModule();
            LOG.info("lessonStateVO success, lessonId={},knowledgeId={}",lessonId, knowledgeId);
        } catch (Exception e) {
            LOG.info("StudentsLessonStateVO error, lessonId={},knowledgeId={}",lessonId, knowledgeId);
        }
        LOG.info("StudentsLessonStateVO success, studentsLessonStateVO={}", lessonStateVO);
        return new ResultDO<StudentsLessonStateVO>(true, SUCCESS, ResultCode.MSG_SUCCESS,
                stateVOModule);
    }


    @Override
    @PostMapping("modify-knowledge")
    public ResultDO<Void> modifyKnowledge(@RequestBody KnowledgeDO knowledgeDO) {
        if (knowledgeDO.getId() <= 0 || StringUtils.isBlank(knowledgeDO.getContent())
            || knowledgeDO.getLength() <= 0) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        return knowledgeService.modifyKnowledge(knowledgeDO);
    }

    @Override
    @PostMapping("delete-knowledge-by-id")
    public ResultDO<Void> deleteKnowledgeById(@RequestBody long id) {
        if (id <= 0) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        return knowledgeService.deleteKnowledgeById(id);
    }

    @Override
    @PostMapping("insert-knowledge")
    public ResultDO<Void> insertKnowledge(@RequestBody KnowledgeAndLesson4InsertVO knowledgeAndLesson4InsertVO) {
        if (knowledgeAndLesson4InsertVO.getLessonId() <= 0
            || StringUtils.isBlank(knowledgeAndLesson4InsertVO.getContent())
            || knowledgeAndLesson4InsertVO.getLength() <= 0) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        return knowledgeService.insertKnowledge(knowledgeAndLesson4InsertVO.getLessonId(),
            knowledgeAndLesson4InsertVO.getContent(), knowledgeAndLesson4InsertVO.getLength());
    }

    @Override
    @PostMapping("get-knowledgesdetailsvo-by-lessonid-listone")
    public ResultDO<List<OneKnowledgeDetailsVO>> getknowledgesDetailsVOByLessonId(@RequestBody long lessonId) {
        if (lessonId <= 0) {
            return new ResultDO<List<OneKnowledgeDetailsVO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        ResultDO<List<OneKnowledgeDetailsVO>> resultDO = knowledgeService.getKnowledgesDetailsVOByLessonId(lessonId);
        if (resultDO.isSuccess() == false) {
            return new ResultDO<List<OneKnowledgeDetailsVO>>(false, resultDO.getCode(), resultDO.getMsg(), null);
        }
        List<OneKnowledgeDetailsVO> lessonDetailsVOList = resultDO.getModule();
        LOG.info("getknowledgesDetailsVOByLessonId success, lessonDetailsVOList={}", lessonDetailsVOList);
        return new ResultDO<List<OneKnowledgeDetailsVO>>(true, SUCCESS, ResultCode.MSG_SUCCESS,
            lessonDetailsVOList);
    }


    //restknowledge/get-Picture-BooleanLast
    //
    @Override
    @RequestMapping("get-Picture-BooleanLast")
    public ResultDO<GetBooleanByPictureVO> GetPictureBooleanLastVO(@RequestParam long pictureId) {
//        long pictureId=1;
        if (pictureId <= 0) {
            return new ResultDO<GetBooleanByPictureVO>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID,
                    null);
        }
        ResultDO<GetBooleanByPictureVO> byPictureVOResultDO = knowledgeService.GetBooleanByPictureid(pictureId);
        if (byPictureVOResultDO.isSuccess() == false) {
            return new ResultDO<GetBooleanByPictureVO> (false, byPictureVOResultDO.getCode(), byPictureVOResultDO.getMsg(), null);
        }
        GetBooleanByPictureVO pictureVOResultDOModule = byPictureVOResultDO.getModule();
        LOG.info("getknowledgesDetailsVOByLessonId success, GetPictureBooleanLastVO={}", pictureVOResultDOModule);
        return new ResultDO<GetBooleanByPictureVO> (true, SUCCESS, ResultCode.MSG_SUCCESS,
                pictureVOResultDOModule);
    }


}
