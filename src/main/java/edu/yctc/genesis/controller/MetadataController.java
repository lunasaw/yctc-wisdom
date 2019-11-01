package edu.yctc.genesis.controller;

public interface MetadataController {

    /**
     * 展示教室列表页
     * 
     * @return
     */
    String showClassroomDmList();

    /**
     * 展示教室详情页
     * 
     * @return
     */
    String showClassroomDmDetail();

    /**
     * 展示教室修改页
     * 
     * @return
     */
    String showClassroomDmModify();

    /**
     * 展示课程详情页面
     * 
     * @return
     */
    String showCourseDmDetail();

    /**
     * 展示课程列表页
     * 
     * @return
     */
    String showCourseDmList();

    /**
     * 展示课程修改页
     * 
     * @return
     */
    String showCourseDmModify();

    /**
     * 展示教师列表页
     * 
     * @return
     */
    String showTeacherDmList();

    /**
     * 展示教师详情页
     * 
     * @return
     */
    String showTeacherDmDetail();

    /**
     * 展示教师修改页
     * 
     * @return
     */
    String showTeacherDmModify();

    /**
     * 展示学生列表页
     * 
     * @return
     */
    String showStudentDmList();

    /**
     * 展示学生详情页
     * 
     * @return
     */
    String showStudentDmDetail();

    /**
     * 展示学生修改页
     * 
     * @return
     */
    String showStudentDmModify();

    /**
     * 展示楼号楼层列表页
     * 
     * @return
     */
    String showBuildingFloorDmList();

    /**
     * 展示楼号楼层详情页
     * 
     * @return
     */
    String showBuildingFloorDmDetail();

    /**
     * 展示楼号楼层修改页
     * 
     * @return
     */
    String showBuildingFloorDmModify();

    /**
     * 展示学院班级列表页
     * 
     * @return
     */
    String showAcademyClassesDmList();

    /**
     * 展示学院班级详情页
     * 
     * @return
     */
    String showAcademyClassesDmDetail();

    /**
     * 展示学院班级修改页
     * 
     * @return
     */
    String showAcademyClassesDmModify();
}
