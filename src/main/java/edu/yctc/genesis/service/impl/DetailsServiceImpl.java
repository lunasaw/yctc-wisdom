package edu.yctc.genesis.service.impl;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import edu.yctc.genesis.constant.ResultCode;
import edu.yctc.genesis.constant.entity.attendance.AttendState;
import edu.yctc.genesis.constant.entity.attendance.AttendStateName;
import edu.yctc.genesis.constant.entity.term.Term;
import edu.yctc.genesis.dao.AcademyDAO;
import edu.yctc.genesis.dao.AttendanceDAO;
import edu.yctc.genesis.dao.BuildingFloorDAO;
import edu.yctc.genesis.dao.ClassDAO;
import edu.yctc.genesis.dao.ClassScoreDAO;
import edu.yctc.genesis.dao.ClassroomDAO;
import edu.yctc.genesis.dao.CourseDAO;
import edu.yctc.genesis.dao.LessonDAO;
import edu.yctc.genesis.dao.ProfessionDAO;
import edu.yctc.genesis.dao.StudentCourseDAO;
import edu.yctc.genesis.dao.TeacherLessonDAO;
import edu.yctc.genesis.dao.UserDAO;
import edu.yctc.genesis.entity.BuildingFloorDO;
import edu.yctc.genesis.entity.ClassroomDO;
import edu.yctc.genesis.entity.CourseDO;
import edu.yctc.genesis.entity.LessonDO;
import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.entity.UserDO;
import edu.yctc.genesis.entity.transfer.CourseDTO;
import edu.yctc.genesis.service.DetailsIService;
import edu.yctc.genesis.vo.CourseAndAttendanceRateAndScoreVO;
import edu.yctc.genesis.vo.LessonDetailsVO;
import edu.yctc.genesis.vo.StudentAndAttendanceRateAndScoreVO;
import edu.yctc.genesis.vo.StudentAndAttendanceStateAndScoreVO;

@ComponentScan({"edu.yctc.genesis.dao"})
@Service("detailsService")
public class DetailsServiceImpl implements DetailsIService {

    private final static Logger LOG = LoggerFactory.getLogger("serviceLog");

    @Resource
    CourseDAO courseDAO;

    @Resource
    StudentCourseDAO studentCourseDAO;

    @Resource
    AttendanceDAO attendanceDAO;

    @Resource
    LessonDAO lessonDAO;

    @Resource
    TeacherLessonDAO teacherLessonDAO;

    @Resource
    ClassroomDAO classroomDAO;

    @Resource
    UserDAO userDAO;

    @Resource
    ClassDAO classDAO;

    @Resource
    ClassScoreDAO classScoreDAO;

    @Resource
    BuildingFloorDAO buildingFloorDAO;

    @Resource
    AcademyDAO academyDAO;

    @Resource
    ProfessionDAO professionDAO;

