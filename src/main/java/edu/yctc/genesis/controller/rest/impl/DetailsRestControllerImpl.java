package edu.yctc.genesis.controller.rest.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.yctc.genesis.constant.ResultCode;
import edu.yctc.genesis.constant.entity.term.Term;
import edu.yctc.genesis.controller.rest.DetailsRestController;
import edu.yctc.genesis.entity.CourseDO;
import edu.yctc.genesis.entity.LessonDO;
import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.entity.UserDO;
import edu.yctc.genesis.service.DetailsIService;
import edu.yctc.genesis.vo.AcademyAndClassesVO;
import edu.yctc.genesis.vo.CourseAndAttendanceRateAndScoreVO;
import edu.yctc.genesis.vo.CourseDOAndUrlVO;
import edu.yctc.genesis.vo.LessonDOAndUrlVO;
import edu.yctc.genesis.vo.LessonDetailsVO;
import edu.yctc.genesis.vo.ModifyAttendanceStateVO;
import edu.yctc.genesis.vo.StudentAndAttendanceRateAndScoreVO;
import edu.yctc.genesis.vo.StudentAndAttendanceStateAndScoreVO;
import edu.yctc.genesis.vo.StudentDOAndUrlVO;
import edu.yctc.genesis.vo.UserIdAndYearAndTermVO;

@RestController
@ComponentScan({"edu.yctc.genesis.service"})
@RequestMapping("/restdetails")
@Async
/**
 * detailsrest接口实现
 *
 * @author wlt
 */
public class DetailsRestControllerImpl implements DetailsRestController {

    private static final String COURSE_DETAILS_DETAILS = "/genesis/teaching/course-details-details?id=";

    private static final String LESSON_DETAILS_DETAILS = "/genesis/teaching/lesson-details-details?id=";

    private static final String STUDENT_DETAILS_DETAILS = "/genesis/teaching/student-details-details?id=";

    @Autowired
    private DetailsIService detailsService;

    @Override
    @PostMapping("get-coursedo-by-year-and-term-and-userid")
    public ResultDO<List<CourseDOAndUrlVO>>
        getCourseDOByYearAndTermAndUserId(@RequestBody UserIdAndYearAndTermVO userIdAndYearAndTermVO) {
        if ((userIdAndYearAndTermVO.getUserId() <= 0) || (StringUtils.isBlank(userIdAndYearAndTermVO.getYear()))
            || (userIdAndYearAndTermVO.getTerm() != Term.FIRSTSEMESTER
                && userIdAndYearAndTermVO.getTerm() != Term.SECONDSEMESTER)) {
            return new ResultDO<List<CourseDOAndUrlVO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        long userId = userIdAndYearAndTermVO.getUserId();
        String year = userIdAndYearAndTermVO.getYear();
        int term = userIdAndYearAndTermVO.getTerm();
        ResultDO<List<CourseDO>> resultDO = detailsService.getCourseDOByUserIdAndYearAndTerm(userId, year, term);
        if (resultDO.isSuccess() == false) {
            return new ResultDO<List<CourseDOAndUrlVO>>(false, resultDO.getCode(), resultDO.getMsg(), null);
        }
        List<CourseDO> courseDOList = resultDO.getModule();
        List<CourseDOAndUrlVO> courseDOAndUrlVOList = new ArrayList<>();
        for (CourseDO courseDO : courseDOList) {
            CourseDOAndUrlVO courseDOAndUrlVO = new CourseDOAndUrlVO();
            courseDOAndUrlVO.setCourseDO(courseDO);
            courseDOAndUrlVO.setUrl(COURSE_DETAILS_DETAILS + courseDO.getId());
            courseDOAndUrlVOList.add(courseDOAndUrlVO);
        }
        return new ResultDO<List<CourseDOAndUrlVO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            courseDOAndUrlVOList);
    }

    @Override
    @PostMapping("get-coursedo-by-teacherid-list")
    public ResultDO<List<String>> getCourseDOByTeacherId(@RequestBody long teacherId) {
//        System.out.println("通过id获得老师id遍历 获得课程名"+teacherId);
        if (teacherId <= 0) {
            return new ResultDO<List<String>>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        ResultDO<List<String>> courseNamesResultDO = detailsService.getCoursesByTeacherId(teacherId);
        if (courseNamesResultDO.isSuccess() == false) {
            return new ResultDO<List<String>>(false, courseNamesResultDO.getCode(), courseNamesResultDO.getMsg(), null);
        }
        List<String> courseNameList = courseNamesResultDO.getModule();
        return new ResultDO<List<String>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, courseNameList);
    }

