package edu.yctc.genesis.controller.rest;

import java.util.List;

import edu.yctc.genesis.entity.BuildingFloorDO;
import edu.yctc.genesis.entity.ClassroomDO;
import edu.yctc.genesis.entity.LessonDO;
import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.vo.AcademyAndClassesAndUrlVO;
import edu.yctc.genesis.vo.AcademyAndClassesVO;
import edu.yctc.genesis.vo.AcademyVO;
import edu.yctc.genesis.vo.BuildingAndFloorVO;
import edu.yctc.genesis.vo.BuildingFloorAndUrlVO;
import edu.yctc.genesis.vo.ClassDOAndAcademyVO;
import edu.yctc.genesis.vo.ClassroomDOAndBuildingAndFloorVO;
import edu.yctc.genesis.vo.ClassroomDOAndUrlVO;
import edu.yctc.genesis.vo.CourseDTOAndClassesVO;
import edu.yctc.genesis.vo.CourseDTOAndUrlVO;
import edu.yctc.genesis.vo.ModifyBuildingFloorVO;
import edu.yctc.genesis.vo.ModifyClassDOVO;
import edu.yctc.genesis.vo.ModifyClassroomVO;
import edu.yctc.genesis.vo.ModifyCourseVO;
import edu.yctc.genesis.vo.ModifyStudentVO;
import edu.yctc.genesis.vo.ModifyTeacherVO;
import edu.yctc.genesis.vo.StudentDOAndAcademyAndClassesVO;
import edu.yctc.genesis.vo.StudentDOAndUrlVO;
import edu.yctc.genesis.vo.TeacherDOAndAcademyVO;
import edu.yctc.genesis.vo.TeacherDOAndUrlVO;
import edu.yctc.genesis.vo.YearAndTermVO;

public interface MetadataRestController {

    /**
     * 通过楼号返回楼号所有的楼层
     * 
     * @param building
     * @return
     */
    public ResultDO<List<String>> getFloorsByBuilding(String building);

    /**
     * 通过楼号和楼层号返回教室
     * 
     * @param buildingAndFloorVO
     * @return
     */
    public ResultDO<List<ClassroomDOAndUrlVO>> getClassroomDOByBuildingAndFloor(BuildingAndFloorVO buildingAndFloorVO);

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
     * classroomId和教室详情页url的拼接
     * 
     * @param id
     * @return
     */
    public ResultDO<String> getClassroomDmDetailUrl(long id);

    /**
     * classroomId和教室修改页url的拼接
     * 
     * @param id
     * @return
     */
    public ResultDO<String> getClassroomDmModifyUrl(long id);

    /**
     * 通过id返回classroomDO
     * 
     * @param id
     * @return
     */
    public ResultDO<ClassroomDO> getClassroomDOById(long id);

    /**
     * 返回库中学年集
     * 
     * @return
     */
    public ResultDO<List<String>> getYears();

    /**
     * 通过学年和学期获得课程集
     * 
     * @param yearAndTermVO
     * @return
     */
    public ResultDO<List<CourseDTOAndUrlVO>> getCourseDTOAndUrlVOByYearAndTerm(YearAndTermVO yearAndTermVO);

    /**
     * courseId和课程详情页url拼接
     * 
     * @param id
     * @return
     */
    public ResultDO<String> getCourseDmDetailUrl(long id);

    /**
     * courseId和课程修改页url拼接
     * 
     * @param id
     * @return
     */
    public ResultDO<String> getCourseDmModifyUrl(long id);

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
     * 通过id返回courseDTOAndClassesVO
     * 
     * @param id
     * @return
     */
    public ResultDO<CourseDTOAndClassesVO> getCourseDTOAndClassesVOById(long id);

    /**
     * 返回库中学院集
     * 
     * @return
     */
    public ResultDO<List<String>> getAcademies();

    /**
     * 通过学院名返回教师
     * 
     * @param buildAndFloorsVO
     * @return
     */
    public ResultDO<List<TeacherDOAndUrlVO>> getTeacherDOByAcademy(AcademyVO academyVO);

    /**
     * 教师id和教室详情页url的拼接
     * 
     * @param id
     * @return
     */
    public ResultDO<String> getTeacherDmDetailUrl(long id);

    /**
     * 教师Id和教室修改页url的拼接
     * 
     * @param id
     * @return
     */
    public ResultDO<String> getTeacherDmModifyUrl(long id);

