package edu.yctc.genesis.service;

import java.util.List;

import edu.yctc.genesis.entity.AcademyDO;
import edu.yctc.genesis.entity.BuildingFloorDO;
import edu.yctc.genesis.entity.ClassDO;
import edu.yctc.genesis.entity.ClassroomDO;
import edu.yctc.genesis.entity.CourseDO;
import edu.yctc.genesis.entity.LessonDO;
import edu.yctc.genesis.entity.ProfessionDO;
import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.entity.UserDO;
import edu.yctc.genesis.vo.ClassroomDOAndBuildingAndFloorVO;
import edu.yctc.genesis.vo.CourseDTOAndClassesVO;
import edu.yctc.genesis.vo.ModifyBuildingFloorVO;
import edu.yctc.genesis.vo.ModifyClassDOVO;
import edu.yctc.genesis.vo.ModifyClassroomVO;
import edu.yctc.genesis.vo.ModifyCourseVO;
import edu.yctc.genesis.vo.ModifyStudentVO;
import edu.yctc.genesis.vo.ModifyTeacherVO;
import edu.yctc.genesis.vo.StudentDOAndAcademyAndClassesVO;
import edu.yctc.genesis.vo.TeacherDOAndAcademyVO;

public interface MetaDataIService {

    /**
     * 通过楼号返回楼号对应的所有楼层
     * 
     * @param building
     * @return
     */
    public ResultDO<List<String>> getFloorsByBuilding(String building);

    /**
     * 通过楼号和楼层号返回教室集
     * 
     * @param building
     * @param floor
     * @return
     */
    public ResultDO<List<ClassroomDO>> getClassroomDOByBuildingAndFloor(String building, String floor);

    /**
     * 删除教室信息
     * 
     * @param id
     * @return
     */
    public ResultDO<Void> deleteClassroom(long id);

    /**
     * 修改教室信息
     * 
     * @param modifyClassroomVO
     * @return
     */
    public ResultDO<Void> modifyClassroom(ModifyClassroomVO modifyClassroomVO);

    /**
     * 返回库中楼号集
     * 
     * @return
     */
    public ResultDO<List<String>> getBuildings();

    /**
     * 返回学年集
     * 
     * @return
     */
    public ResultDO<List<String>> getYears();

    /**
     * 通过学年和学期获得课程
     * 
     * @param year
     * @param term
     * @return
     */
    public ResultDO<List<CourseDO>> getCourseDOByYearAndTerm(String year, int term);

    /**
     * 删除一门课
     * 
     * @param id
     * @return
     */
    public ResultDO<Void> deleteCourse(long id);

    /**
     * 修改课程信息
     * 
     * @param modifyCourseVO
     * @return
     */
    public ResultDO<Void> modifyCourse(ModifyCourseVO modifyCourseVO);

    /**
     * 返回库中学院集
     * 
     * @return
     */
    public ResultDO<List<String>> getAcademies();

    /**
     * 通过学院返回教师集
     * 
     * @param academy
     * @return
     */
    public ResultDO<List<UserDO>> getTeacherDOByAcademy(String academy);

    /**
     * 删除教师信息
     * 
     * @param id
     * @return
     */
    public ResultDO<Void> deleteTeacher(long id);

    /**
     * 修改教师信息
     * 
     * @param modifyTeacherVO
     * @return
     */
    public ResultDO<Void> modifyTeacher(ModifyTeacherVO modifyTeacherVO);

    /**
     * 通过学院返回该学院对应的所有班级
     * 
     * @param academy
     * @return
     */
    public ResultDO<List<String>> getClassesByAcademy(String academy);

    /**
     * 通过学院和班级返回学生集
     * 
     * @param academy
     * @param classes
     * @return
     */
    public ResultDO<List<UserDO>> getStudentDOByAcademyAndClasses(String academy, String classes);

    /**
     * 删除学生信息
     * 
     * @param id
     * @return
     */
    public ResultDO<Void> deleteStudent(long id);

