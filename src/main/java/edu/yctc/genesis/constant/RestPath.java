package edu.yctc.genesis.constant;

public class RestPath {

    // user start
    /** 注册 */
    public static final String SIGN_UP = "/restuser/sign-up";
    /** 登录 */
    public static final String SIGN_IN = "/restuser/sign-in";
    /** 获得用户信息 */
    public static final String GET_USER_INFORMATION_BY_ID = "/restuser/get-user-information-by-id";
    /** 发邮件验证码 */
    public static final String SEND_MAIL = "/restwarpper/send-Mail";
    /** 发邮件验证码(修改邮箱时用) */
    public static final String SEND_MAILFORUPDATEMAIL = "/restwarpper/send-MailForUpdateMail";
    /** 发短信验证码 */
    public static final String SEND_SMS = "/restwarpper/send-Sms";
    /** 发短信验证码(修改手机时用) */
    public static final String SEND_SMSFORUPDATEMOBILE = "/restwarpper/send-SmsForUpdateMobile";
    // user end

    // metadata start
    /** 通过楼号返回楼号所有的楼层 */
    public static final String GET_FLOORS_BY_BUILDING = "/restmetadata/get-floors-by-building"; //
    /** 通过楼号和楼层号返回教室 */
    public static final String GET_CLASSROOMDO_BY_BUILD_AND_FLOORS =
        "/restmetadata/get-classroomdo-by-building-and-floor"; //
    /** 通过id返回教室 */
    public static final String GET_CLASSROOMDO_BY_ID = "/restmetadata/get-classroomdo-by-id";
    /** 删除教室信息 */
    public static final String DELETE_CLASSROOM = "/restmetadata/delete-classroom"; //
    /** 修改教室信息 */
    public static final String MODIFY_CLASSROOM = "/restmetadata/modify-classroom"; //
    /** 返回库中楼号集 */
    public static final String GET_BUILDINGS = "/restmetadata/get-buildings"; //
    /** 拼接ClassroomDmDetailUrl */
    public static final String GET_CLASSROOM_DM_DETAIL_URL = "/restmetadata/get-classroom-dm-detail-url"; //
    /** 拼接ClassroomDmModifyUrl */
    public static final String GET_CLASSROOM_DM_MODIFY_URL = "/restmetadata/get-classroom-dm-modify-url";

    /** 返回库中学年集 */
    public static final String GET_YEARS = "/restmetadata/get-years";
    /** 通过学年和学期获得课程集 */
    public static final String GET_COURSEDO_BY_YEAR_AND_TERM = "/restmetadata/get-coursedo-by-year-and-term";
    /** 通过id返回课程 */
    public static final String GET_COURSEDO_BY_ID = "/restmetadata/get-coursedo-by-id";
    /** 拼接ClassroomDmDetailUrl */
    public static final String GET_COURSE_DM_DETAIL_URL = "/restmetadata/get-course-dm-detail-url";
    /** 拼接ClassroomDmModifyUrl */
    public static final String GET_COURSE_DM_MODIFY_URL = "/restmetadata/get-course-dm-modify-url";
    /** 删除一门课 */
    public static final String DELETE_COURSE = "/restmetadata/delete-course";
    /** 修改课程信息 */
    public static final String MODIFY_COURSE = "/restmetadata/modify-course";

    /** 返回库中学院集 */
    public static final String GET_ACADEMIES = "/restmetadata/get-academies";
    /** 通过学院名返回教师 */
    public static final String GET_TEACHERDO_BY_ACADEMY = "/restmetadata/get-teacherdo-by-academy";
    /** 通过id返回教师 */
    public static final String GET_TEACHERDO_BY_ID = "/restmetadata/get-teacherdo-by-id";
    /** 拼接TeacherDmDetailUrl */
    public static final String GET_TEACHER_DM_DETAIL_URL = "/restmetadata/get-teacher-dm-detail-url";
    /** 拼接TeacherDmModifyUrl */
    public static final String GET_TEACHER_DM_MODIFY_URL = "/restmetadata/get-teacher-dm-modify-url";
    /** 删除教师信息 */
    public static final String DELETE_TEACHER = "/restmetadata/delete-teacher";
    /** 修改教师信息 */
    public static final String MODIFY_TEACHER = "/restmetadata/modify-teacher";