    @Override
    @PostMapping("get-lessondo-by-coursename-list")
    public ResultDO<List<LessonDOAndUrlVO>> getLessonDOByCourseName(@RequestBody String courseName) {
        if ((StringUtils.isBlank(courseName))) {
            return new ResultDO<List<LessonDOAndUrlVO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<List<LessonDO>> resultDO = detailsService.getLessonDOByCourseName(courseName);
        if (resultDO.isSuccess() == false) {
            return new ResultDO<List<LessonDOAndUrlVO>>(false, resultDO.getCode(), resultDO.getMsg(), null);
        }
        List<LessonDO> lessonDOList = resultDO.getModule();
        List<LessonDOAndUrlVO> courseDOAndUrlVOList = new ArrayList<>();
        for (LessonDO lessonDO : lessonDOList) {
            LessonDOAndUrlVO lessonDOAndUrlVO = new LessonDOAndUrlVO();
            lessonDOAndUrlVO.setLessonDO(lessonDO);
            lessonDOAndUrlVO.setUrl(LESSON_DETAILS_DETAILS + lessonDO.getId());
            courseDOAndUrlVOList.add(lessonDOAndUrlVO);
        }
        return new ResultDO<List<LessonDOAndUrlVO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            courseDOAndUrlVOList);
    }

