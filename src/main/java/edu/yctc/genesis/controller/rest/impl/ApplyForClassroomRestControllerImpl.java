package edu.yctc.genesis.controller.rest.impl;

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
import edu.yctc.genesis.controller.rest.ApplyForClassroomRestController;
import edu.yctc.genesis.entity.CourseDO;
import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.service.ApplyForClassroomIService;
import edu.yctc.genesis.vo.ApplyClassroomVO;
import edu.yctc.genesis.vo.ClassroomDOAndBuildingAndFloorVO;
import edu.yctc.genesis.vo.YearAndTermAndCourseVO;
import edu.yctc.genesis.vo.YearAndTermVO;

@RestController
@ComponentScan({"edu.yctc.genesis.service"})
@RequestMapping("/restapplyforclassroom")
@Async
/**
 * applyforclassroomrest接口实现
 * 
 * @author frq
 */
public class ApplyForClassroomRestControllerImpl implements ApplyForClassroomRestController {

    @Autowired
    private ApplyForClassroomIService applyForClassroomService;

    @Override
    @PostMapping("get-years")
    public ResultDO<List<String>> getYears() {
        return applyForClassroomService.getYears();
    }

    @Override
    @PostMapping("get-term-by-year")
    public ResultDO<List<String>> getTermByYear(@RequestBody String year) {
        if (StringUtils.isBlank(year) == true) {
            return new ResultDO<List<String>>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        return applyForClassroomService.getTermByYear(year);
    }

    @Override
    @PostMapping("get-course-by-year-and-term")
    public ResultDO<List<String>> getCourseByYearAndTermVO(@RequestBody YearAndTermVO yearAndTermVO) {
        if (StringUtils.isBlank(yearAndTermVO.getYear())
            || (yearAndTermVO.getTerm() != Term.FIRSTSEMESTER && yearAndTermVO.getTerm() != Term.SECONDSEMESTER)) {
            return new ResultDO<List<String>>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        return applyForClassroomService.getCourseByYearAndTerm(yearAndTermVO.getYear(), yearAndTermVO.getTerm());
    }

    @Override
    @PostMapping("get-coursedo-by-year-and-term-and-course")
    public ResultDO<CourseDO>
        getCourseDOByYearAndTermAndCourseVO(@RequestBody YearAndTermAndCourseVO yearAndTermAndCourseVO) {
        if (StringUtils.isBlank(yearAndTermAndCourseVO.getYear())
            || (yearAndTermAndCourseVO.getTerm() != Term.FIRSTSEMESTER
                && yearAndTermAndCourseVO.getTerm() != Term.SECONDSEMESTER)
            || (StringUtils.isBlank(yearAndTermAndCourseVO.getCourseName()))) {
            return new ResultDO<CourseDO>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        return applyForClassroomService.getCourseDOByYearAndTermAndCourse(yearAndTermAndCourseVO.getYear(),
            yearAndTermAndCourseVO.getTerm(),
            yearAndTermAndCourseVO.getCourseName());
    }

    @Override
    @PostMapping("get-freeclassroomdo-and-building-and-floorvo-by-lessontime")
    public ResultDO<List<ClassroomDOAndBuildingAndFloorVO>>
        getClassroomDOAndBuildingAndFloorVOByLessonTime(@RequestBody String lessonTime) {
        if (StringUtils.isBlank(lessonTime)) {
            return new ResultDO<List<ClassroomDOAndBuildingAndFloorVO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        return applyForClassroomService.getFreeClassroomDOAndBuildingAndFloorVOByLessonTime(lessonTime);
    }

    @Override
    @PostMapping("apply-classroom")
    public ResultDO<Void> applyClassroom(@RequestBody ApplyClassroomVO applyClassroomVO) {
        if ((applyClassroomVO.getTeacherId() <= 0) || (applyClassroomVO.getNumber() <= 0)
            || (applyClassroomVO.getClassroomId() <= 0) || (StringUtils.isBlank(applyClassroomVO.getCourseName()))
            || (StringUtils.isBlank(applyClassroomVO.getLessonTime()))) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        return applyForClassroomService.applyClassroom(applyClassroomVO);
    }
}
