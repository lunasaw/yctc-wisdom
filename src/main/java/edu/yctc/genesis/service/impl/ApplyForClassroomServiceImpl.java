package edu.yctc.genesis.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import edu.yctc.genesis.dao.*;
import edu.yctc.genesis.entity.*;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import edu.yctc.genesis.constant.ResultCode;
import edu.yctc.genesis.constant.entity.term.Term;
import edu.yctc.genesis.constant.entity.year.Year;
import edu.yctc.genesis.service.ApplyForClassroomIService;
import edu.yctc.genesis.service.LessonIService;
import edu.yctc.genesis.service.NewsIService;
import edu.yctc.genesis.vo.ApplyClassroomVO;
import edu.yctc.genesis.vo.ClassroomDOAndBuildingAndFloorVO;

@ComponentScan({"edu.yctc.genesis.dao"})
@Service("applyForClassroomService")
/**
 * service接口实现
 * 
 * @author frq
 */
public class ApplyForClassroomServiceImpl implements ApplyForClassroomIService {

    private final static Logger LOG = LoggerFactory.getLogger("serviceLogger");

    @Resource
    private CourseDAO courseDAO;

    @Resource
    private ClassroomDAO classroomDAO;

    @Resource
    private ClassroomStateDAO classroomStateDAO;

    @Resource
    private LessonDAO lessonDAO;

    @Resource
    private TeacherLessonDAO teacherLessonDAO;

    @Resource
    private BuildingFloorDAO buildingFloorDAO;

    @Resource
    private UserDAO userDAO;

    @Autowired
    private NewsIService newsService;

    @Autowired
    private LessonIService lessonService;

    @Resource
    private AttendanceDAO attendanceDAO;

    @Resource
    private ClassScoreDAO classScoreDAO;

    private static final String TITLE = "上课通知!";

    private static final String CONTENT = "老师有新授课计划,请注意查看课表.该通知由系统自动推送.";

