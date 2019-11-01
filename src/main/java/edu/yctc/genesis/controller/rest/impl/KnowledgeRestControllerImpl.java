package edu.yctc.genesis.controller.rest.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.yctc.genesis.constant.ResultCode;
import edu.yctc.genesis.controller.rest.KnowledgeRestController;
import edu.yctc.genesis.controller.session.SessionContentHolder;
import edu.yctc.genesis.entity.ClassroomDO;
import edu.yctc.genesis.entity.CourseDO;
import edu.yctc.genesis.entity.KnowledgeDO;
import edu.yctc.genesis.entity.LessonDO;
import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.service.KnowledgeIService;
import edu.yctc.genesis.vo.KnowledgeAndLesson4InsertVO;
import edu.yctc.genesis.vo.LessonAndKnowledgeVO;
import edu.yctc.genesis.vo.OneKnowledgeDetailsVO;

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
        return new ResultDO<List<LessonAndKnowledgeVO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
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
        return new ResultDO<List<OneKnowledgeDetailsVO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            lessonDetailsVOList);
    }
}
