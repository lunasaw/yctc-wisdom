package edu.yctc.genesis.controller.rest.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.yctc.genesis.constant.ResultCode;
import edu.yctc.genesis.constant.entity.term.Term;
import edu.yctc.genesis.controller.rest.MetadataRestController;
import edu.yctc.genesis.entity.AcademyDO;
import edu.yctc.genesis.entity.BuildingFloorDO;
import edu.yctc.genesis.entity.ClassDO;
import edu.yctc.genesis.entity.ClassroomDO;
import edu.yctc.genesis.entity.CourseDO;
import edu.yctc.genesis.entity.LessonDO;
import edu.yctc.genesis.entity.ProfessionDO;
import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.entity.UserDO;
import edu.yctc.genesis.entity.transfer.CourseDTO;
import edu.yctc.genesis.service.MetaDataIService;
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

@RestController
@ComponentScan({"edu.yctc.genesis.service"})
@RequestMapping("/restmetadata")
/**
 * metadatarest接口实现
 *
 * @author 15272
 */
public class MetadataRestControllerImpl implements MetadataRestController {

    private static final String CLASSROOM_DM_DETAIL = "/genesis/metadata/classroom-dm-detail?id=";

    private static final String CLASSROOM_DM_MODIFY = "/genesis/metadata/classroom-dm-modify?id=";

    private static final String COURSE_DM_DETAIL = "/genesis/metadata/course-dm-detail?id=";

    private static final String COURSE_DM_MODIFY = "/genesis/metadata/course-dm-modify?id=";

    private static final String TEACHER_DM_DETAIL = "/genesis/metadata/teacher-dm-detail?id=";

    private static final String TEACHER_DM_MODIFY = "/genesis/metadata/teacher-dm-modify?id=";

    private static final String STUDENT_DM_DETAIL = "/genesis/metadata/student-dm-detail?id=";

    private static final String STUDENT_DM_MODIFY = "/genesis/metadata/student-dm-modify?id=";

    private static final String BUILDING_FLOOR_DM_DETAIL = "/genesis/metadata/building-floor-dm-detail?id=";

    private static final String BUILDING_FLOOR_DM_MODIFY = "/genesis/metadata/building-floor-dm-modify?id=";

    private static final String ACADEMY_CLASSES_DM_DETAIL = "/genesis/metadata/academy-classes-dm-detail?id=";

    private static final String ACADEMY_CLASSES_DM_MODIFY = "/genesis/metadata/academy-classes-dm-modify?id=";

    @Autowired
    private MetaDataIService metaDataService;

    // classroom metadata start
    @Override
    @PostMapping("get-buildings")
    public ResultDO<List<String>> getBuildings() {
        return metaDataService.getBuildings();
    }