    /**
     * 修改学生信息
     * 
     * @param modifyStudentVO
     * @return
     */
    public ResultDO<Void> modifyStudent(ModifyStudentVO modifyStudentVO);

    /**
     * 通过id返回classroomDO
     * 
     * @param id
     * @return
     */
    public ResultDO<ClassroomDO> getClassroomDOById(long id);

    /**
     * 通过id返回CourseDTOAndClassesVO
     * 
     * @param id
     * @return
     */
    public ResultDO<CourseDTOAndClassesVO> getCourseDTOAndClassesVOById(long id);

    /**
     * 通过id返回teacherDO以及对应学院VO
     * 
     * @param id
     * @return
     */
    public ResultDO<TeacherDOAndAcademyVO> getTeacherDOAndAcademyVOById(long id);

    /**
     * 通过id返回StudentDO以及对应学院班级VO
     * 
     * @param id
     * @return
     */
    public ResultDO<StudentDOAndAcademyAndClassesVO> getStudentDOAndAcademyAndClassesVOById(long id);

    /**
     * 通过userId返回课程安排
     * 
     * @param userId
     * @return
     */
    public ResultDO<List<LessonDO>> getLessonDOByUserId(long userId);

    /**
     * 通过id返回lessonDO
     * 
     * @param id
     * @return
     */
    public ResultDO<LessonDO> getLessonDOById(long id);

    /**
     * 通过building和floor返回BuildingFloorDO
     * 
     * @param building
     * @param floor
     * @return
     */
    public ResultDO<BuildingFloorDO> getBuildingFloorDOByBuildingAndFloor(String building, String floor);

    /**
     * 通过id返回ClassroomDOAndbuildingAndFloorVO
     * 
     * @param id
     * @return
     */
    public ResultDO<ClassroomDOAndBuildingAndFloorVO> getClassroomDOAndbuildingAndFloorVOById(long id);

    /**
     * 通过id返回ClassDO
     * 
     * @param id
     * @return
     */
    public ResultDO<ClassDO> getClassDOById(long id);

    /**
     * 通过building返回buildingFloorDO集
     * 
     * @param building
     * @return
     */
    public ResultDO<List<BuildingFloorDO>> getBuildingFloorDOsByBuilding(String building);

    /**
     * 通过id返回buildingFloorDO
     * 
     * @param id
     * @return
     */
    public ResultDO<BuildingFloorDO> getBuildingFloorDOById(long id);

    /**
     * 通过id删除楼宇信息
     * 
     * @param id
     * @return
     */
    public ResultDO<Void> deleteBuildingFloorById(long id);

    /**
     * 修改楼宇信息
     * 
     * @param modifyBuildingFloorVO
     * @return
     */
    public ResultDO<Void> modifyBuildingFloor(ModifyBuildingFloorVO modifyBuildingFloorVO);

    /**
     * 通过学院返回ClassDO
     * 
     * @param academy
     * @return
     */
    public ResultDO<List<ClassDO>> getClassDOsByAcademy(String academy);

    /**
     * 通过id返回AcademyDO
     * 
     * @param id
     * @return
     */
    public ResultDO<AcademyDO> getAcademyDOById(long id);

    /**
     * 通过id删除classDO
     * 
     * @param id
     * @return
     */
    public ResultDO<Void> deleteClassDOById(long id);

    /**
     * 修改classDO
     * 
     * @param modifyClassDOVO
     * @return
     */
    public ResultDO<Void> modifyClass(ModifyClassDOVO modifyClassDOVO);

    /**
     * 获取楼层枚举
     * 
     * @return
     */
    public ResultDO<List<String>> getEnumFloors();

    /**
     * 获取学年枚举
     * 
     * @return
     */
    public ResultDO<List<String>> getEnumYears();

    /**
     * 通过专业id返回professionDO
     * 
     * @param id
     * @return
     */
    public ResultDO<ProfessionDO> getProfessionDOById(long id);

    /**
     * 返回所有专业
     * 
     * @return
     */
    public ResultDO<List<ProfessionDO>> getProfessionDOs();

}
