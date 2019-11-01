package edu.yctc.genesis.vo;

import java.util.List;

import edu.yctc.genesis.entity.ClassDO;
import edu.yctc.genesis.entity.ClassroomDO;
import edu.yctc.genesis.entity.CourseDO;
import edu.yctc.genesis.entity.LessonDO;

public class TeachingScheduleVO {

    /** 课程信息 */
    private CourseDO courseDO;
    /** 上课地点 */
    private ClassroomDO classroomDO;
    /** 课时信息 */
    private LessonDO lessonDO;
    /** 上课班级集 */
    private List<ClassDO> classDOList;

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

    public List<ClassDO> getClassDOList() {
        return classDOList;
    }

    public void setClassDOList(List<ClassDO> classDOList) {
        this.classDOList = classDOList;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TeachingScheduleVO [courseDO=");
        builder.append(courseDO);
        builder.append(", classroomDO=");
        builder.append(classroomDO);
        builder.append(", lessonDO=");
        builder.append(lessonDO);
        builder.append(", classDOList=");
        builder.append(classDOList);
        builder.append("]");
        return builder.toString();
    }

}
