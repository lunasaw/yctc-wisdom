package edu.yctc.genesis.constant;

public class TemplatePath {

    // common start
    /** 主页 */
    public static final String INDEX = "index";
    // common end

    // user start
    /** 用户主页 */
    public static final String USER_HOME = "user/home";

    /** 注册 */
    @Deprecated
    public static final String USER_SIGNUP = "user/sign-up";

    /** 登录 */
    public static final String USER_SIGN_IN = "user/sign-in";
    /** 登陆成功页 */
    public static final String USER_SIGN_IN_SUCCESS = "user/sign-in-success";

    /** 注销登陆 */
    public static final String USER_SIGN_OUT = "user/sign-out";
    /** 注销成功 */
    public static final String USER_SIGN_OUT_SUCCESS = "user/sign-out-success";

    /** 找密界面 */
    public static final String USER_RETRIEVE_PASSWORDB_START = "user/verify-identity-step-a";
    /** 手机找密 */
    public static final String USER_RETRIEVE_PASSWORD_BY_PHONE = "user/verify-identity-step-b-mobile";
    /** 邮箱找密 */
    public static final String USER_RETRIEVE_PASSWORD_BY_MAIL = "user/verify-identity-step-b-email";
    /** 找密步骤三改密 */
    public static final String USER_RETRIEVE_PASSWORDB = "user/verify-identity-step-c";
    /** 找密成功 */
    public static final String USER_RETRIEVE_PASSWORD_SUCCESS = "user/verify-identity-success";

    /** 修改密码 */
    public static final String USER_UPDATE_PASSWORD = "user/update-password";
    /** 改密成功 */
    public static final String USER_UPDATE_PASSWORD_SUCCESS = "user/update-password-success";

    /** 修改邮箱身份验证 */
    public static final String USER_MAIL_AUTHENTICATION = "user/mail-authentication";
    /** 修改邮箱 */
    public static final String USER_UPDATE_MAIL = "user/update-email";
    /** 修改邮箱成功 */
    public static final String USER_UPDATE_MAIL_SUCCESS = "user/update-mail-success";

    /** 修改手机身份验证 */
    public static final String USER_MOBILE_AUTHENTICATION = "user/mobile-authentication";
    /** 修改手机 */
    public static final String USER_UPDATE_MOBILE = "user/update-mobile";
    /** 修改手机成功 */
    public static final String USER_UPDATE_MOBILE_SUCCESS = "user/update-mobile-success";

    /** 我的信息 */
    public static final String USER_MY_INFORMATION = "user/my-information";
    // user end

    // metadata start
    /** 教室列表页 */
    public static final String METADATA_CLASSROOM_DM_LIST = "metadata/classroom-dm-list";
    /** 教室详情页 */
    public static final String METADATA_CLASSROOM_DM_DETAIL = "metadata/classroom-dm-detail";
    /** 教室修改页 */
    public static final String METADATA_CLASSROOM_DM_MODIFY = "metadata/classroom-dm-modify";

    /** 课程详情页 */
    public static final String METADATA_COURSE_DM_DETAIL = "metadata/course-dm-detail";
    /** 课程修改页 */
    public static final String METADATA_COURSE_DM_MODIFY = "metadata/course-dm-modify";
    /** 课程列表页 */
    public static final String METADATA_COURSE_DM_LIST = "metadata/course-dm-list";

    /** 学生列表页 */
    public static final String METADATA_STUDENT_DM_LIST = "metadata/student-dm-list";
    /** 学生详情页 */
    public static final String METADATA_STUDENT_DM_DETAIL = "metadata/student-dm-detail";
    /** 学生修改页 */
    public static final String METADATA_STUDENT_DM_MODIFY = "metadata/student-dm-modify";

    /** 教师详情页 */
    public static final String METADATA_TEACHER_DM_DETAIL = "metadata/teacher-dm-detail";
    /** 教师修改页 */
    public static final String METADATA_TEACHER_DM_MODIFY = "metadata/teacher-dm-modify";
    /** 教师列表页 */
    public static final String METADATA_TEACHER_DM_LIST = "metadata/teacher-dm-list";

    /** 楼号楼层列表页 */
    public static final String METADATA_BUILDING_FLOOR_DM_LIST = "metadata/building-floor-dm-list";
    /** 楼号楼层详情页 */
    public static final String METADATA_BUILDING_FLOOR_DM_DETAIL = "metadata/building-floor-dm-detail";
    /** 楼号楼层修改页 */
    public static final String METADATA_BUILDING_FLOOR_DM_MODIFY = "metadata/building-floor-dm-modify";

