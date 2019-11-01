package edu.yctc.genesis.config.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import edu.yctc.genesis.constant.RestPath;
import edu.yctc.genesis.constant.StaticPath;
import edu.yctc.genesis.constant.TemplatePath;

/**
 * Shiro的配置类
 *
 * @author wlt
 */
@Configuration
public class ShiroConfig {

    /**
     * 创建ShiroFilterFactoryBean
     *
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean
    getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 添加Shiro内置过滤器
        /**
         * Shiro内置过滤器，可以实现权限相关的拦截器 常用的过滤器： anon: 无需认证（登录）可以访问 authc:必须认证才可以访问 user:如果使用 rememberMe的功能可以直接访问
         * perms:该资源必须得到资源权限才可以访问 role: 该资源必须得到角色权限才可以访问
         */
        // 授权过滤器
        // 注：当前授权拦截后，shiro会自动跳转到未授权页面
        Map<String, String> filterMap = new LinkedHashMap<String, String>();
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        // 无需登录的页面
        {
            filterMap.put("/" + StaticPath.COMMON_ERROR, "anon"); // 统一错误页
            filterMap.put("/" + TemplatePath.USER_SIGN_IN, "anon"); // 登录
            filterMap.put("/" + TemplatePath.USER_SIGNUP, "anon"); // 注册
            filterMap.put("/" + StaticPath.USER_SIGNUP_SUCCESS, "anon"); // 注册成功
            filterMap.put("/" + TemplatePath.USER_RETRIEVE_PASSWORDB_START, "anon"); // 找密界面
            filterMap.put("/" + TemplatePath.USER_RETRIEVE_PASSWORD_BY_PHONE, "anon"); // 手机找密
            filterMap.put("/" + TemplatePath.USER_RETRIEVE_PASSWORD_BY_MAIL, "anon"); // 邮箱找密
            filterMap.put("/" + TemplatePath.USER_RETRIEVE_PASSWORDB, "anon"); // 找密步骤三改密
            filterMap.put("/" + TemplatePath.USER_RETRIEVE_PASSWORD_SUCCESS, "anon"); // 找密成功
        }
        // 需要登录的页面
        {

            filterMap.put("/" + TemplatePath.USER_MY_INFORMATION, "authc"); // 我的信息页
            filterMap.put("/" + TemplatePath.USER_SIGN_IN_SUCCESS, "authc"); // 登陆成功
            filterMap.put("/" + TemplatePath.USER_MANAGE, "authc");// 后台管理页
            filterMap.put("/" + TemplatePath.USER_UPDATE_PASSWORD, "authc"); // 修改密码
            filterMap.put("/" + TemplatePath.USER_UPDATE_MAIL, "authc"); // 修改邮箱
            filterMap.put("/" + TemplatePath.USER_MAIL_AUTHENTICATION, "authc"); // 修改邮箱身份验证
            filterMap.put("/" + TemplatePath.USER_UPDATE_MOBILE, "authc"); // 修改手机
            filterMap.put("/" + TemplatePath.USER_MOBILE_AUTHENTICATION, "authc"); // 修改手机身份验证
            filterMap.put("/" + TemplatePath.USER_SIGN_OUT, "authc"); // 注销登陆
            filterMap.put("/" + TemplatePath.USER_SIGN_OUT_SUCCESS, "authc"); // 注销成功
        }
        // 需要资源权限的页面   授权过滤器
        {
            filterMap.put("/" + TemplatePath.TEACHING_CLASSROOM_APPLICATION, "perms[tea:classroomApplication]"); // 教师-教室申请
            filterMap.put("/" + TemplatePath.TEACHING_TEACHING_SCHEDULE, "perms[tea:teachingSchedule]"); // 教师-教学课表
            filterMap.put("/" + TemplatePath.LEARNING_MY_SCHEDULE, "perms[stu:mySchedule]"); // 学生-我的课表
            filterMap.put("/" + TemplatePath.LEARNING_MY_CLASS_QUALITY, "perms[stu:myClassQuality]"); // 学生-我的听课质量
            filterMap.put("/" + TemplatePath.EDUCATION_AUTHORITY_MANAGEMENT, "perms[admin:buildingsManagement]"); // 管理员-楼宇管理
            filterMap.put("/" + TemplatePath.EDUCATION_AUTHORITY_MANAGEMENT, "perms[admin:classroomsManagement]"); // 管理员-教室管理
            filterMap.put("/" + TemplatePath.EDUCATION_AUTHORITY_MANAGEMENT, "perms[admin:classesManagement]"); // 管理员-班级管理
            filterMap.put("/" + TemplatePath.EDUCATION_AUTHORITY_MANAGEMENT, "perms[admin:studentsManagement]"); // 管理员-学生管理
            filterMap.put("/" + TemplatePath.EDUCATION_AUTHORITY_MANAGEMENT, "perms[admin:coursesManagement]"); // 管理员-课程管理
            filterMap.put("/" + TemplatePath.EDUCATION_AUTHORITY_MANAGEMENT, "perms[admin:teachersManagement]"); // 管理员-教师管理
            filterMap.put("/" + TemplatePath.EDUCATION_AUTHORITY_MANAGEMENT, "perms[admin:authorityManagement]"); // 管理员-权限管理
            filterMap.put("/" + TemplatePath.EDUCATION_AUTHORITY_ROLE_MANAGEMENT, "perms[admin:roleManagement]"); // 管理员-角色管理
            filterMap.put("/" + TemplatePath.EDUCATION_AUTHORITY_ROLE_MANAGEMENT_ADD, "perms[admin:roleManagement]"); // 管理员-角色管理-增加角色
            filterMap.put("/" + TemplatePath.EDUCATION_AUTHORITY_ROLE_MANAGEMENT_MODIFY, "perms[admin:roleManagement]"); // 管理员-角色管理-修改角色

            filterMap.put("/" + TemplatePath.EDUCATION_CLASSROOM_LIVE, "perms[admin:classroomLive]"); // 教室直播
            filterMap.put("/" + TemplatePath.LESSON_DETAILS_LIST, "perms[tea:lessonDetails]"); // 课堂详情 列表页
            filterMap.put("/" + TemplatePath.LESSON_DETAILS_DETAILS, "perms[tea:lessonDetails]"); // 课堂详情 详情页
            filterMap.put("/" + TemplatePath.TEACHING_COURSE_DETAILS_LIST, "perms[tea:courseDetails]"); // 课程详情 列表页
            filterMap.put("/" + TemplatePath.TEACHING_COURSE_DETAILS_DETAILS, "perms[tea:courseDetails]"); // 课程详情 详情页
            filterMap.put("/" + TemplatePath.TEACHING_STUDENT_DETAILS_LIST, "perms[tea:studentDetails]"); // 学生详情 列表页
            filterMap.put("/" + TemplatePath.TEACHING_STUDENT_DETAILS_DETAILS, "perms[tea:studentDetails]"); // 学生详情 详情页
            filterMap.put("/" + TemplatePath.TEACHING_CHECK_ATTENDANCE, "perms[tea:checkAttendance]"); // 点名页
            filterMap.put("/" + TemplatePath.TEACHING_CHECK_STATE, "perms[tea:checkState]"); // 状态检测页
            filterMap.put("/" + TemplatePath.EDUCATION_IMPORT_STUDENTS, "perms[admin:importData]");// 学生数据导入功能页
            filterMap.put("/" + TemplatePath.EDUCATION_CAMERA_CONTROL, "perms[admin:cameraControl]");// 球机管理页
            filterMap.put("/" + TemplatePath.TEACHING_FILL_KNOWLEDGE_STEP_A, "perms[tea:fillKnowledge]");// 填写知识点
            filterMap.put("/" + TemplatePath.TEACHING_FILL_KNOWLEDGE_STEP_B, "perms[tea:fillKnowledge]");// 填写知识点
            filterMap.put("/" + TemplatePath.TEACHING_LESSON_KNOWLEDGE_POINT_LIST, "perms[tea:knowledgeStudyStatement]");// 知识点学情反馈列表页
            filterMap.put("/" + TemplatePath.TEACHING_LESSON_KNOWLEDGE_POINT_DETAILS, "perms[tea:knowledgeStudyStatement]");// 知识点学情反馈详情页
        }
        // rest权限设置
        // 1.用户功能
        filterMap.put(RestPath.SIGN_IN, "anon"); // 登录
        filterMap.put(RestPath.GET_USER_INFORMATION_BY_ID, "anon");// 获得用户信息
        // 2.邮件、短信的发送
        filterMap.put(RestPath.SEND_MAIL, "anon"); // 发邮件验证码
        filterMap.put(RestPath.SEND_MAILFORUPDATEMAIL, "authc"); // 发邮件验证码(修改邮箱时用)
        filterMap.put(RestPath.SEND_SMS, "anon"); // 发短信验证码
        filterMap.put(RestPath.SEND_SMSFORUPDATEMOBILE, "authc"); // 发短信验证码(修改手机时用)
        // 3.权限管理
        filterMap.put(RestPath.ADD_PERMISSION, "perms[admin:authorityManagement]"); // 增加一条权限
        filterMap.put(RestPath.DELETE_PERMISSION, "perms[admin:authorityManagement]"); // 删除一条权限
        // 4.教室管理
        filterMap.put(RestPath.GET_FLOORS_BY_BUILDING, "authc"); // 通过楼号返回楼号所有的楼层
        filterMap.put(RestPath.GET_CLASSROOMDO_BY_BUILD_AND_FLOORS, "authc"); // 通过楼号和楼层号返回教室
        filterMap.put(RestPath.DELETE_CLASSROOM, "perms[admin:classroomsManagement]"); // 删除教室信息
        filterMap.put(RestPath.MODIFY_CLASSROOM, "perms[admin:classroomsManagement]"); // 修改教室信息
        filterMap.put(RestPath.GET_BUILDINGS, "perms[admin:classroomsManagement]"); // 返回库中楼号集
        filterMap.put(RestPath.GET_CLASSROOM_DM_DETAIL_URL, "perms[admin:classroomsManagement]"); // 拼接ClassroomDmDetailurl
        filterMap.put(RestPath.GET_CLASSROOM_DM_MODIFY_URL, "perms[admin:classroomsManagement]"); // 拼接ClassroomDmModifyurl
        // 5.课程管理
        filterMap.put(RestPath.GET_YEARS, "authc"); // 返回库中学年集
        filterMap.put(RestPath.GET_COURSEDO_BY_YEAR_AND_TERM, "authc"); // 通过学年和学期获得课程集
        filterMap.put(RestPath.DELETE_COURSE, "perms[admin:coursesManagement]"); // 删除一门课
        filterMap.put(RestPath.MODIFY_COURSE, "perms[admin:coursesManagement]"); // 修改课程信息
        filterMap.put(RestPath.GET_COURSE_DM_DETAIL_URL, "perms[admin:coursesManagement]"); // 拼接CourseDmDetailurl
        filterMap.put(RestPath.GET_COURSE_DM_MODIFY_URL, "perms[admin:coursesManagement]"); // 拼接CourseDmModifyurl
        // 6.教师管理
        filterMap.put(RestPath.GET_ACADEMIES, "authc"); // 返回库中学院集
        filterMap.put(RestPath.GET_TEACHERDO_BY_ACADEMY, "authc"); // 通过学院名返回教师
        filterMap.put(RestPath.DELETE_TEACHER, "perms[admin:teachersManagement]"); // 删除教师信息
        filterMap.put(RestPath.MODIFY_TEACHER, "perms[admin:teachersManagement]"); // 修改教师信息
        filterMap.put(RestPath.GET_TEACHER_DM_DETAIL_URL, "perms[admin:teachersManagement]"); // 拼接TeacherDmDetailUrl
        filterMap.put(RestPath.GET_TEACHER_DM_MODIFY_URL, "perms[admin:teachersManagement]"); // 拼接TeacherDmModifyUrl
        // 7.学生管理
        filterMap.put(RestPath.GET_CLASSES_BY_ACADEMY, "authc"); // 通过学院返回该学院所有班级
        filterMap.put(RestPath.GET_USERDO_BY_ACADEMY_AND_CLASSES, "authc"); // 通过学院和班级返回学生
        filterMap.put(RestPath.DELETE_STUDENT, "perms[admin:studentsManagement]"); // 删除学生信息
        filterMap.put(RestPath.MODIFY_STUDENT, "perms[admin:studentsManagement]"); // 修改学生信息
        filterMap.put(RestPath.GET_STUDENT_DM_URL, "perms[admin:studentsManagement]"); // 拼接StudentDmurl
        // 8.消息系统
        filterMap.put(RestPath.SHOW_NEWS, "authc"); // 获得用户消息列表
        filterMap.put(RestPath.TURN_TO_READED, "authc"); // 将某条信息变更为已读
        filterMap.put(RestPath.TURN_TO_UNREAD, "authc"); // 将某条信息变更为未读
        filterMap.put(RestPath.TURN_ALL_TO_READED, "authc"); // 全部变更为已读
        filterMap.put(RestPath.TURN_ALL_TO_UNREAD, "authc"); // 全部变更为未读
        filterMap.put(RestPath.SEND_NEWS_TO_USER_LIST, "authc"); // 给用户推送消息
        // 9.教师-学生详情
        filterMap.put(RestPath.GET_STUDENTDO_BY_ACADEMY_AND_CLASSES, "perms[tea:studentDetails]");// 通过学院和班级返回学生
        filterMap.put(RestPath.GET_COURSE_AND_ATTENDANCERATE_AND_SCOREVO_BY_STUDENTID, "perms[tea:studentDetails]");// 通过studentId获得该堂课的CourseAndAttendanceRateAndScoreDO集
        // 10.教师-课程详情
        filterMap.put(RestPath.GET_COURSEDO_BY_YEAR_AND_TERM_AND_USERID, "perms[tea:courseDetails]");// 通过userId(学生)和学年和学期获得课程集
        filterMap.put(RestPath.GET_COURSE_AND_ATTENDANCERATE_AND_SCOREVO_BY_COURSEID, "perms[tea:courseDetails]");// 通过courseId获得该门课的CourseAndAttendanceRateAndScoreDO
        filterMap.put(RestPath.GET_EVERY_STUDENT_ATTENDANCE_DETAIL_BY_COURSEID, "perms[tea:courseDetails]");// 通过courseId获得该门课的每个学生的StudentAndAttendanceRateAndScoreVO集
        // 11.教师-课堂详情
        filterMap.put(RestPath.GET_LESSONDETAILSVO_BY_LESSONID, "perms[tea:lessonDetails]");// 通过lessonId获得该堂课的LessonDetailsVO
        filterMap.put(RestPath.GET_COURSEDO_BY_TEACHERID, "perms[tea:lessonDetails]");// 通过teacherId获得课程集
        filterMap.put(RestPath.GET_LESSONDO_BY_COURSENAME, "perms[tea:lessonDetails]");// 通过courseName获得lessondo集
        filterMap.put(RestPath.GET_EVERY_STUDENT_ATTENDANCE_DETAIL_BY_LESSONID, "perms[tea:lessonDetails]");// 通过lessonId获得该堂课的每个学生的LessonDetailsVO集
        filterMap.put(RestPath.MODIFY_ATTENDANCE_STATE, "perms[tea:lessonDetails]");// 修改学生出勤状态并返回修改后的状态
        // 12.学生-我的听课质量
        filterMap.put(RestPath.GET_MY_CLASS_QUALITY, "perms[stu:myClassQuality]");// 学生-我的听课质量
        // 13.教师-点名页
        filterMap.put(RestPath.CHECK_ATTENDANCE, "perms[tea:checkAttendance]");// 教师-点名
        // 13.教师-状态检测
        filterMap.put(RestPath.CHECK_STATE, "perms[tea:checkState]");// 教师-状态检测
        // 14.管理员-学生数据导入
        filterMap.put(RestPath.IMPORT_STUDENTS, "perms[admin:importData]");// 管理员-学生数据导入
        // 15.管理员-球机管理
        filterMap.put(RestPath.CAMERA_CONTROL, "perms[admin:cameraControl]");// 管理员-球机管理

        // 设置自定义的登录页面
        shiroFilterFactoryBean.setLoginUrl("/" + TemplatePath.USER_SIGN_IN);

        // 设置自定义的未授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/manage/no-authorization");

        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     *
     * @param userRealm
     * @return
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 创建Realm
     *
     * @return
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm() {
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }

    /**
     * 配合ShiroDialect，用于thymeleaf和shiro标签配合使用
     *
     * @return
     */
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

}
