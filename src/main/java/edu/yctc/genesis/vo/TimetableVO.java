package edu.yctc.genesis.vo;

import edu.yctc.genesis.entity.ClassroomDO;
import edu.yctc.genesis.entity.CourseDO;
import edu.yctc.genesis.entity.LessonDO;

public class TimetableVO {

    /** 课程信息 */
    private CourseDO courseDO;
    /** 上课地点 */
    private ClassroomDO classroomDO;
    /** 课时信息 */
    private LessonDO lessonDO;
    /** 授课教师姓名 */
    private String teacherName;

    public CourseDO getCourseDO() {
        return courseDO;
    }

    public void setCourseDO(CourseDO courseDO) {
        this.courseDO = courseDO;
    }

    public ClassroomDO getClassroomDO() {
        return classroomDO;
    }

    public void setClassroomDO(ClassroomDO classroomDO) {
        this.classroomDO = classroomDO;
    }

    public LessonDO getLessonDO() {
        return lessonDO;
    }

    public void setLessonDO(LessonDO lessonDO) {
        this.lessonDO = lessonDO;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CurriculumVO [courseDO=");
        builder.append(courseDO);
        builder.append(", classroomDO=");
        builder.append(classroomDO);
        builder.append(", lessonDO=");
        builder.append(lessonDO);
        builder.append(", teacherName=");
        builder.append(teacherName);
        builder.append("]");
        return builder.toString();
    }
}