    @Override
    @PostMapping("get-studentdo-by-academy-and-classes")
    public ResultDO<List<StudentDOAndUrlVO>>
        getStudentDOByAcademyAndClassesVO(@RequestBody AcademyAndClassesVO academyAndClassesVO) {
        String academy = academyAndClassesVO.getAcademy();
        String classes = academyAndClassesVO.getClasses();
        if (StringUtils.isBlank(academy) || StringUtils.isBlank(classes)) {
            return new ResultDO<List<StudentDOAndUrlVO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<List<UserDO>> resultDO = detailsService.getStudentDOByAcademyAndClasses(academy, classes);
        if (resultDO.isSuccess() == false) {
            return new ResultDO<List<StudentDOAndUrlVO>>(false, resultDO.getCode(), resultDO.getMsg(), null);
        }
        List<StudentDOAndUrlVO> list = new ArrayList<>();
        List<UserDO> studentDOList = resultDO.getModule();
        // 给VO的studentDO和url属性赋值
        for (UserDO studentDO : studentDOList) {
            StudentDOAndUrlVO studentDOAndUrlVO = new StudentDOAndUrlVO();
            studentDOAndUrlVO.setUserDO(studentDO);
            studentDOAndUrlVO.setUrl(STUDENT_DETAILS_DETAILS + studentDO.getId());
            list.add(studentDOAndUrlVO);
        }
        return new ResultDO<List<StudentDOAndUrlVO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
    }

    @Override
    @PostMapping("get-course-and-attendancerate-and-scorevo-by-studentid")
    public ResultDO<List<CourseAndAttendanceRateAndScoreVO>>
        getCourseAndAttendanceRateAndScoreVOByStudentId(@RequestBody long studentId) {
        if (studentId <= 0) {
            return new ResultDO<List<CourseAndAttendanceRateAndScoreVO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<List<CourseAndAttendanceRateAndScoreVO>> resultDO =
            detailsService.getCourseAndAttendanceRateAndScoreVOByStudentId(studentId);
        if (resultDO.isSuccess() == false) {
            return new ResultDO<List<CourseAndAttendanceRateAndScoreVO>>(false, resultDO.getCode(), resultDO.getMsg(),
                null);
        }
        List<CourseAndAttendanceRateAndScoreVO> list = resultDO.getModule();
        return new ResultDO<List<CourseAndAttendanceRateAndScoreVO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            list);
    }

    @Override
    @PostMapping("get-course-and-attendancerate-and-scorevo-by-courseid")
    public ResultDO<CourseAndAttendanceRateAndScoreVO>
        getCourseAndAttendanceRateAndScoreVOByCourseId(@RequestBody long courseId) {
        if (courseId <= 0) {
            return new ResultDO<CourseAndAttendanceRateAndScoreVO>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<CourseAndAttendanceRateAndScoreVO> resultDO =
            detailsService.getCourseAndAttendanceRateAndScoreVOByCourseId(courseId);
        if (resultDO.isSuccess() == false) {
            return new ResultDO<CourseAndAttendanceRateAndScoreVO>(false, resultDO.getCode(), resultDO.getMsg(), null);
        }
        CourseAndAttendanceRateAndScoreVO courseAndAttendanceRateAndScoreVO = resultDO.getModule();
        return new ResultDO<CourseAndAttendanceRateAndScoreVO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            courseAndAttendanceRateAndScoreVO);
    }

    @Override
    @PostMapping("get-every-student-attendance-detail-by-courseid")
    public ResultDO<List<StudentAndAttendanceRateAndScoreVO>>
        getEveryStudentAttendanceDetailByCourseId(@RequestBody long courseId) {
        if (courseId <= 0) {
            return new ResultDO<List<StudentAndAttendanceRateAndScoreVO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<List<StudentAndAttendanceRateAndScoreVO>> resultDO =
            detailsService.getStudentAndAttendanceRateAndScoreVOByCourseId(courseId);
        if (resultDO.isSuccess() == false) {
            return new ResultDO<List<StudentAndAttendanceRateAndScoreVO>>(false, resultDO.getCode(), resultDO.getMsg(),
                null);
        }
        List<StudentAndAttendanceRateAndScoreVO> list = resultDO.getModule();
        return new ResultDO<List<StudentAndAttendanceRateAndScoreVO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            list);
    }

    @Override
    @PostMapping("get-lessondetailsvo-by-lessonid-list")
    public ResultDO<LessonDetailsVO> getLessonDetailsVOByLessonId(@RequestBody long lessonId) {
        if (lessonId <= 0) {
            return new ResultDO<LessonDetailsVO>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        ResultDO<LessonDetailsVO> resultDO = detailsService.getLessonDetailsVOByLessonId(lessonId);
        if (resultDO.isSuccess() == false) {
            return new ResultDO<LessonDetailsVO>(false, resultDO.getCode(), resultDO.getMsg(), null);
        }
        LessonDetailsVO lessonDetailsVO = resultDO.getModule();
        return new ResultDO<LessonDetailsVO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, lessonDetailsVO);
    }

    @Override
    @PostMapping("get-every-student-attendance-detail-by-lessonid")
    public ResultDO<List<StudentAndAttendanceStateAndScoreVO>>
        getEveryStudentAttendanceDetailByLessonId(@RequestBody long lessonId) {
        if (lessonId <= 0) {
            return new ResultDO<List<StudentAndAttendanceStateAndScoreVO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<List<StudentAndAttendanceStateAndScoreVO>> resultDO =
            detailsService.getEveryStudentAttendanceDetailByLessonId(lessonId);
        if (resultDO.isSuccess() == false) {
            return new ResultDO<List<StudentAndAttendanceStateAndScoreVO>>(false, resultDO.getCode(), resultDO.getMsg(),
                null);
        }
        List<StudentAndAttendanceStateAndScoreVO> list = resultDO.getModule();
        return new ResultDO<List<StudentAndAttendanceStateAndScoreVO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            list);
    }

    @Override
    @PostMapping("modify-attendance-state")
    public ResultDO<String> modifyAttendanceState(@RequestBody ModifyAttendanceStateVO modifyAttendanceStateVO) {
        if ((modifyAttendanceStateVO.getUserId() <= 0) || (modifyAttendanceStateVO.getLessonId() <= 0)
            || (modifyAttendanceStateVO.getAttendState() == null)) {
            return new ResultDO<String>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        long userId = modifyAttendanceStateVO.getUserId();
        long lessonId = modifyAttendanceStateVO.getLessonId();
        String attendState = modifyAttendanceStateVO.getAttendState();
        ResultDO<String> resultDO = detailsService.modifyAttendanceState(userId, lessonId, attendState);
        if (resultDO.isSuccess() == false) {
            return new ResultDO<String>(false, resultDO.getCode(), resultDO.getMsg(), null);
        }
        attendState = resultDO.getModule();
        return new ResultDO<String>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, attendState);
    }

}