    /**
     * 通过id返回taecherDO以及对应学院VO
     * 
     * @param id
     * @return
     */
    public ResultDO<TeacherDOAndAcademyVO> getTeacherDOAndAcademyVOById(long id);

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
     * 通过学院返回该学院所有班级
     * 
     * @param academy
     * @return
     */
    public ResultDO<List<String>> getClassesByAcademy(String academy);

    /**
     * 通过学院和班级VO返回学生集
     * 
     * @param academyAndClassesVO
     * @return
     */
    public ResultDO<List<StudentDOAndUrlVO>> getStudentDOByAcademyAndClassesVO(AcademyAndClassesVO academyAndClassesVO);

    /**
     * 通过id返回StudentDO以及对应学院班级VO
     * 
     * @param id
     * @return
     */
    public ResultDO<StudentDOAndAcademyAndClassesVO> getStudentDOAndAcademyAndClassesVOById(long id);

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
     * studentId和学生详情页url的拼接
     * 
     * @param id
     * @return
     */
    public ResultDO<String> getStudentDmDetailUrl(long id);

    /**
     * studentId和学生修改页url的拼接
     * 
     * @param id
     * @return
     */
    public ResultDO<String> getStudentDmModifyUrl(long id);

    /**
     * 通过id返回lessonDO
     * 
     * @param id
     * @return
     */
    public ResultDO<LessonDO> getLessonDOById(long id);

    /**
     * 通过id返回classrooDO以及对应楼层
     * 
     * @param id
     * @return
     */
    public ResultDO<ClassroomDOAndBuildingAndFloorVO> getClassroomDOAndbuildingAndFloorVOById(long id);

    /**
     * 通过楼号楼层返回BuildingFloorDO
     * 
     * @param buildingAndFloorVO
     * @return
     */
    public ResultDO<BuildingFloorDO> getBuildingFloorDOByBuildingAndFloor(BuildingAndFloorVO buildingAndFloorVO);

    /**
     * 通过楼号返回buildingFloorAndUrl集
     * 
     * @param building
     * @return
     */
    public ResultDO<List<BuildingFloorAndUrlVO>> getBuildingFloorDOsByBuilding(String building);

    /**
     * 通过id返回buildingFloorDO
     * 
     * @param id
     * @return
     */
    public ResultDO<BuildingFloorDO> getBuildingFloorDOById(long id);

    /**
     * 通过id删除buildingFlooDO
     * 
     * @param id
     * @return
     */
    public ResultDO<Void> deleteBuildingFloorById(long id);

    /**
     * 楼宇详情页url拼接
     * 
     * @param id
     * @return
     */
    public ResultDO<String> getBuildingFloorDmDetailUrl(long id);

    /**
     * 楼宇修改页url拼接
     * 
     * @param id
     * @return
     */
    public ResultDO<String> getBuildingFloorDmModifyUrl(long id);

    /**
     * 修改楼宇信息
     * 
     * @param modifyBuildingFloorVO
     * @return
     */
    public ResultDO<Void> modifyBuildingFloor(ModifyBuildingFloorVO modifyBuildingFloorVO);

    /**
     * 通过学院返回AcademyAndClassesAndUrlVO
     * 
     * @param academy
     * @return
     */
    public ResultDO<List<AcademyAndClassesAndUrlVO>> getAcademyAndClassesAndUrlVOByAcademy(String academy);

    /**
     * 通过id返回ClassDOAndAcademyVO
     * 
     * @param id
     * @return
     */
    public ResultDO<ClassDOAndAcademyVO> getClassDOAndAcademyVOById(long id);

    /**
     * 通过id删除classDO
     * 
     * @param id
     * @return
     */
    public ResultDO<Void> deleteClassById(long id);

    /**
     * 学院班级详情页url拼接
     * 
     * @param id
     * @return
     */
    public ResultDO<String> getAcademyClassesDmDetailUrl(long id);

    /**
     * 学院班级修改页url拼接
     * 
     * @param id
     * @return
     */
    public ResultDO<String> getAcademyClassesDmModifyUrl(long id);

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
     * 获取库中所有专业
     * 
     * @return
     */
    public ResultDO<List<String>> getProfessions();

    /**
     * 通过id返回专业
     * 
     * @param id
     * @return
     */
    public ResultDO<String> getProfessionById(long id);
}
