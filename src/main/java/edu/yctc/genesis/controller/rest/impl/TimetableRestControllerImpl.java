package edu.yctc.genesis.controller.rest.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.yctc.genesis.constant.ResultCode;
import edu.yctc.genesis.controller.rest.TimetableRestController;
import edu.yctc.genesis.controller.session.SessionContentHolder;
import edu.yctc.genesis.entity.ClassDO;
import edu.yctc.genesis.entity.ClassroomDO;
import edu.yctc.genesis.entity.CourseDO;
import edu.yctc.genesis.entity.LessonDO;
import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.entity.transfer.CourseDTO;
import edu.yctc.genesis.service.TimetableIService;
import edu.yctc.genesis.vo.TeachingScheduleVO;
import edu.yctc.genesis.vo.TimetableVO;

@RestController
@ComponentScan({"edu.yctc.genesis.service"})
@RequestMapping("/resttimetable")
@Async
/**
 * manageRestController实现
 *
 * @author 15272
 */
public class TimetableRestControllerImpl implements TimetableRestController {

    @Resource
    TimetableIService timetableService;

    @Override
    @PostMapping("get-timetable-4-student")
    public ResultDO<List<TimetableVO>> getTimetable4Student(HttpSession httpSession) {
        long userId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
        if (userId <= 0) {
            return new ResultDO<List<TimetableVO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<List<LessonDO>> getLessonDOByUserIdResultDO = timetableService.getLessonDOListByUserId4Student(userId);
        if (getLessonDOByUserIdResultDO.isSuccess() == false) {
            return new ResultDO<List<TimetableVO>>(false, getLessonDOByUserIdResultDO.getCode(),
                getLessonDOByUserIdResultDO.getMsg(), null);
        }
        // lessonDO集
        List<LessonDO> lessonDOList = getLessonDOByUserIdResultDO.getModule();
        // 参数验证
        for (LessonDO lessonDO : lessonDOList) {
            if (lessonDO.getId() <= 0 || lessonDO.getNumber() <= 0 || lessonDO.getClassroomId() <= 0
                || lessonDO.getCourseId() <= 0) {
                return new ResultDO<List<TimetableVO>>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
            }
            // 存在性验证
            ResultDO<CourseDO> getCourseDOByIdResultDO = timetableService.getCourseDOById(lessonDO.getCourseId());
            if (getCourseDOByIdResultDO.isSuccess() == false) {
                return new ResultDO<List<TimetableVO>>(false, getCourseDOByIdResultDO.getCode(),
                    getCourseDOByIdResultDO.getMsg(), null);
            }
            ResultDO<ClassroomDO> getClassroomDOByIdResultDO =
                timetableService.getClassroomDOById(lessonDO.getClassroomId());
            if (getClassroomDOByIdResultDO.isSuccess() == false) {
                return new ResultDO<List<TimetableVO>>(false, getClassroomDOByIdResultDO.getCode(),
                    getClassroomDOByIdResultDO.getMsg(), null);
            }
        }
        // 构建VO
        List<TimetableVO> curriculumVOList = new ArrayList<>();
        for (LessonDO lessonDO : lessonDOList) {
            TimetableVO curriculumVO = new TimetableVO();
            curriculumVO.setCourseDO(timetableService.getCourseDOById(lessonDO.getCourseId()).getModule());
            curriculumVO.setClassroomDO(timetableService.getClassroomDOById(lessonDO.getClassroomId()).getModule());
            curriculumVO.setLessonDO(lessonDO);
            curriculumVO.setTeacherName(timetableService.getTeacherNameByLessonId(lessonDO.getId()).getModule());
            curriculumVOList.add(curriculumVO);
        }
        return new ResultDO<List<TimetableVO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, curriculumVOList);
    }

    @Override
    @PostMapping("get-timetable-4-teacher")
    public ResultDO<List<TeachingScheduleVO>> getTimetable4Teacher(HttpSession httpSession) {
        long userId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
        if (userId <= 0) {
            return new ResultDO<List<TeachingScheduleVO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        // lessonDO集
        ResultDO<List<LessonDO>> getLessonDOListByUserIdResultDO =
            timetableService.getLessonDOListByUserId4Teacher(userId);
        if (getLessonDOListByUserIdResultDO.isSuccess() == false) {
            return new ResultDO<List<TeachingScheduleVO>>(false, getLessonDOListByUserIdResultDO.getCode(),
                getLessonDOListByUserIdResultDO.getMsg(), null);
        }
        List<LessonDO> lessonDOList = getLessonDOListByUserIdResultDO.getModule();
        for (LessonDO lessonDO : lessonDOList) {
            // 参数验证
            if (lessonDO.getId() <= 0 || lessonDO.getNumber() <= 0 || lessonDO.getClassroomId() <= 0
                || lessonDO.getCourseId() <= 0) {
                return new ResultDO<List<TeachingScheduleVO>>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
            }
            // 存在性验证
            ResultDO<CourseDO> getCourseDOByIdResultDO = timetableService.getCourseDOById(lessonDO.getCourseId());
            if (getCourseDOByIdResultDO.isSuccess() == false) {
                return new ResultDO<List<TeachingScheduleVO>>(false, getCourseDOByIdResultDO.getCode(),
                    getCourseDOByIdResultDO.getMsg(), null);
            }
            ResultDO<ClassroomDO> getClassroomDOByIdResultDO =
                timetableService.getClassroomDOById(lessonDO.getClassroomId());
            if (getClassroomDOByIdResultDO.isSuccess() == false) {
                return new ResultDO<List<TeachingScheduleVO>>(false, getClassroomDOByIdResultDO.getCode(),
                    getClassroomDOByIdResultDO.getMsg(), null);
            }
        }
        // 构建VO
        List<TeachingScheduleVO> teachingScheduleVOList = new ArrayList<>();
        for (LessonDO lessonDO : lessonDOList) {
            TeachingScheduleVO teachingScheduleVO = new TeachingScheduleVO();
            ClassroomDO classroomDO = timetableService.getClassroomDOById(lessonDO.getClassroomId()).getModule();
            CourseDO courseDO = timetableService.getCourseDOById(lessonDO.getCourseId()).getModule();
            teachingScheduleVO.setLessonDO(lessonDO);
            teachingScheduleVO.setClassroomDO(classroomDO);
            teachingScheduleVO.setCourseDO(courseDO);
            // 转换为DTO，得到classId集
            CourseDTO courseDTO = new CourseDTO(courseDO);
            // 解析上课班级
            List<Long> classIdList = courseDTO.getClassId();
            List<ClassDO> classDOList = new ArrayList<>();
            for (long id : classIdList) {
                ClassDO classDO = timetableService.getClassDOById(id).getModule();
                classDOList.add(classDO);
            }
            teachingScheduleVO.setClassDOList(classDOList);
            teachingScheduleVOList.add(teachingScheduleVO);
        }
        return new ResultDO<List<TeachingScheduleVO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            teachingScheduleVOList);
    }

}