    /** 学院班级列表页面 */
    public static final String METADATA_ACADEMY_CLASSES_DM_LIST = "metadata/academy-classes-dm-list";
    /** 学院班级详情页 */
    public static final String METADATA_ACADEMY_CLASSES_DM_DETAIL = "metadata/academy-classes-dm-detail";
    /** 学院班级修改页 */
    public static final String METADATA_ACADEMY_CLASSES_DM_MODIFY = "metadata/academy-classes-dm-modify";
    // metadata end

    // news start
    /** 消息列表页 */
    public static final String NEWS_LIST = "news/news";
    /** 消息详情页 */
    public static final String NEWS_DETAIL = "news/news-detail";
    // news and

    // teaching start
    /** 教师-教室申请功能界面 */
    public static final String TEACHING_CLASSROOM_APPLICATION = "teaching/classroom-application";

    /** 课堂详情 列表页 */
    public static final String LESSON_DETAILS_LIST = "teaching/lesson-details-list";
    /** 课堂详情 详情页 */
    public static final String LESSON_DETAILS_DETAILS = "teaching/lesson-details-details";

    /** 课程详情 列表页 */
    public static final String TEACHING_COURSE_DETAILS_LIST = "teaching/course-details-list";
    /** 课程详情 详情页 */
    public static final String TEACHING_COURSE_DETAILS_DETAILS = "teaching/course-details-details";

    /** 学生详情 列表页 */
    public static final String TEACHING_STUDENT_DETAILS_LIST = "teaching/student-details-list";
    /** 学生详情 详情页 */
    public static final String TEACHING_STUDENT_DETAILS_DETAILS = "teaching/student-details-details";

    /** 教师-教学课表界面 */
    public static final String TEACHING_TEACHING_SCHEDULE = "teaching/teaching-schedule";

    /** 教师点名页 */
    public static final String TEACHING_CHECK_ATTENDANCE = "teaching/check-attendance";

    /** 状态检测 */
    public static final String TEACHING_CHECK_STATE = "teaching/check-state";

    /** 填写知识点页面A */
    public static final String TEACHING_FILL_KNOWLEDGE_STEP_A = "teaching/fill-knowledge-step-a";

    /** 填写知识点页面B */
    public static final String TEACHING_FILL_KNOWLEDGE_STEP_B = "teaching/fill-knowledge-step-b";

    /** 知识点学情列表页 */
    public static final String TEACHING_LESSON_KNOWLEDGE_POINT_LIST = "teaching/lesson-knowledge-point-list";
    /** 知识点学情详情页 */
    public static final String TEACHING_LESSON_KNOWLEDGE_POINT_DETAILS = "teaching/lesson-knowledge-point-details";
    // teaching end

    // learning start
    /** 学生-我的课表功能界面 */
    public static final String LEARNING_MY_SCHEDULE = "learning/my-schedule";
    /** 学生-我的听课质量功能界面 */
    public static final String LEARNING_MY_CLASS_QUALITY = "learning/my-class-quality";
    // learning end

    // education start
    /** 管理员-权限管理功能界面 */
    public static final String EDUCATION_AUTHORITY_MANAGEMENT = "education/authority-management";
    /** 教室直播功能界面 */
    public static final String EDUCATION_CLASSROOM_LIVE = "education/classroom-live";
    /** 管理员-导入学生数据功能页面 */
    public static final String EDUCATION_IMPORT_STUDENTS = "education/import-students";
    /** 权限管理-角色管理功能界面 */
    public static final String EDUCATION_AUTHORITY_ROLE_MANAGEMENT = "education/authority-role-management";
    /** 权限管理-角色管理-增加角色功能界面 */
    public static final String EDUCATION_AUTHORITY_ROLE_MANAGEMENT_ADD = "education/authority-role-management-add";
    /** 权限管理-角色管理-修改角色功能界面 */
    public static final String EDUCATION_AUTHORITY_ROLE_MANAGEMENT_MODIFY =
        "education/authority-role-management-modify";
    // education end

    // camera control
    /** 球机管理页 */
    public static final String EDUCATION_CAMERA_CONTROL = "education/camera-control";

    /** 后台管理界面 */
    public static final String USER_MANAGE = "manage/user-manage"; // TODO
                                                                   // 此为测试页面，不上线

}