    // 通过userId(教师) 通过userId获得lessonId集 获得courseId集合 通过id和学年和学期查询课程
    @Override
    public ResultDO<List<CourseDO>> getCourseDOByUserIdAndYearAndTerm(long userId, String year, int term) {
        if (StringUtils.isBlank(year) || (term != Term.FIRSTSEMESTER && term != Term.SECONDSEMESTER) || userId <= 0) {
            LOG.error("get courseDO by userId and year and term fail, parameter invalid, userId={}, year={}, term={}",
                userId, year, term);
            return new ResultDO<List<CourseDO>>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        try {
            // 通过userId(教师)获得courseId集合
            List<Long> lessonIdList = teacherLessonDAO.getLessonIdsByUserId(userId);
            LOG.info("get lessonIds by userId success, userId={}, lessonIdList={}", userId, lessonIdList);
            List<Long> courseIdList = new LinkedList<Long>();
            for (int i = 0; i < lessonIdList.size(); i++) {
                long lessonId = lessonIdList.get(i);
                Long courseId = lessonDAO.getCourseIdById(lessonId);
                if (courseId == null) {
                    LOG.error("get courseId by lessonId fail, courseId is null, lessonId={}, courseId={}", lessonId,
                        courseId);
                    continue;
                }
                LOG.info("get courses by id success, lessonId={}, courseId={}", lessonId, courseId);
                courseIdList.add(courseId);
            }
            // 遍历courseIdList 排除重复courseId项
            List<Long> newCourseIdList = new LinkedList<Long>();
            for (Long id : courseIdList) {
                if (!newCourseIdList.contains(id)) {
                    newCourseIdList.add(id);
                }
            }
            LOG.info("get CourseIds By UserId success, courseIdList={}", courseIdList);
            List<CourseDO> list = new ArrayList<CourseDO>();
            int i; // 计数userId拥有的course总数
            int j = 0; // 计数userId拥有的非该学期的course总数
            for (i = 0; i < courseIdList.size(); i++) {
                // 通过courseId获得courseDO
                CourseDO course = courseDAO.getCourseDOByIdAndYearAndTerm(courseIdList.get(i), year, term);
                if (course != null) {
                    list.add(course);
                } else {
                    j++;
                }
            }
            if (i == j) {
                LOG.error("get courseDO by userId and year and term is null, userId={}, year={}, term={}", userId, year,
                    term);
                return new ResultDO<List<CourseDO>>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            }
            LOG.info("get courseDO by userId and year and term success, userId={}, year={}, term={}", userId, year,
                term);
            return new ResultDO<List<CourseDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
        } catch (Exception e) {
            LOG.error("get courseDO by userId and year and term error, userId={}, year={}, term={}", userId, year, term,
                e);
            return new ResultDO<List<CourseDO>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //通过id获得老师id遍历 获得课程名
    @Override
    public ResultDO<List<String>> getCoursesByTeacherId(long teacherId) {
//        System.out.println("通过id获得老师id遍历 获得课程名"+teacherId);
        if (teacherId <= 0) {
            LOG.error("get userIds by courseId and attendState fail, parameter invalid, teacherId={}", teacherId);
            return new ResultDO<List<String>>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        try {
            List<Long> lessonIdList = teacherLessonDAO.getLessonIdsByUserId(teacherId);
            LOG.info("get lessonIds by userId success, teacherId={}, lessonIdList={}", teacherId, lessonIdList);
            List<Long> courseIdList = new LinkedList<Long>();
            for (int i = 0; i < lessonIdList.size(); i++) {
                long lessonId = lessonIdList.get(i);
                Long courseId = lessonDAO.getCourseIdById(lessonId);
                if (courseId == null) {
                    LOG.error("get courseId by lessonId error, courserId is null, lessonId={}, courseId={}", lessonId,
                        courseId);
                    continue;
                }
                LOG.info("get courses by id success, lessonId={}, courseId={}", lessonId, courseId);
                courseIdList.add(courseId);
            }
            // 遍历courseIdList 排除重复courseId项
            List<Long> newCourseIdList = new LinkedList<Long>();
            for (Long id : courseIdList) {
                if (!newCourseIdList.contains(id)) {
                    newCourseIdList.add(id);
                }
            }
            List<String> courseNameList = new ArrayList<String>();
            for (int k = 0; k < newCourseIdList.size(); k++) {
                String courseName = courseDAO.getCourseNameById(newCourseIdList.get(k));
                LOG.info("get course name by id success, courseName={}", courseName);
                courseNameList.add(courseName);
            }
            if (courseNameList.size() == 0) {
                LOG.error("get courses by teacherId is null, teacherId={}", teacherId);
                return new ResultDO<List<String>>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            }
            return new ResultDO<List<String>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, courseNameList);
        } catch (Exception e) {
            LOG.error("get courses by teacherId error, teacherId={}", teacherId, e);
            return new ResultDO<List<String>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //课程名获得课程id  通过courseId获取该用户课堂集
    @Override
    public ResultDO<List<LessonDO>> getLessonDOByCourseName(String courseName) {
        if (StringUtils.isBlank(courseName)) {
            LOG.error("get lessonDO by courseId fail, parameter invalid, courseName={}", courseName);
            return new ResultDO<List<LessonDO>>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        try {
            long courseId = courseDAO.getIdByName(courseName);
            LOG.info("get courseId by courseName success, courseName={}, courseId={}", courseName, courseId);
            List<LessonDO> lessonDOList = lessonDAO.getLessonDOByCourseId(courseId);
            LOG.info("get lessonDO By courseId success, courseId={}, lessonDOList={}", courseId, lessonDOList);
            return new ResultDO<List<LessonDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, lessonDOList);
        } catch (Exception e) {
            LOG.error("get lessonDO by courseId error, courseName={}", courseName, e);
            return new ResultDO<List<LessonDO>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //通过课程id查找返回ClassroomId id查询教室
    @Override
    public ResultDO<ClassroomDO> getClassroomDOByLessonId(long lessonId) {
        if (lessonId <= 0) {
            LOG.error("get courseDO by lessonId fail, parameter invalid, lessonId={}", lessonId);
            return new ResultDO<ClassroomDO>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        try {
            long classroomId = lessonDAO.getClassroomIdById(lessonId);
            LOG.info("get classroomId by id success, lessonId={}, classroomId={}", lessonId, classroomId);
            ClassroomDO classroomDO = classroomDAO.getClassroomDOById(classroomId);
            LOG.info("get classroomDO by id success, classroomId={}, classroomDO={}", classroomId, classroomDO);
            return new ResultDO<ClassroomDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, classroomDO);
        } catch (Exception e) {
            LOG.error("get courseDO by lessonId error, lessonId={}", lessonId, e);
            return new ResultDO<ClassroomDO>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //通过学院id和班级号返回ClassDO   通过学院和班级返回学生集
    @Override
    public ResultDO<List<UserDO>> getStudentDOByAcademyAndClasses(String academy, String classes) {
        if (StringUtils.isBlank(academy) || StringUtils.isBlank(classes)) {
            LOG.error("get StudentDO by academy and classes fail, parameter invalid, academy={}, classes={}", academy,
                classes);
            return new ResultDO<List<UserDO>>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        try {
            long academyId = academyDAO.getAcademyDOByAcademy(academy).getId();
            LOG.info("getAcademyIdByAcademy success, academy={}, academyId={}", academy, academyId);
            long classId = classDAO.getClassDOByNumber(classes).getId();
            LOG.info("getClassIdByNumber success, classes={}, classId={}", classes, classId);
            List<UserDO> list = userDAO.getStudentDOByAcademyIdAndClassId(academyId, classId);
            if (list.size() == 0) {
                LOG.error("get StudentDO by academy and classes is null, academy={}, classes={}", academy, classes);
                return new ResultDO<List<UserDO>>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            }
            LOG.info("get StudentDO by academy and classes success, academy={}, classes={}", academy, classes);
            return new ResultDO<List<UserDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
        } catch (Exception e) {
            LOG.error("get StudentDO by academy and classes error, academy={}, classes={}", academy, classes, e);
            return new ResultDO<List<UserDO>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //通过userId查询,获得courseId集  id查询课程 通过id返回专业名称  获得班级名List 通过lessonId和userId获得attendState
    @Override
    public ResultDO<List<CourseAndAttendanceRateAndScoreVO>>
        getCourseAndAttendanceRateAndScoreVOByStudentId(long studentId) {
        if (studentId <= 0) {
            LOG.error("get courseAndAttendanceRateAndScoreVO by studentId fail, parameter invalid, studentId={}",
                studentId);
            return new ResultDO<List<CourseAndAttendanceRateAndScoreVO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        try {
            List<CourseAndAttendanceRateAndScoreVO> courseAndAttendanceRateAndScoreVOList =
                new LinkedList<CourseAndAttendanceRateAndScoreVO>();
            List<Long> courseIdList = studentCourseDAO.getCourseIdsByUserId(studentId);
            if (courseIdList.size() == 0) {
                LOG.error("get courseIds by userId is null, id={}", studentId);
                return new ResultDO<List<CourseAndAttendanceRateAndScoreVO>>(false,
                    ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA,
                    null);
            }
            LOG.info("get courseIds by userId success, Id={}, courseIdList={}", studentId, courseIdList);
            for (int i = 0; i < courseIdList.size(); i++) {
                // 1.获得courseDTO
                long courseId = courseIdList.get(i);
                CourseDO courseDO = courseDAO.getCourseDOById(courseId);
                if (courseDO == null) {
                    LOG.error("get courseDO by id is null, id={}", courseId);
                    return new ResultDO<List<CourseAndAttendanceRateAndScoreVO>>(false,
                        ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                        ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA,
                        null);
                }
                LOG.info("get courseDO by id success, id={}, courseDO={}", courseId, courseDO);
                CourseDTO courseDTO = new CourseDTO(courseDO);
                // 2.获得专业名
                long professionId = courseDTO.getProfessionId();
                String profession = professionDAO.getProfessionById(professionId);
                // 3.获得班级名List
                List<String> classNameList = new LinkedList<String>();
                String className;
                List<Long> classIdList = courseDTO.getClassId();
                for (int m = 0; m < classIdList.size(); m++) {
                    className = classDAO.getNumberById(classIdList.get(m));
                    classNameList.add(className);
                }
                List<Long> lessonIdList = lessonDAO.getIdsByCourseId(courseIdList.get(i));
                if (lessonIdList.size() == 0) {
                    LOG.error("get lessonIdList by courseId is null, courseId={}", courseId);
                    return new ResultDO<List<CourseAndAttendanceRateAndScoreVO>>(false,
                        ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                        ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA,
                        null);
                }
                LOG.info("get lessonIdList by courseId success, courseId={}, lessonIdList={}", courseId, lessonIdList);
                int attendanceSum = 0;// 出勤计数
                Double score;// 听课质量评分
                List<Integer> attendStateList = new LinkedList<Integer>();
                List<Double> scoreList = new LinkedList<Double>();
                for (int j = 0; j < lessonIdList.size(); j++) {
                    long lessonId = lessonIdList.get(j);
                    Integer attendState = attendanceDAO.getAttendStateByLessonIdAndUserId(lessonId, studentId);
                    if (attendState == null) {
                        LOG.error("get attendState by lessonId and userId is null, lessonId={}, studentId={}", lessonId,
                            studentId);
                        return new ResultDO<List<CourseAndAttendanceRateAndScoreVO>>(false,
                            ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                            ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA,
                            null);
                    }
                    LOG.info(
                        "get attendStates by lessonId and userId success, lessonIdList={}, studentId={}, attendStateList={}",
                        lessonIdList.get(j), studentId, attendStateList);
                    attendStateList.add(attendState);
                    long userId = studentId;
                    score = classScoreDAO.getScoreByLessonIdAndUserId(lessonId, userId);
                    if (score == null) {
                        LOG.error("get attendState by lessonId and userId is null, lessonId={}, userId={}", lessonId,
                            userId);
                        return new ResultDO<List<CourseAndAttendanceRateAndScoreVO>>(false,
                            ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                            ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA,
                            null);
                    }
                    scoreList.add(score);// 添加该门课程这一节课的成绩
                    LOG.info("get score by lessonId and userId success, lessonIdList={}, studentId={}, score={}",
                        lessonIdList.get(j), userId, score);
                }
                for (int k = 0; k < lessonIdList.size(); k++) {
                    if (attendStateList.get(k) == AttendState.ATTENDANCE) {
                        attendanceSum++;
                    }
                }
                // 4.计算获得出勤率attendanceRate
                double rate = (double)attendanceSum / (double)attendStateList.size();
                NumberFormat nt = NumberFormat.getPercentInstance();
                nt.setMinimumFractionDigits(2);// 设置百分数精确度2即保留两位小数
                String attendanceRate = nt.format(rate);
                // 5.计算获得听课质量评分的平均分scoreAve
                double scoreSum = 0;// 总分
                for (int m = 0; m < scoreList.size(); m++) {
                    scoreSum = scoreSum + scoreList.get(m);
                }
                double scoreAve = scoreSum / (double)scoreList.size();
                CourseAndAttendanceRateAndScoreVO courseAndAttendanceRateAndScoreVO =
                    new CourseAndAttendanceRateAndScoreVO();
                courseAndAttendanceRateAndScoreVO.setCourseDTO(courseDTO);
                courseAndAttendanceRateAndScoreVO.setClassNameList(classNameList);
                courseAndAttendanceRateAndScoreVO.setProfession(profession);
                courseAndAttendanceRateAndScoreVO.setAttendanceRate(attendanceRate);
                courseAndAttendanceRateAndScoreVO.setScore(scoreAve);
                courseAndAttendanceRateAndScoreVOList.add(courseAndAttendanceRateAndScoreVO);
            }
            LOG.info(
                "get courseAndAttendanceRateAndScoreVO by studentId success, studentId={}, courseAndAttendanceRateAndScoreVOList={}",
                studentId, courseAndAttendanceRateAndScoreVOList);
            return new ResultDO<List<CourseAndAttendanceRateAndScoreVO>>(true, ResultCode.SUCCESS,
                ResultCode.MSG_SUCCESS,
                courseAndAttendanceRateAndScoreVOList);
        } catch (Exception e) {
            LOG.error("get courseAndAttendanceRateAndScoreVO by studentId error, studentId={}", studentId, e);
            return new ResultDO<List<CourseAndAttendanceRateAndScoreVO>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //课程id 查询出勤
    @Override
    public ResultDO<CourseAndAttendanceRateAndScoreVO> getCourseAndAttendanceRateAndScoreVOByCourseId(long courseId) {
        if (courseId <= 0) {
            LOG.error("get courseAndAttendanceRateAndScoreVO by courseId fail, parameter invalid, studentId={}",
                courseId);
            return new ResultDO<CourseAndAttendanceRateAndScoreVO>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        try {
            // 1.获得courseDTO
            CourseDO courseDO = courseDAO.getCourseDOById(courseId);
            if (courseDO == null) {
                LOG.error("get courseDO by courseId is null, courseId={}", courseId);
                return new ResultDO<CourseAndAttendanceRateAndScoreVO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            }
            LOG.info("get CourseDO by id success, id={}, courseDO={}", courseId, courseDO);
            CourseDTO courseDTO = new CourseDTO(courseDO);
            // 2.获得专业名
            long professionId = courseDTO.getProfessionId();
            String profession = professionDAO.getProfessionById(professionId);
            // 3.获得classNameList
            List<String> classNameList = new LinkedList<String>();
            String className;
            List<Long> classIdList = courseDTO.getClassId();
            for (int m = 0; m < classIdList.size(); m++) {
                className = classDAO.getNumberById(classIdList.get(m));
                LOG.info("get classnumber by classid success, id={}, className={}", classIdList.get(m), className);
                classNameList.add(className);
            }
            // 4.获得出勤率和听课质量评分平均分
            List<Long> lessonIdList = lessonDAO.getIdsByCourseId(courseId);
            if (lessonIdList.size() == 0) {
                LOG.error("get lessonIdList by courseId is null, courseId={}", courseId);
                return new ResultDO<CourseAndAttendanceRateAndScoreVO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            }
            LOG.info("get lessonIdList by courseId success, courseId={}, lessonIdList={}", courseId, lessonIdList);
            int studentSum = 0;// 学生总数
            int attendanceSum = 0;// 出勤总数
            double scoreSum = 0;// 听课质量评分
            System.out.println(""+studentSum+attendanceSum+scoreSum);
            for (int i = 0; i < lessonIdList.size(); i++) {
                long lessonId = lessonIdList.get(i);
                List<Long> attendanceIdList = attendanceDAO.getIdsByLessonId(lessonId);
                if (attendanceIdList.size() == 0) {
                    LOG.error("get attendanceIds by lessonId and attendState is null, lessonId={}", lessonId);
                    return new ResultDO<CourseAndAttendanceRateAndScoreVO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                            ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA,
                            null);
                }
                LOG.info("get attendanceIds by lessonId and attendState success, lessonId={}, attendanceIdList={}",
                    lessonId, attendanceIdList);
                studentSum = studentSum + attendanceIdList.size();
                List<Integer> stateList = attendanceDAO.getAttendStatesByLessonId(lessonId);
                LOG.info("get attendStates by lessonId success, lessonId={}, stateList={}", lessonId, stateList);
                for (int j = 0; j < stateList.size(); j++) {
                    if (stateList.get(j) == AttendState.ATTENDANCE) {
                        attendanceSum++;
                    }
                }
                List<Double> scoreList = classScoreDAO.getScoresByLessonId(lessonId);
                LOG.info("get scores by lessonId success, lessonId={}, scoreList={}", lessonId, scoreList);
                for (int k = 0; k < scoreList.size(); k++) {
                    scoreSum = scoreSum + scoreList.get(k);
                }
            }
            // 计算获得出勤率attendanceRate
            double rate = (double)attendanceSum / (double)studentSum;
            NumberFormat nt = NumberFormat.getPercentInstance();
            nt.setMinimumFractionDigits(2);// 设置百分数精确度2即保留两位小数
            String attendanceRate = nt.format(rate);
            // 计算获得听课质量评分的平均分scoreAve
            double scoreAve = scoreSum / (double)studentSum;
            CourseAndAttendanceRateAndScoreVO courseAndAttendanceRateAndScoreVO =
                new CourseAndAttendanceRateAndScoreVO();
            courseAndAttendanceRateAndScoreVO.setCourseDTO(courseDTO);
            courseAndAttendanceRateAndScoreVO.setProfession(profession);
            courseAndAttendanceRateAndScoreVO.setClassNameList(classNameList);
            courseAndAttendanceRateAndScoreVO.setAttendanceRate(attendanceRate);
            courseAndAttendanceRateAndScoreVO.setScore(scoreAve);
            LOG.info(
                "get courseAndAttendanceRateAndScoreVO by couresId success, couresId={}, courseAndAttendanceRateAndScoreVO={}",
                courseId, courseAndAttendanceRateAndScoreVO);
            return new ResultDO<CourseAndAttendanceRateAndScoreVO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
                courseAndAttendanceRateAndScoreVO);
        } catch (Exception e) {
            LOG.error("get courseAndAttendanceRateAndScoreVO by couresId error, courseId={}", courseId, e);
            return new ResultDO<CourseAndAttendanceRateAndScoreVO>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //返回学生出席信息集合
    @Override
    public ResultDO<List<StudentAndAttendanceRateAndScoreVO>>
        getStudentAndAttendanceRateAndScoreVOByCourseId(long courseId) {
        if (courseId <= 0) {
            LOG.error("get courseAndAttendanceRateAndScoreVO by courseId fail, parameter invalid, studentId={}",
                courseId);
            return new ResultDO<List<StudentAndAttendanceRateAndScoreVO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        try {
            UserDO userDO;
            List<StudentAndAttendanceRateAndScoreVO> studentAndAttendanceRateAndScoreVOList =
                new LinkedList<StudentAndAttendanceRateAndScoreVO>();
            List<Long> userIdList = studentCourseDAO.getUserIdsByCourseId(courseId);
            if (userIdList.size() == 0) {
                LOG.error("get userIdList by courseId is null, courseId={}", courseId);
                return new ResultDO<List<StudentAndAttendanceRateAndScoreVO>>(false,
                    ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA,
                    null);
            }
            for (int n = 0; n < userIdList.size(); n++) {
                // 1.获得userDO(student)
                long userId = userIdList.get(n);
                userDO = userDAO.getUserDOById(userId);
                LOG.info("get userDAO by id success, userId={}, userDO={}", userId, userDO);
                // 2.获得班级、学院名
                String classNumber = classDAO.getNumberById(userDO.getClassId());
                LOG.info("get classNumber by id success, id={}, classNumber={}", userDO.getClassId(), classNumber);
                String academyName = academyDAO.getAcademyById(userDO.getAcademyId());
                LOG.info("get academyName by id success, id={}, academyName={}", userDO.getClassId(), academyName);
                // 3.获得出勤率 和 听课质量评分
                double scoreSum = 0; // 听课质量评分
                int sum = 0; // 所有学生的总数量
                int attendanceSum = 0;// 出勤总数
                long lessonId;
                Double score;
                List<Long> lessonIdList = lessonDAO.getIdsByCourseId(courseId);
                LOG.info("get lessonIdList by courseId success, courseId={}, lessonIdList={}", courseId, lessonIdList);
                for (int m = 0; m < lessonIdList.size(); m++) {
                    lessonId = lessonIdList.get(m);
                    attendanceSum = attendanceSum
                        + attendanceDAO.getSumByLessonIdAndUserIdAndAttendState(lessonId, userId,
                            AttendState.ATTENDANCE);
                    LOG.info(
                        "get sum by lessonId and userId and attendState success, lessonId={}, userId={}, attendState={} ",
                        courseId, lessonId, AttendState.ATTENDANCE);
                    sum = sum + attendanceDAO.getSumByLessonIdAndUserId(lessonId, userId);
                    LOG.info("get sum by lessonId and userId success, lessonId={}, userId={} ", courseId, lessonId);
                    score = classScoreDAO.getScoreByLessonIdAndUserId(lessonId, userId);
                    if (score == null) {
                        LOG.error("get score by lessonId fail, no such score, lessonId={}, userId={}", lessonId,
                            userId);
                        scoreSum += 0;
                    } else {
                        LOG.info("get score by lessonId and userId success, courseId={}, lessonIds={}, score={}",
                            courseId, lessonIdList, score);
                        scoreSum = scoreSum + score;
                    }

                }
                // 计算获得出勤率attendanceRate
                double rate = 0;
                if (sum == 0) {
                    rate = 0;
                } else
                    rate = (double)attendanceSum / (double)sum;
                NumberFormat nt = NumberFormat.getPercentInstance();
                nt.setMinimumFractionDigits(2);// 设置百分数精确度2即保留两位小数
                String attendanceRate = nt.format(rate);
                // 计算获得听课质量评分的平均分scoreAve
                double scoreAve = scoreSum / (double)sum;
                // 合成studentAndAttendanceRateAndScoreVO
                StudentAndAttendanceRateAndScoreVO studentAndAttendanceRateAndScoreVO =
                    new StudentAndAttendanceRateAndScoreVO();
                studentAndAttendanceRateAndScoreVO.setUserDO(userDO);
                studentAndAttendanceRateAndScoreVO.setAcademyName(academyName);
                studentAndAttendanceRateAndScoreVO.setClassNumber(classNumber);
                studentAndAttendanceRateAndScoreVO.setAttendanceRate(attendanceRate);
                studentAndAttendanceRateAndScoreVO.setScore(scoreAve);
                studentAndAttendanceRateAndScoreVOList.add(studentAndAttendanceRateAndScoreVO);
            }
            LOG.info(
                "get studentAndAttendanceRateAndScoreVOList by couresId success, couresId={}, studentAndAttendanceRateAndScoreVOList={}",
                courseId, studentAndAttendanceRateAndScoreVOList);
            return new ResultDO<List<StudentAndAttendanceRateAndScoreVO>>(true, ResultCode.SUCCESS,
                ResultCode.MSG_SUCCESS,
                studentAndAttendanceRateAndScoreVOList);
        } catch (Exception e) {
            LOG.error("get courseAndAttendanceRateAndScoreVO by couresId error, courseId={}", courseId, e);
            return new ResultDO<List<StudentAndAttendanceRateAndScoreVO>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //通过课程id获取课程LessonDetailsVO
    @Override
    public ResultDO<LessonDetailsVO> getLessonDetailsVOByLessonId(long lessonId) {
        System.out.println("通过课程id获取课程LessonDetailsVO-------------");
        if (lessonId <= 0) {
            LOG.error("get lessonDetailsVO by lessonId fail, parameter invalid, lessonId={}", lessonId);
            return new ResultDO<LessonDetailsVO>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        try {
            // 1.获得lessonDO
            LessonDO lessonDO = lessonDAO.getLessonDOById(lessonId);
            if (lessonDO == null) {
                LOG.error("get lessonDO by lessonId is null, lessonId={}", lessonId);
                return new ResultDO<LessonDetailsVO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            }
            // 2.获得courseDTO
            long courseId = lessonDAO.getCourseIdById(lessonId);
            if (courseId <= 0) {
                LOG.error("get CourseId by lessonId is null, lessonId={}", lessonId);
                return new ResultDO<LessonDetailsVO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            }
            CourseDO courseDO = courseDAO.getCourseDOById(courseId);
            if (courseDO == null) {
                LOG.error("get CourseDO by courseId is null, courseId={}", courseId);
                return new ResultDO<LessonDetailsVO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            }
            LOG.info("get CourseDO by lessonId success, lessonId={}, courseDO={}", lessonId, courseDO);
            CourseDTO courseDTO = new CourseDTO(courseDO);
            // 2.获得专业名
            long professionId = courseDTO.getProfessionId();
            String profession = professionDAO.getProfessionById(professionId);
            // 3.获得classNameList
            List<String> classNameList = new LinkedList<String>();
            String className;
            List<Long> classIdList = courseDTO.getClassId();
            for (int m = 0; m < classIdList.size(); m++) {
                className = classDAO.getNumberById(classIdList.get(m));
                LOG.info("get classNumber by classId success, id={}, className={}", classIdList.get(m), className);
                classNameList.add(className);
            }
            // 4.获取classroom
            long classroomId = lessonDO.getClassroomId();
            ClassroomDO classroomDO = classroomDAO.getClassroomDOById(classroomId);
            long buildingFloorId = classroomDO.getBuildingFloorId();
            BuildingFloorDO buildingFloorDO = buildingFloorDAO.getBuildingFloorDOById(buildingFloorId);
            String classroom = buildingFloorDO.getBuilding() + " " + classroomDO.getNumber();
            // 5.获得出勤率和听课质量评分
            List<Long> attendanceIdList = attendanceDAO.getIdsByLessonId(lessonId);
            if (attendanceIdList.size() == 0) {
                LOG.error("get attendanceIdList by lessonId and attendState is null, lessonId={}", lessonId);
                return new ResultDO<LessonDetailsVO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            }
            int studentSum = attendanceIdList.size();// 学生总数
            int attendanceSum = 0;// 出勤总数
            List<Integer> stateList = attendanceDAO.getAttendStatesByLessonId(lessonId);
            LOG.info("get attendStates by lessonId success, lessonId={}, stateList={}", lessonId, stateList);
            for (int j = 0; j < stateList.size(); j++) {
                if (stateList.get(j) == AttendState.ATTENDANCE) {
                    attendanceSum++;
                }
            }
            double scoreSum = 0;// 听课质量评分
            List<Double> scoreList = classScoreDAO.getScoresByLessonId(lessonId);
            LOG.info("get scores by lessonId success, lessonId={}, scoreList={}", lessonId, scoreList);
            for (int k = 0; k < scoreList.size(); k++) {
                scoreSum = scoreSum + scoreList.get(k);
            }
            // 计算获得出勤率attendanceRate
            double rate = (double)attendanceSum / (double)studentSum;
            NumberFormat nt = NumberFormat.getPercentInstance();
            nt.setMinimumFractionDigits(2);// 设置百分数精确度2即保留两位小数
            String attendanceRate = nt.format(rate);
            // 计算获得听课质量评分的平均分scoreAve
            double scoreAve = scoreSum / (double)studentSum;
            LessonDetailsVO lessonDetailsVO = new LessonDetailsVO();
            lessonDetailsVO.setCourseDTO(courseDTO);
            lessonDetailsVO.setLessonDO(lessonDO);
            lessonDetailsVO.setProfession(profession);
            lessonDetailsVO.setClassNameList(classNameList);
            lessonDetailsVO.setClassroom(classroom);
            lessonDetailsVO.setAttendanceRate(attendanceRate);
            lessonDetailsVO.setScore(scoreAve);
            LOG.info("get lessonDetailsVO by couresId success, lessonId={}, courseAndAttendanceRateAndScoreVO={}",
                lessonId, lessonDetailsVO);
            return new ResultDO<LessonDetailsVO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, lessonDetailsVO);
        } catch (Exception e) {
            LOG.error("get lessonDetailsVO by couresId error, lessonId={}", lessonId, e);
            return new ResultDO<LessonDetailsVO>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //通过课程id获取每个学生的出勤情况
    @Override
    public ResultDO<List<StudentAndAttendanceStateAndScoreVO>>
        getEveryStudentAttendanceDetailByLessonId(long lessonId) {
        if (lessonId <= 0) {
            LOG.error("get courseAndAttendanceRateAndScoreVO by courseId fail, parameter invalid, studentId={}",
                lessonId);
            return new ResultDO<List<StudentAndAttendanceStateAndScoreVO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        try {
            // 获得userDOList(student)
            UserDO userDO;
            long courseId = lessonDAO.getCourseIdById(lessonId);
            List<Long> userIdList = studentCourseDAO.getUserIdsByCourseId(courseId);
            if (userIdList.size() == 0) {
                LOG.error("get userIdList by courseId is null, courseId={}", courseId);
                return new ResultDO<List<StudentAndAttendanceStateAndScoreVO>>(false,
                    ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA,
                    null);
            }
            List<StudentAndAttendanceStateAndScoreVO> studentAndAttendanceRateAndScoreVOList =
                new LinkedList<StudentAndAttendanceStateAndScoreVO>();
            for (int n = 0; n < userIdList.size(); n++) {
                // 1.获得userDO(student)
                long userId = userIdList.get(n);
                userDO = userDAO.getUserDOById(userId);
                LOG.info("get userDAO by id success, userId={}, userDO={}", userId, userDO);
                // 2.获得班级、学院名
                String classNumber = classDAO.getNumberById(userDO.getClassId());
                LOG.info("get classNumber by id success, id={}, classNumber={}", userDO.getClassId(), classNumber);
                String academyName = academyDAO.getAcademyById(userDO.getAcademyId());
                LOG.info("get academyName by id success, id={}, academyName={}", userDO.getClassId(), academyName);
                // 3.获得state、classScore
                Integer attendanceState = attendanceDAO.getAttendStateByLessonIdAndUserId(lessonId, userId);
                if (attendanceState == null) {
                    LOG.error("get attendState by lessonId and userId fail, no such state, lessonId={}, userId={}",
                        lessonId, userId);
                }
                LOG.info("get attendState by lessonId and userId success, lessonId={}, userId={}, AttendanceState={}",
                    lessonId, userId, attendanceState);
                String state = "";
                if (attendanceState == null) {
                    state = AttendStateName.MISSING_DATA_NAME;
                } else if (attendanceState == AttendState.ATTENDANCE) {
                    state = AttendStateName.ATTENDANCE_NAME;
                } else if (attendanceState == AttendState.ABSENT) {
                    state = AttendStateName.ABSENT_NAME;
                } else if (attendanceState == AttendState.LATE) {
                    state = AttendStateName.LATE_NAME;
                } else if (attendanceState == AttendState.LEAVE_EARLY) {
                    state = AttendStateName.LEAVE_EARLY_NAME;
                }
                Double classScore = classScoreDAO.getScoreByLessonIdAndUserId(lessonId, userId);
                if (classScore == null) {
                    LOG.error("get classScore by lessonId and userId fail, no such score, lessonId={}, userId={}",
                        lessonId, userId);
                }
                LOG.info("get score by lessonId and userId success, lessonId={}, userId={}, classScore={}", courseId,
                    userId, classScore);
                // 合成studentAndAttendanceRateAndScoreVO
                StudentAndAttendanceStateAndScoreVO studentAndAttendanceStateAndScoreVO =
                    new StudentAndAttendanceStateAndScoreVO();
                studentAndAttendanceStateAndScoreVO.setUserDO(userDO);
                studentAndAttendanceStateAndScoreVO.setAcademyName(academyName);
                studentAndAttendanceStateAndScoreVO.setClassNumber(classNumber);
                studentAndAttendanceStateAndScoreVO.setAttendanceState(state);
                if (classScore == null)
                    studentAndAttendanceStateAndScoreVO.setScore(0);
                else
                    studentAndAttendanceStateAndScoreVO.setScore(classScore.doubleValue());
                studentAndAttendanceRateAndScoreVOList.add(studentAndAttendanceStateAndScoreVO);
            }
            LOG.info(
                "get studentAndAttendanceRateAndScoreVOList by couresId success, lessonId={}, studentAndAttendanceStateAndScoreVO={}",
                lessonId, studentAndAttendanceRateAndScoreVOList);
            return new ResultDO<List<StudentAndAttendanceStateAndScoreVO>>(true, ResultCode.SUCCESS,
                ResultCode.MSG_SUCCESS,
                studentAndAttendanceRateAndScoreVOList);
        } catch (Exception e) {
            LOG.error("get courseAndAttendanceRateAndScoreVO by couresId error, lessonId={}", lessonId, e);
            return new ResultDO<List<StudentAndAttendanceStateAndScoreVO>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //修改学生出勤状态
    @Override
    public ResultDO<String> modifyAttendanceState(long userId, long lessonId, String attendState) {
        if ((userId <= 0) || lessonId <= 0 || attendState == null) {
            return new ResultDO<String>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        try {
            int state;
            if (attendState.equals(AttendStateName.ATTENDANCE_NAME)) {
                state = AttendState.ATTENDANCE;
            } else if (attendState.equals(AttendStateName.ABSENT_NAME)) {
                state = AttendState.ABSENT;
            } else if (attendState.equals(AttendStateName.LATE_NAME)) {
                state = AttendState.LATE;
            } else if (attendState.equals(AttendStateName.LEAVE_EARLY_NAME)) {
                state = AttendState.LEAVE_EARLY;
            } else {
                return new ResultDO<String>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                    null);
            }
            attendanceDAO.updateAttendStateByUserIdAndLessonId(userId, lessonId, state);
            LOG.info(
                "update attendState by userId and lessonId and attendState success, userId={}, lessonId={}, attendState={}",
                userId, lessonId, attendState);
            int attendanceState = attendanceDAO.getAttendStateByLessonIdAndUserId(lessonId, userId);
            LOG.info("get attendState by lessonId and userId success, userId={}, lessonId={}, attendState={}", userId,
                lessonId, attendState);
            String attendance;
            if (attendanceState == AttendState.ATTENDANCE) {
                attendance = AttendStateName.ATTENDANCE_NAME;
            } else if (attendanceState == AttendState.ABSENT) {
                attendance = AttendStateName.ABSENT_NAME;
            } else if (attendanceState == AttendState.LATE) {
                attendance = AttendStateName.LATE_NAME;
            } else if (attendanceState == AttendState.LEAVE_EARLY) {
                attendance = AttendStateName.LEAVE_EARLY_NAME;
            } else {
                attendance = AttendStateName.MISSING_DATA_NAME;
            }
            LOG.info(
                "modify attendanceState by userId and lessonId and attendState success, userId={}, lessonId={}, attendState={}",
                userId, lessonId, attendState);
            return new ResultDO<String>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, attendance);
        } catch (Exception e) {
            LOG.error(
                "modify attendanceState by userId and lessonId and attendState error, userId={}, lessonId={}, attendState={}",
                userId, lessonId, attendState, e);
            return new ResultDO<String>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION,
                null);
        }
    }

}