    @Override
    public ResultDO<List<String>> getYears() {
        try {
            // 学年枚举
            List<String> list = Year.ALL_YEAR;
            LOG.info("get years success, list={}", list);
            return new ResultDO<List<String>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
        } catch (Exception e) {
            LOG.error("get years error, list={}", courseDAO.getYears(), e);
            return new ResultDO<List<String>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    @Override
    public ResultDO<List<String>> getTermByYear(String year) {
        if (StringUtils.isBlank(year) == true) {
            LOG.error("get term by year fail, year is blank, year={}", year);
            return new ResultDO<List<String>>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        try {
            List<String> list = courseDAO.getTermByYear(year);
            LOG.info("get term by year success, year={}", year);
            return new ResultDO<List<String>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
        } catch (Exception e) {
            LOG.error("get term by year error, year={}", year, e);
            return new ResultDO<List<String>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    @Override
    public ResultDO<List<String>> getCourseByYearAndTerm(String year, int term) {
        if (StringUtils.isBlank(year) || (term != Term.FIRSTSEMESTER && term != Term.SECONDSEMESTER)) {
            LOG.error("get course by year and term fail, parameter invalid, year={}, term={}", year, term);
            return new ResultDO<List<String>>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        try {
            List<String> list = courseDAO.getCourseByYearAndTerm(year, term);
            LOG.info("get term by year success, year={}", year);
            return new ResultDO<List<String>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
        } catch (Exception e) {
            LOG.error("get term by year error, year={}", year, e);
            return new ResultDO<List<String>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    @Override
    public ResultDO<CourseDO> getCourseDOByYearAndTermAndCourse(String year, int term, String courseName) {
        try {
            CourseDO courseDO = courseDAO.getCourseDOByYearAndTermAndCourse(year, term, courseName);
            if (courseDO == null) {
                LOG.info("getCourseDOByYearAndTermAndCourse error,no such courseDO, year={}, term={}, courseName={}",
                    year, term, courseName);
                return new ResultDO<>(false, ResultCode.NO_SUCH_COURSE, ResultCode.MSG_NO_SUCH_COURSE, null);
            }
            LOG.info("getCourseDOByYearAndTermAndCourse success, year={}, term={}, courseName={}", year, term,
                courseName);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, courseDO);
        } catch (Exception e) {
            LOG.info("getCourseDOByYearAndTermAndCourse error, year={}, term={}, courseName={}", year, term, courseName,
                e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION,
                null);
        }
    }

    @Override
    public ResultDO<List<ClassroomDOAndBuildingAndFloorVO>>
        getFreeClassroomDOAndBuildingAndFloorVOByLessonTime(String lessonTime) {
        if (StringUtils.isBlank(lessonTime)) {
            return new ResultDO<List<ClassroomDOAndBuildingAndFloorVO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        // 空闲教室ClassroomDOAndBuildingAndFloorVO列表
        List<ClassroomDOAndBuildingAndFloorVO> classroomDOAndBuildingAndFloorVOList =
            new LinkedList<ClassroomDOAndBuildingAndFloorVO>();
        try {
            // 从前端获得的选课时间
            Date lessonTimeFront = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            lessonTimeFront = sdf.parse(lessonTime);
            // 生成选课时间上课前100分钟时间,无时差
            Date lessonTimeBefore = new Date(lessonTimeFront.getTime() - 100 * 60 * 1000);
            // 生成选课时间下课后100分钟时间，无时差
            Date lessonTimeEnd = new Date(lessonTimeFront.getTime() + 100 * 60 * 1000);

            // 从数据库获得课时表
            List<LessonDO> lessonDOList = lessonDAO.getLessonDOs();
            LOG.info("get lessonDOList success, lessonDOList={}", lessonDOList);
            // 从数据获得教室Id表
            List<Long> classroomIdList = new LinkedList<Long>();
            classroomIdList.addAll(classroomDAO.getClassroomId());
            LOG.info("get classroomIdList success, classroomIdList={}", classroomIdList);
            // 从数据库获得的教室开始占用时间
            Date lessonTimeBack = null;
            // 空闲教室楼号层号
            Long buildingFloorId = null;

            // 遍历从数据库中获得的上课开始时间列表与前端获取的上课时间比较
            for (int i = 0; i < lessonDOList.size(); i++) {
                lessonTimeBack = lessonDOList.get(i).getBegin();// 真正的上课时间
                // 若教室开始占用时间大于等于选课时间减去100分钟并小于等于选课时间加100分钟，则教室为非空闲教室
                if (lessonTimeBack.getTime() >= lessonTimeBefore.getTime()
                    && lessonTimeBack.getTime() <= lessonTimeEnd.getTime()) {
                    Long classroomId = lessonDOList.get(i).getClassroomId();
                    // 删除classroomIdList中对应的Id（即非空闲教室Id）
                    for (Iterator<Long> iterator = classroomIdList.iterator(); iterator.hasNext();) {
                        if (iterator.next() == classroomId) {
                            iterator.remove();
                            break;
                        }
                    }
                    continue;
                }
            }
            // 遍历classroomIdList获得空闲教室列表
            for (int j = 0; j < classroomIdList.size(); j++) {
                // freeClassroomDO用于存放从数据库获得的ClassroomDO
                ClassroomDO freeClassroomDO = classroomDAO.getClassroomDOById(classroomIdList.get(j));
                LOG.info("get freeClassroomDO by id success, id={}, freeClassroomDO={}", classroomIdList.get(j),
                    freeClassroomDO);
                buildingFloorId = freeClassroomDO.getBuildingFloorId();
                BuildingFloorDO buildingFloorDO = buildingFloorDAO.getBuildingFloorDOById(buildingFloorId);
                LOG.info("get buildingFloorDO by id success, id={}, buildingFloorDO={}", buildingFloorId,
                    buildingFloorDO);
                // 空闲教室ClassroomDOAndBuildingAndFloorVO
                ClassroomDOAndBuildingAndFloorVO classroomDOAndBuildingAndFloorVO =
                    new ClassroomDOAndBuildingAndFloorVO();
                classroomDOAndBuildingAndFloorVO.setClassroomDO(freeClassroomDO);
                classroomDOAndBuildingAndFloorVO.setBuilding(buildingFloorDO.getBuilding());
                classroomDOAndBuildingAndFloorVO.setFloor(buildingFloorDO.getFloor());
                // 空闲教室ClassroomDOAndBuildingAndFloorVO列表添加元素
                classroomDOAndBuildingAndFloorVOList.add(classroomDOAndBuildingAndFloorVO);
            }
        } catch (Exception e) {
            LOG.error("get classroomDOAndBuildingAndFloorVO by lessonTime error, lessonTime={}", lessonTime, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION,
                null);
        }
        LOG.info(
            "get classroomDOAndBuildingAndFloorVO by lessonTime success, lessonTime={}, classroomDOAndBuildingAndFloorVOList={}",
            lessonTime, classroomDOAndBuildingAndFloorVOList);
        return new ResultDO<List<ClassroomDOAndBuildingAndFloorVO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            classroomDOAndBuildingAndFloorVOList);
    }

    @Override
    public ResultDO<Void> applyClassroom(ApplyClassroomVO applyClassroomVO) {
        // 参数校验
        if (applyClassroomVO == null || applyClassroomVO.getTeacherId() <= 0
            || StringUtils.isBlank(applyClassroomVO.getCourseName()) || applyClassroomVO.getNumber() <= 0
            || applyClassroomVO.getClassroomId() <= 0 || StringUtils.isBlank(applyClassroomVO.getLessonTime())) {
            LOG.info(
                "apply classroom fail, parameter invalid, applyClassroomVO={}, teacherId={}, courseName={}, number={}, classroomId={}, lessonTime={}",
                applyClassroomVO, applyClassroomVO.getTeacherId(), applyClassroomVO.getCourseName(),
                applyClassroomVO.getNumber(), applyClassroomVO.getClassroomId(), applyClassroomVO.getLessonTime());
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            // 通过选课课程名获得选课课程Id
            Long courseId = courseDAO.getCourseIdByName(applyClassroomVO.getCourseName());
            if (courseId == null) {
                LOG.info("getCourseIdByName error,no such course, courseName={}", applyClassroomVO.getCourseName());
                return new ResultDO<>(false, ResultCode.NO_SUCH_COURSE, ResultCode.MSG_NO_SUCH_COURSE, null);
            }
            LOG.info("getCourseIdByName success, courseId={}", courseId);
            // 获得教师Id
            long teacherId = applyClassroomVO.getTeacherId();
            // 把从前端获得的选课开始时间转化成数据库时间类型
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date begin = null;
            begin = sdf.parse(applyClassroomVO.getLessonTime());
            // 选课课程结束时间
            Calendar endTime = Calendar.getInstance();
            endTime.setTime(begin);
            // 选课开始时间加100分钟即为选课课程结束时间
            endTime.add(Calendar.MINUTE, 100);
            Date end = sdf.parse(sdf.format(endTime.getTime()));

            // 向数据库各表插入记录
            // 1.添加lesson表记录
            // 新建一个lessonDO存放课时记录
            LessonDO lessonDO = new LessonDO();
            lessonDO.setCourseId(courseId);
            lessonDO.setNumber(applyClassroomVO.getNumber());
            lessonDO.setClassroomId(applyClassroomVO.getClassroomId());
            lessonDO.setBegin(begin);
            lessonDO.setEnd(end);
            lessonDAO.insert(lessonDO);
            LOG.info("insert lessonDO success, lessonDO={}", lessonDO);
            // 返回lesson_id
            Long lessonId = lessonDO.getId();
            // 2.添加classroom_state表记录
            // 新建一个classroomStateDO存放教室状态记录
            ClassroomStateDO classroomStateDO = new ClassroomStateDO();
            classroomStateDO.setClassroomId(applyClassroomVO.getClassroomId());
            classroomStateDO.setLessonId(lessonId);
            classroomStateDO.setState(1);
            classroomStateDAO.insert(classroomStateDO);
            LOG.info("insert classroomStateDO success, classroomStateDO={}", classroomStateDO);
            // 3.添加teacher_lesson表记录
            // 新建一个teacherLessonDO存放教师课程记录
            TeacherLessonDO teacherLessonDO = new TeacherLessonDO();
            teacherLessonDO.setUserId(teacherId);
            teacherLessonDO.setLessonId(lessonId);
            teacherLessonDAO.insert(teacherLessonDO);

            LOG.info("insert teacherLessonDO success, teacherLessonDO={}", teacherLessonDO);
            LOG.info("apply classroom success, lessonDO={}", lessonDO);
            // 获取所有上课学生
            List<UserDO> userDOs = lessonService.getAllStudentsAtLesson(lessonId).getModule();
            List<Long> userIdList = new ArrayList<>();
            ClassScoreDO classScoreDO=new ClassScoreDO();
            AttendanceDO attendanceDO=new AttendanceDO();
            for (UserDO userDO : userDOs) {
                classScoreDO.setUserId(userDO.getId());
                classScoreDO.setLessonId(teacherLessonDO.getLessonId());
                classScoreDO.setScore(0);
                attendanceDO.setUserId(userDO.getId());
                attendanceDO.setLessonId(teacherLessonDO.getLessonId());
                attendanceDO.setAttendState(0);
                classScoreDAO.insert(classScoreDO);
                attendanceDAO.insert(attendanceDO);
                userIdList.add(userDO.getId());
            }
            // 发送通知给学生
            String name = userDAO.getUserDOById(teacherId).getName();
            newsService.sendNewsTOUserList(userIdList, TITLE, name + CONTENT);
            LOG.info("send news to userList success, title={}, content={}, userIdlist={}", TITLE, CONTENT, userIdList);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (DuplicateKeyException duplicateKeyException) {
            // 重复申请
            LOG.error("apply classroom error, duplicate entry, applyClassroomVO={}", applyClassroomVO,
                duplicateKeyException);
            return new ResultDO<>(false, ResultCode.DB_ERROR, ResultCode.MSG_DB_ERROR);
        } catch (Exception e) {
            LOG.error("apply classroom exception, applyClassroomVO{}", applyClassroomVO, e);
            return new ResultDO<>(false, ResultCode.DB_ERROR, ResultCode.MSG_DB_ERROR);
        }
    }
}
