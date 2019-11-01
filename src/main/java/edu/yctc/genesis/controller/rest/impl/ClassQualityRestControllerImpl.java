package edu.yctc.genesis.controller.rest.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.yctc.genesis.constant.ResultCode;
import edu.yctc.genesis.controller.rest.ClassQualityRestController;
import edu.yctc.genesis.controller.session.SessionContentHolder;
import edu.yctc.genesis.entity.ClassScoreDO;
import edu.yctc.genesis.entity.ClassroomDO;
import edu.yctc.genesis.entity.CourseDO;
import edu.yctc.genesis.entity.LessonDO;
import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.service.ClassQualityIService;
import edu.yctc.genesis.vo.ClassScoreVO;

@RestController
@ComponentScan({"edu.yctc.genesis.service"})
@RequestMapping("/restclassquality")
public class ClassQualityRestControllerImpl implements ClassQualityRestController {

    @Autowired
    ClassQualityIService classQualityService;

    @Override
    @PostMapping("get-my-class-quality")
    public ResultDO<List<ClassScoreVO>> getMyClassQuality(HttpSession httpSession) {
        long userId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
        if (userId <= 0) {
            return new ResultDO<List<ClassScoreVO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<List<LessonDO>> getLessonDOByUserIdResultDO =
            classQualityService.getLessonDOList4StudentByUserId(userId);
        if (getLessonDOByUserIdResultDO.isSuccess() == false) {
            return new ResultDO<List<ClassScoreVO>>(false, getLessonDOByUserIdResultDO.getCode(),
                getLessonDOByUserIdResultDO.getMsg(), null);
        }
        List<LessonDO> lessonDOList = getLessonDOByUserIdResultDO.getModule();
        // 参数验证
        for (LessonDO lessonDO : lessonDOList) {
            if (lessonDO.getId() <= 0 || lessonDO.getNumber() <= 0 || lessonDO.getClassroomId() <= 0
                || lessonDO.getCourseId() <= 0) {
                return new ResultDO<List<ClassScoreVO>>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
            }
            // 存在性验证
            ResultDO<CourseDO> getCourseDOByIdResultDO = classQualityService.getCourseDOById(lessonDO.getCourseId());
            if (getCourseDOByIdResultDO.isSuccess() == false) {
                return new ResultDO<List<ClassScoreVO>>(false, getCourseDOByIdResultDO.getCode(),
                    getCourseDOByIdResultDO.getMsg(), null);
            }
            ResultDO<ClassroomDO> getClassroomDOByIdResultDO =
                classQualityService.getClassroomDOById(lessonDO.getClassroomId());
            if (getClassroomDOByIdResultDO.isSuccess() == false) {
                return new ResultDO<List<ClassScoreVO>>(false, getClassroomDOByIdResultDO.getCode(),
                    getClassroomDOByIdResultDO.getMsg(), null);
            }

        }
        // 构建VO
        List<ClassScoreVO> list = new ArrayList<>();
        for (LessonDO lessonDO : lessonDOList) {
            ClassScoreVO classScoreVO = new ClassScoreVO();
            classScoreVO.setLessonDO(lessonDO);
            classScoreVO.setClassroomDO(classQualityService.getClassroomDOById(lessonDO.getClassroomId()).getModule());
            classScoreVO.setCourseDO(classQualityService.getCourseDOById(lessonDO.getCourseId()).getModule());
            ResultDO<ClassScoreDO> getClassScoreDOByUserIdAndLessonIdResultDO =
                classQualityService.getClassScoreDOByUserIdAndLessonId(userId,
                    lessonDO.getId());
            if (getClassScoreDOByUserIdAndLessonIdResultDO.isSuccess() == false) {
                // 没有状态检测
                if (getClassScoreDOByUserIdAndLessonIdResultDO.getCode() == ResultCode.DB_ERROR) {
                    continue;
                }
                return new ResultDO<List<ClassScoreVO>>(false, getClassScoreDOByUserIdAndLessonIdResultDO.getCode(),
                    getClassScoreDOByUserIdAndLessonIdResultDO.getMsg(), null);
            }
            classScoreVO.setClassScoreDO(getClassScoreDOByUserIdAndLessonIdResultDO.getModule());
            list.add(classScoreVO);
        }
        return new ResultDO<List<ClassScoreVO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
    }

}