    @Override
    @PostMapping("get-floors-by-building")
    public ResultDO<List<String>> getFloorsByBuilding(@RequestBody String building) {
        if (StringUtils.isBlank(building)) {
            return new ResultDO<List<String>>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        return metaDataService.getFloorsByBuilding(building);
    }

    @Override
    @PostMapping("get-classroomdo-by-building-and-floor")
    public ResultDO<List<ClassroomDOAndUrlVO>>
        getClassroomDOByBuildingAndFloor(@RequestBody BuildingAndFloorVO buildingAndFloorVO) {
        String building = buildingAndFloorVO.getBuilding();
        String floor = buildingAndFloorVO.getFloor();
        if (StringUtils.isBlank(building) || StringUtils.isBlank(floor)) {
            return new ResultDO<List<ClassroomDOAndUrlVO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<List<ClassroomDO>> resultDO = metaDataService.getClassroomDOByBuildingAndFloor(building, floor);
        if (resultDO.isSuccess() == false) {
            return new ResultDO<List<ClassroomDOAndUrlVO>>(false, resultDO.getCode(), resultDO.getMsg(), null);
        }

        List<ClassroomDOAndUrlVO> list = new ArrayList<>();
        List<ClassroomDO> classroomDOList = resultDO.getModule();
        // 给VO的classroomDO、url属性赋值
        for (ClassroomDO classroomDO : classroomDOList) {
            ClassroomDOAndUrlVO classroomDOAndUrlVO = new ClassroomDOAndUrlVO();
            classroomDOAndUrlVO.setClassroomDO(classroomDO);
            classroomDOAndUrlVO.setUrl(CLASSROOM_DM_DETAIL + classroomDO.getId());
            list.add(classroomDOAndUrlVO);
        }
        return new ResultDO<List<ClassroomDOAndUrlVO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
    }

    @Override
    @PostMapping("get-classroomdo-by-id")
    public ResultDO<ClassroomDO> getClassroomDOById(@RequestBody long id) {
        if (id <= 0) {
            return new ResultDO<ClassroomDO>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        return metaDataService.getClassroomDOById(id);
    }

    @Override
    @PostMapping("get-classroomdo-and-building-and-floor-vo-by-id")
    public ResultDO<ClassroomDOAndBuildingAndFloorVO> getClassroomDOAndbuildingAndFloorVOById(@RequestBody long id) {
        if (id <= 0) {
            return new ResultDO<ClassroomDOAndBuildingAndFloorVO>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        return metaDataService.getClassroomDOAndbuildingAndFloorVOById(id);
    }

    @Override
    @PostMapping("delete-classroom")
    public ResultDO<Void> deleteClassroom(@RequestBody long id) {
        if (id <= 0) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        return metaDataService.deleteClassroom(id);
    }

    @Override
    @PostMapping("modify-classroom")
    public ResultDO<Void> modifyClassroom(@RequestBody ModifyClassroomVO modifyClassroomVO) {
        if (modifyClassroomVO == null || StringUtils.isBlank(modifyClassroomVO.getBuilding())
            || StringUtils.isBlank(modifyClassroomVO.getFloor()) || StringUtils.isBlank(modifyClassroomVO.getNumber())
            || StringUtils.isBlank(modifyClassroomVO.getEquipmentId()) || modifyClassroomVO.getId() <= 0) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        return metaDataService.modifyClassroom(modifyClassroomVO);
    }

    @Override
    @PostMapping("get-classroom-dm-detail-url")
    public ResultDO<String> getClassroomDmDetailUrl(@RequestBody long id) {
        if (id <= 0) {
            return new ResultDO<String>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        String url = CLASSROOM_DM_DETAIL + id;
        return new ResultDO<String>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, url);
    }

    @Override
    @PostMapping("get-classroom-dm-modify-url")
    public ResultDO<String> getClassroomDmModifyUrl(@RequestBody long id) {
        if (id <= 0) {
            return new ResultDO<String>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        String url = CLASSROOM_DM_MODIFY + id;
        return new ResultDO<String>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, url);
    }
    // classroom metadata end

    // course metadata begin
    @Override
    @PostMapping("get-years")
    public ResultDO<List<String>> getYears() {
        return metaDataService.getYears();
    }

    @Override
    @PostMapping("get-coursedto-and-url-vo-by-year-and-term")
    public ResultDO<List<CourseDTOAndUrlVO>>
        getCourseDTOAndUrlVOByYearAndTerm(@RequestBody YearAndTermVO yearAndTermVO) {
        if (StringUtils.isBlank(yearAndTermVO.getYear())
            || (yearAndTermVO.getTerm() != Term.FIRSTSEMESTER && yearAndTermVO.getTerm() != Term.SECONDSEMESTER)) {
            return new ResultDO<List<CourseDTOAndUrlVO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<List<CourseDO>> resultDO = metaDataService.getCourseDOByYearAndTerm(yearAndTermVO.getYear(),
            yearAndTermVO.getTerm());
        if (resultDO.isSuccess() == false) {
            return new ResultDO<List<CourseDTOAndUrlVO>>(false, resultDO.getCode(), resultDO.getMsg(), null);
        }
        List<CourseDO> courseDOList = resultDO.getModule();
        // courseDO转换为courseDTO
        List<CourseDTO> courseDTOList = new ArrayList<>();
        for (CourseDO courseDO : courseDOList) {
            CourseDTO courseDTO = new CourseDTO(courseDO);
            courseDTOList.add(courseDTO);
        }
        List<CourseDTOAndUrlVO> courseDTOAndUrlVOList = new ArrayList<>();
        // 参数验证
        for (CourseDTO courseDTO : courseDTOList) {
            List<Long> classIdList = courseDTO.getClassId();
            for (long classId : classIdList) {
                if (classId <= 0) {
                    return new ResultDO<List<CourseDTOAndUrlVO>>(false, ResultCode.PARAMETER_INVALID,
                        ResultCode.MSG_PARAMETER_INVALID, null);
                }
                ResultDO<ClassDO> classDOResultDO = metaDataService.getClassDOById(classId);
                if (classDOResultDO.isSuccess() == false) {
                    return new ResultDO<List<CourseDTOAndUrlVO>>(false, classDOResultDO.getCode(),
                        classDOResultDO.getMsg(), null);
                }
            }
        }
        // 构造VO
        for (CourseDTO courseDTO : courseDTOList) {
            CourseDTOAndUrlVO courseDTOAndUrlVO = new CourseDTOAndUrlVO();
            courseDTOAndUrlVO.setCourseDTO(courseDTO);
            courseDTOAndUrlVO.setUrl(COURSE_DM_DETAIL + courseDTO.getId());
            // 获取班级集
            List<Long> classIdList = courseDTO.getClassId();
            List<ClassDO> classDOList = new ArrayList<>();
            for (long classId : classIdList) {
                ClassDO classDO = metaDataService.getClassDOById(classId).getModule();
                classDOList.add(classDO);
            }
            courseDTOAndUrlVO.setClassDOList(classDOList);
            courseDTOAndUrlVOList.add(courseDTOAndUrlVO);
        }
        return new ResultDO<List<CourseDTOAndUrlVO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            courseDTOAndUrlVOList);
    }

    @Override
    @PostMapping("get-course-dm-detail-url")
    public ResultDO<String> getCourseDmDetailUrl(@RequestBody long id) {
        if (id <= 0) {
            return new ResultDO<String>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        String url = COURSE_DM_DETAIL + id;
        return new ResultDO<String>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, url);
    }

    @Override
    @PostMapping("get-course-dm-modify-url")
    public ResultDO<String> getCourseDmModifyUrl(@RequestBody long id) {
        if (id <= 0) {
            return new ResultDO<String>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        String url = COURSE_DM_MODIFY + id;
        return new ResultDO<String>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, url);
    }

    @Override
    @PostMapping("get-coursedto-and-classes-vo-by-id")
    public ResultDO<CourseDTOAndClassesVO> getCourseDTOAndClassesVOById(@RequestBody long id) {
        if (id <= 0) {
            return new ResultDO<CourseDTOAndClassesVO>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        return metaDataService.getCourseDTOAndClassesVOById(id);
    }

    @Override
    @PostMapping("delete-course")
    public ResultDO<Void> deleteCourse(@RequestBody long id) {
        if (id <= 0) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        return metaDataService.deleteCourse(id);
    }

    @Override
    @PostMapping("modify-course")
    public ResultDO<Void> modifyCourse(@RequestBody ModifyCourseVO modifyCourseVO) {
        if (StringUtils.isBlank(modifyCourseVO.getClassId()) || StringUtils.isBlank(modifyCourseVO.getName())
            || StringUtils.isBlank(modifyCourseVO.getNumber()) || StringUtils.isBlank(modifyCourseVO.getProfession())
            || StringUtils.isBlank(modifyCourseVO.getYear()) || modifyCourseVO.getId() <= 0
            || modifyCourseVO.getLessonSum() <= 0
            || (modifyCourseVO.getTerm() != Term.FIRSTSEMESTER && modifyCourseVO.getTerm() != Term.SECONDSEMESTER)) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        return metaDataService.modifyCourse(modifyCourseVO);
    }

    @Override
    @PostMapping("get-enum-years")
    public ResultDO<List<String>> getEnumYears() {
        return metaDataService.getEnumYears();
    }

    @Override
    @PostMapping("get-professions")
    public ResultDO<List<String>> getProfessions() {
        ResultDO<List<ProfessionDO>> resultDO = metaDataService.getProfessionDOs();
        if (resultDO.isSuccess() == false) {
            return new ResultDO<List<String>>(false, resultDO.getCode(), resultDO.getMsg(), null);
        }
        // 获取专业
        List<String> list = new ArrayList<>();
        for (ProfessionDO professionDO : resultDO.getModule()) {
            list.add(professionDO.getProfession());
        }
        return new ResultDO<List<String>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
    }

    @Override
    @PostMapping("get-profession-by-id")
    public ResultDO<String> getProfessionById(@RequestBody long id) {
        if (id <= 0) {
            return new ResultDO<String>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<ProfessionDO> resultDO = metaDataService.getProfessionDOById(id);
        if (resultDO.isSuccess() == false) {
            return new ResultDO<String>(false, resultDO.getCode(), resultDO.getMsg(), null);
        }
        return new ResultDO<String>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            resultDO.getModule().getProfession());
    }
    // course metadata end

    // teacher metadata start
    @Override
    @PostMapping("get-academies")
    public ResultDO<List<String>> getAcademies() {
        return metaDataService.getAcademies();
    }

    @Override
    @PostMapping("get-teacherdo-by-academy")
    public ResultDO<List<TeacherDOAndUrlVO>> getTeacherDOByAcademy(@RequestBody AcademyVO academyVO) {
        String academy = academyVO.getAcademy();
        if (StringUtils.isBlank(academy)) {
            return new ResultDO<List<TeacherDOAndUrlVO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<List<UserDO>> resultDO = metaDataService.getTeacherDOByAcademy(academy);
        if (resultDO.isSuccess() == false) {
            return new ResultDO<List<TeacherDOAndUrlVO>>(false, resultDO.getCode(), resultDO.getMsg(), null);
        }
        List<TeacherDOAndUrlVO> list = new ArrayList<>();
        List<UserDO> teacherDOList = resultDO.getModule();
        // 给VO的teacherDO和url属性赋值
        for (UserDO teacherDO : teacherDOList) {
            TeacherDOAndUrlVO teacherDOAndUrlVO = new TeacherDOAndUrlVO();
            teacherDOAndUrlVO.setUserDO(teacherDO);
            teacherDOAndUrlVO.setUrl(TEACHER_DM_DETAIL + teacherDO.getId());
            list.add(teacherDOAndUrlVO);
        }
        return new ResultDO<List<TeacherDOAndUrlVO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
    }

    @Override
    @PostMapping("get-teacher-dm-detail-url")
    public ResultDO<String> getTeacherDmDetailUrl(@RequestBody long id) {
        if (id <= 0) {
            return new ResultDO<String>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        String url = TEACHER_DM_DETAIL + id;
        return new ResultDO<String>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, url);
    }

    @Override
    @PostMapping("get-teacher-dm-modify-url")
    public ResultDO<String> getTeacherDmModifyUrl(@RequestBody long id) {
        if (id <= 0) {
            return new ResultDO<String>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        String url = TEACHER_DM_MODIFY + id;
        return new ResultDO<String>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, url);
    }

    @Override
    @PostMapping("get-teacherdo-and-academy-vo-by-id")
    public ResultDO<TeacherDOAndAcademyVO> getTeacherDOAndAcademyVOById(@RequestBody long id) {
        if (id <= 0) {
            return new ResultDO<TeacherDOAndAcademyVO>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        return metaDataService.getTeacherDOAndAcademyVOById(id);
    }

    @Override
    @PostMapping("delete-teacher")
    public ResultDO<Void> deleteTeacher(@RequestBody long id) {
        if (id <= 0) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        return metaDataService.deleteTeacher(id);
    }

    @Override
    @PostMapping("modify-teacher")
    public ResultDO<Void> modifyTeacher(@RequestBody ModifyTeacherVO modifyTeacherVO) {
        if (modifyTeacherVO == null || StringUtils.isBlank(modifyTeacherVO.getAcademy())
            || StringUtils.isBlank(modifyTeacherVO.getNumber()) || StringUtils.isBlank(modifyTeacherVO.getSex())
            || StringUtils.isBlank(modifyTeacherVO.getIdCardNumber()) || StringUtils.isBlank(modifyTeacherVO.getPhone())
            || StringUtils.isBlank(modifyTeacherVO.getMail()) || StringUtils.isBlank(modifyTeacherVO.getFaceToken())
            || StringUtils.isBlank(modifyTeacherVO.getName()) || modifyTeacherVO.getId() <= 0) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        return metaDataService.modifyTeacher(modifyTeacherVO);
    }
    // teacher metadata end

    // student metadata start
    @Override
    @PostMapping("get-classes-by-academy")
    public ResultDO<List<String>> getClassesByAcademy(@RequestBody String academy) {
        if (StringUtils.isBlank(academy) == true) {
            return new ResultDO<List<String>>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        return metaDataService.getClassesByAcademy(academy);
    }

    @Override
    @PostMapping("get-studentdo-by-academy-and-classes-vo")
    public ResultDO<List<StudentDOAndUrlVO>>
        getStudentDOByAcademyAndClassesVO(@RequestBody AcademyAndClassesVO academyAndClassesVO) {
        String academy = academyAndClassesVO.getAcademy();
        String classes = academyAndClassesVO.getClasses();
        if (StringUtils.isBlank(academy) || StringUtils.isBlank(classes)) {
            return new ResultDO<List<StudentDOAndUrlVO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<List<UserDO>> resultDO = metaDataService.getStudentDOByAcademyAndClasses(academy, classes);
        if (resultDO.isSuccess() == false) {
            return new ResultDO<List<StudentDOAndUrlVO>>(false, resultDO.getCode(), resultDO.getMsg(), null);
        }

        List<StudentDOAndUrlVO> list = new ArrayList<>();
        List<UserDO> studentDOList = resultDO.getModule();
        // 给VO的studentDO和url属性赋值
        for (UserDO studentDO : studentDOList) {
            StudentDOAndUrlVO studentDOAndUrlVO = new StudentDOAndUrlVO();
            studentDOAndUrlVO.setUserDO(studentDO);
            studentDOAndUrlVO.setUrl(STUDENT_DM_DETAIL + studentDO.getId());
            list.add(studentDOAndUrlVO);
        }
        return new ResultDO<List<StudentDOAndUrlVO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
    }

    @Override
    @PostMapping("get-studentdo-and-academy-and-classes-vo-by-id")
    public ResultDO<StudentDOAndAcademyAndClassesVO> getStudentDOAndAcademyAndClassesVOById(@RequestBody long id) {
        if (id <= 0) {
            return new ResultDO<StudentDOAndAcademyAndClassesVO>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        return metaDataService.getStudentDOAndAcademyAndClassesVOById(id);
    }

    @Override
    @PostMapping("get-student-dm-detail-url")
    public ResultDO<String> getStudentDmDetailUrl(@RequestBody long id) {
        if (id <= 0) {
            return new ResultDO<String>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        String url = STUDENT_DM_DETAIL + id;
        return new ResultDO<String>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, url);
    }

    @Override
    @PostMapping("get-student-dm-modify-url")
    public ResultDO<String> getStudentDmModifyUrl(@RequestBody long id) {
        if (id <= 0) {
            return new ResultDO<String>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        String url = STUDENT_DM_MODIFY + id;
        return new ResultDO<String>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, url);
    }

    @Override
    @PostMapping("delete-student")
    public ResultDO<Void> deleteStudent(@RequestBody long id) {
        if (id <= 0) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        return metaDataService.deleteStudent(id);
    }

    @Override
    @PostMapping("modify-student")
    public ResultDO<Void> modifyStudent(@RequestBody ModifyStudentVO modifyStudentVO) {
        if (modifyStudentVO == null || StringUtils.isBlank(modifyStudentVO.getAcademy())
            || StringUtils.isBlank(modifyStudentVO.getNumber()) || StringUtils.isBlank(modifyStudentVO.getSex())
            || StringUtils.isBlank(modifyStudentVO.getIdCardNumber()) || StringUtils.isBlank(modifyStudentVO.getPhone())
            || StringUtils.isBlank(modifyStudentVO.getMail())
            // || StringUtils.isBlank(modifyStudentVO.getPicture())
            || StringUtils.isBlank(modifyStudentVO.getFaceToken()) || StringUtils.isBlank(modifyStudentVO.getName())
            || StringUtils.isBlank(modifyStudentVO.getClasses()) || modifyStudentVO.getId() <= 0) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        return metaDataService.modifyStudent(modifyStudentVO);
    }
    // student metadata end

    @Override
    @PostMapping("get-lessondo-by-id")
    public ResultDO<LessonDO> getLessonDOById(@RequestBody long id) {
        if (id <= 0) {
            return new ResultDO<LessonDO>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        return metaDataService.getLessonDOById(id);
    }

    // building floor metadata begin
    @Override
    @PostMapping("get-buildingfloordo-by-building-and-floor")
    public ResultDO<BuildingFloorDO>
        getBuildingFloorDOByBuildingAndFloor(@RequestBody BuildingAndFloorVO buildingAndFloorVO) {
        if (StringUtils.isBlank(buildingAndFloorVO.getBuilding())
            || StringUtils.isBlank(buildingAndFloorVO.getFloor())) {
            return new ResultDO<BuildingFloorDO>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        return metaDataService.getBuildingFloorDOByBuildingAndFloor(buildingAndFloorVO.getBuilding(),
            buildingAndFloorVO.getFloor());
    }

    @Override
    @PostMapping("get-buildingfloorandurlvo-by-building")
    public ResultDO<List<BuildingFloorAndUrlVO>> getBuildingFloorDOsByBuilding(@RequestBody String building) {
        if (StringUtils.isBlank(building)) {
            return new ResultDO<List<BuildingFloorAndUrlVO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<List<BuildingFloorDO>> resultDO = metaDataService.getBuildingFloorDOsByBuilding(building);
        if (resultDO.isSuccess() == false) {
            return new ResultDO<List<BuildingFloorAndUrlVO>>(false, resultDO.getCode(), resultDO.getMsg(), null);
        }
        // 构建VO
        List<BuildingFloorAndUrlVO> list = new ArrayList<>();
        List<BuildingFloorDO> buildingFloorDOList = resultDO.getModule();
        for (BuildingFloorDO buildingFloorDO : buildingFloorDOList) {
            BuildingFloorAndUrlVO buildingFloorAndUrlVO = new BuildingFloorAndUrlVO();
            buildingFloorAndUrlVO.setBuildingFloorDO(buildingFloorDO);
            buildingFloorAndUrlVO.setUrl(BUILDING_FLOOR_DM_DETAIL + buildingFloorDO.getId());
            list.add(buildingFloorAndUrlVO);
        }
        return new ResultDO<List<BuildingFloorAndUrlVO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
    }

    @Override
    @PostMapping("get-buildingfloordo-by-id")
    public ResultDO<BuildingFloorDO> getBuildingFloorDOById(@RequestBody long id) {
        if (id <= 0) {
            return new ResultDO<BuildingFloorDO>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        return metaDataService.getBuildingFloorDOById(id);
    }

    @Override
    @PostMapping("delete-building-floor-by-id")
    public ResultDO<Void> deleteBuildingFloorById(@RequestBody long id) {
        if (id <= 0) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        return metaDataService.deleteBuildingFloorById(id);
    }

    @Override
    @PostMapping("get-building-floor-dm-detail-url")
    public ResultDO<String> getBuildingFloorDmDetailUrl(@RequestBody long id) {
        if (id <= 0) {
            return new ResultDO<String>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        String url = BUILDING_FLOOR_DM_DETAIL + id;
        return new ResultDO<String>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, url);
    }

    @Override
    @PostMapping("get-building-floor-dm-modify-url")
    public ResultDO<String> getBuildingFloorDmModifyUrl(@RequestBody long id) {
        if (id <= 0) {
            return new ResultDO<String>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        String url = BUILDING_FLOOR_DM_MODIFY + id;
        return new ResultDO<String>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, url);
    }

    @Override
    @PostMapping("modify-building-floor")
    public ResultDO<Void> modifyBuildingFloor(@RequestBody ModifyBuildingFloorVO modifyBuildingFloorVO) {
        if (modifyBuildingFloorVO.getId() <= 0 || StringUtils.isBlank(modifyBuildingFloorVO.getBuilding())
            || StringUtils.isBlank(modifyBuildingFloorVO.getFloor())) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        return metaDataService.modifyBuildingFloor(modifyBuildingFloorVO);
    }

    @Override
    @PostMapping("get-enum-floors")
    public ResultDO<List<String>> getEnumFloors() {
        return metaDataService.getEnumFloors();
    }
    // building floor metadata end

    // academy classes metadata begin
    @Override
    @PostMapping("get-academy-and-classes-and-url-vo-by-academy")
    public ResultDO<List<AcademyAndClassesAndUrlVO>>
        getAcademyAndClassesAndUrlVOByAcademy(@RequestBody String academy) {
        if (StringUtils.isBlank(academy)) {
            return new ResultDO<List<AcademyAndClassesAndUrlVO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<List<ClassDO>> resultDO = metaDataService.getClassDOsByAcademy(academy);
        if (resultDO.isSuccess() == false) {
            return new ResultDO<List<AcademyAndClassesAndUrlVO>>(false, resultDO.getCode(), resultDO.getMsg(), null);
        }
        // 构建VO
        List<AcademyAndClassesAndUrlVO> list = new ArrayList<>();
        for (ClassDO classDO : resultDO.getModule()) {
            AcademyAndClassesAndUrlVO academyAndClassesAndUrlVO = new AcademyAndClassesAndUrlVO();
            academyAndClassesAndUrlVO.setAcademy(academy);
            academyAndClassesAndUrlVO.setClassDO(classDO);
            academyAndClassesAndUrlVO.setUrl(ACADEMY_CLASSES_DM_DETAIL + classDO.getId());
            list.add(academyAndClassesAndUrlVO);
        }
        return new ResultDO<List<AcademyAndClassesAndUrlVO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
    }

    @Override
    @PostMapping("get-classdo-and-academy-vo-by-id")
    public ResultDO<ClassDOAndAcademyVO> getClassDOAndAcademyVOById(@RequestBody long id) {
        if (id <= 0) {
            return new ResultDO<ClassDOAndAcademyVO>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<ClassDO> resultDO = metaDataService.getClassDOById(id);
        if (resultDO.isSuccess() == false) {
            return new ResultDO<ClassDOAndAcademyVO>(false, resultDO.getCode(), resultDO.getMsg(), null);
        }
        // 构建VO
        ResultDO<AcademyDO> getAcademyDOByIdResultDO =
            metaDataService.getAcademyDOById(resultDO.getModule().getAcademyId());
        if (getAcademyDOByIdResultDO.isSuccess() == false) {
            return new ResultDO<ClassDOAndAcademyVO>(false, getAcademyDOByIdResultDO.getCode(),
                getAcademyDOByIdResultDO.getMsg(), null);
        }
        ResultDO<ProfessionDO> getProfessionDOByIdResultDO =
            metaDataService.getProfessionDOById(resultDO.getModule().getProfessionId());
        if (getProfessionDOByIdResultDO.isSuccess() == false) {
            return new ResultDO<ClassDOAndAcademyVO>(false, getProfessionDOByIdResultDO.getCode(),
                getProfessionDOByIdResultDO.getMsg(), null);
        }
        ClassDOAndAcademyVO classDOAndAcademyVO = new ClassDOAndAcademyVO();
        classDOAndAcademyVO.setAcademy(getAcademyDOByIdResultDO.getModule().getAcademy());
        classDOAndAcademyVO.setProfession(getProfessionDOByIdResultDO.getModule().getProfession());
        classDOAndAcademyVO.setClassDO(resultDO.getModule());
        return new ResultDO<ClassDOAndAcademyVO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, classDOAndAcademyVO);
    }

    @Override
    @PostMapping("delete-class-by-id")
    public ResultDO<Void> deleteClassById(@RequestBody long id) {
        if (id <= 0) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        return metaDataService.deleteClassDOById(id);
    }

    @Override
    @PostMapping("get-academy-classes-dm-detail-url")
    public ResultDO<String> getAcademyClassesDmDetailUrl(@RequestBody long id) {
        if (id <= 0) {
            return new ResultDO<String>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        String url = ACADEMY_CLASSES_DM_DETAIL + id;
        return new ResultDO<String>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, url);
    }

    @Override
    @PostMapping("get-academy-classes-dm-modify-url")
    public ResultDO<String> getAcademyClassesDmModifyUrl(@RequestBody long id) {
        if (id <= 0) {
            return new ResultDO<String>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        String url = ACADEMY_CLASSES_DM_MODIFY + id;
        return new ResultDO<String>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, url);
    }

    @Override
    @PostMapping("modify-class")
    public ResultDO<Void> modifyClass(@RequestBody ModifyClassDOVO modifyClassDOVO) {
        if (modifyClassDOVO.getId() <= 0 || StringUtils.isBlank(modifyClassDOVO.getAcademy())
            || StringUtils.isBlank(modifyClassDOVO.getNumber())
            || StringUtils.isBlank(modifyClassDOVO.getProfession())) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        return metaDataService.modifyClass(modifyClassDOVO);
    }
    // academy classes metadata end

}
