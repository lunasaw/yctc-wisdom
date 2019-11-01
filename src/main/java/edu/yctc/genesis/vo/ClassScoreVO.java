package edu.yctc.genesis.vo;

import edu.yctc.genesis.entity.ClassScoreDO;
import edu.yctc.genesis.entity.ClassroomDO;
import edu.yctc.genesis.entity.CourseDO;
import edu.yctc.genesis.entity.LessonDO;

public class ClassScoreVO {

    /** 课程信息 */
    private CourseDO courseDO;
    /** 上课地点 */
    private ClassroomDO classroomDO;
    /** 课时信息 */
    private LessonDO lessonDO;
    /** 评分信息 */
    private ClassScoreDO classScoreDO;

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

    public ClassScoreDO getClassScoreDO() {
        return classScoreDO;
    }

    public void setClassScoreDO(ClassScoreDO classScoreDO) {
        this.classScoreDO = classScoreDO;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ClassScoreVO [courseDO=");
        builder.append(courseDO);
        builder.append(", classroomDO=");
        builder.append(classroomDO);
        builder.append(", lessonDO=");
        builder.append(lessonDO);
        builder.append(", classScoreDO=");
        builder.append(classScoreDO);
        builder.append("]");
        return builder.toString();
    }
}