    /** 通过学院返回该学院所有班级 */
    public static final String GET_CLASSES_BY_ACADEMY = "/restmetadata/get-classes-by-academy";
    /** 通过学院和班级返回学生 */
    public static final String GET_USERDO_BY_ACADEMY_AND_CLASSES = "/restmetadata/get-userDO-by-academy-and-classes";
    /** 拼接StudentDmurl */
    public static final String GET_STUDENT_DM_URL = "/restmetadata/get-student-dm-url";
    /** 删除学生信息 */
    public static final String DELETE_STUDENT = "/restmetadata/delete-student";
    /** 修改学生信息 */
    public static final String MODIFY_STUDENT = "/restmetadata/modify-student";

    /** 添加单条权限 */
    public static final String ADD_PERMISSION = "/restpermission/add-permission";
    /** 删除单条权限 */
    public static final String DELETE_PERMISSION = "/restpermission/delete-permission";
    // metadata end

    // details start
    /** 通过userId(学生)和学年和学期获得课程集 */
    public static final String GET_COURSEDO_BY_YEAR_AND_TERM_AND_USERID =
        "/restdetails/get-coursedo-by-year-and-term-and-userid";
    /** 通过teacherId获得课程集 */
    public static final String GET_COURSEDO_BY_TEACHERID = "/restdetails/get-coursedo-by-teacherid";
    /** 通过courseName获得lessondo集 */
    public static final String GET_LESSONDO_BY_COURSENAME = "/restdetails/get-lessondo-by-coursename";
    /** 通过学院和班级返回学生 */
    public static final String GET_STUDENTDO_BY_ACADEMY_AND_CLASSES =
        "/restdetails/get-studentdo-by-academy-and-classes";
    /** 通过studentId获得该堂课的CourseAndAttendanceRateAndScoreDO集 */
    public static final String GET_COURSE_AND_ATTENDANCERATE_AND_SCOREVO_BY_STUDENTID =
        "/restdetails/get-course-and-attendancerate-and-scorevo-by-studentid";
    /** 通过courseId获得该门课的CourseAndAttendanceRateAndScoreDO */
    public static final String GET_COURSE_AND_ATTENDANCERATE_AND_SCOREVO_BY_COURSEID =
        "/restdetails/get-course-and-attendancerate-and-scorevo-by-courseid";
    /** 通过courseId获得该门课的每个学生的StudentAndAttendanceRateAndScoreVO集 */
    public static final String GET_EVERY_STUDENT_ATTENDANCE_DETAIL_BY_COURSEID =
        "/restdetails/ get-every-student-attendance-detail-by-courseid";
    /** 通过lessonId获得该堂课的LessonDetailsVO */
    public static final String GET_LESSONDETAILSVO_BY_LESSONID = "/restdetails/get-lessondetailsvo-by-lessonid";
    /** 通过lessonId获得该堂课的每个学生的LessonDetailsVO集 */
    public static final String GET_EVERY_STUDENT_ATTENDANCE_DETAIL_BY_LESSONID =
        "/restdetails/get-every-student-attendance-detail-by-lessonid";
    /** 修改学生出勤状态并返回修改后的状态 */
    public static final String MODIFY_ATTENDANCE_STATE = "/restdetails/modify-attendance-state";
    // details end

    // news start
    /** 获得用户消息列表 */
    public static final String SHOW_NEWS = "/restnews/show-News";
    /** 将某条信息变更为已读 */
    public static final String TURN_TO_READED = "/restnews/turn-to-readed";
    /** 将某条信息变更为未读 */
    public static final String TURN_TO_UNREAD = "/restnews/turn-to-unread";
    /** 全部变更为已读 */
    public static final String TURN_ALL_TO_READED = "/restnews/turn-all-to-readed";
    /** 全部变更为未读 */
    public static final String TURN_ALL_TO_UNREAD = "/restnews/turn-all-to-unread";
    /** 给用户推送消息 */
    public static final String SEND_NEWS_TO_USER_LIST = "/restnews/send-news-to-user-list";
    // news end

    // class quality start
    /** 获取课堂质量评分 */
    public static final String GET_MY_CLASS_QUALITY = "/restclassquality/get-my-class-quality";
    // class quality end

    // face function start
    /** 点名 */
    public static final String CHECK_ATTENDANCE = "/restfacefunction/check-attendance";
    /** 状态检测 */
    public static final String CHECK_STATE = "/restfacefunction/check-state";
    // face function end

    // education start
    /** 导入学生数据 */
    public static final String IMPORT_STUDENTS = "/resteducation/import-students";
    /** 球机管理 */
    public static final String CAMERA_CONTROL = "/resteducation/camera-control";
    // education end
}
