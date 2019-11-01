package edu.yctc.genesis.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.yctc.genesis.constant.TemplatePath;
import edu.yctc.genesis.controller.MetadataController;

@Controller
@ComponentScan({"edu.yctc.genesis.service"})
@RequestMapping("/metadata")
/**
 * MetadataController实现
 *
 * @author 15272
 */
public class MetadataControllerImpl implements MetadataController {

    private final static Logger LOG = LoggerFactory.getLogger("controllerLogger");

    @Override
    @GetMapping("classroom-dm-list")
    public String showClassroomDmList() {
        return TemplatePath.METADATA_CLASSROOM_DM_LIST;
    }

    @Override
    @GetMapping("classroom-dm-detail")
    public String showClassroomDmDetail() {
        return TemplatePath.METADATA_CLASSROOM_DM_DETAIL;
    }

    @Override
    @GetMapping("classroom-dm-modify")
    public String showClassroomDmModify() {
        return TemplatePath.METADATA_CLASSROOM_DM_MODIFY;
    }

    @Override
    @GetMapping("course-dm-detail")
    public String showCourseDmDetail() {
        return TemplatePath.METADATA_COURSE_DM_DETAIL;
    }

    @Override
    @GetMapping("course-dm-list")
    public String showCourseDmList() {
        return TemplatePath.METADATA_COURSE_DM_LIST;
    }

    @Override
    @GetMapping("course-dm-modify")
    public String showCourseDmModify() {
        return TemplatePath.METADATA_COURSE_DM_MODIFY;
    }

    @Override
    @GetMapping("teacher-dm-list")
    public String showTeacherDmList() {
        return TemplatePath.METADATA_TEACHER_DM_LIST;
    }

    @Override
    @GetMapping("teacher-dm-detail")
    public String showTeacherDmDetail() {
        return TemplatePath.METADATA_TEACHER_DM_DETAIL;
    }

    @Override
    @GetMapping("teacher-dm-modify")
    public String showTeacherDmModify() {
        return TemplatePath.METADATA_TEACHER_DM_MODIFY;
    }

    @Override
    @GetMapping("student-dm-list")
    public String showStudentDmList() {
        return TemplatePath.METADATA_STUDENT_DM_LIST;
    }

    @Override
    @GetMapping("student-dm-detail")
    public String showStudentDmDetail() {
        return TemplatePath.METADATA_STUDENT_DM_DETAIL;
    }

    @Override
    @GetMapping("student-dm-modify")
    public String showStudentDmModify() {
        return TemplatePath.METADATA_STUDENT_DM_MODIFY;
    }

    @Override
    @GetMapping("building-floor-dm-list")
    public String showBuildingFloorDmList() {
        return TemplatePath.METADATA_BUILDING_FLOOR_DM_LIST;
    }

    @Override
    @GetMapping("building-floor-dm-detail")
    public String showBuildingFloorDmDetail() {
        return TemplatePath.METADATA_BUILDING_FLOOR_DM_DETAIL;
    }

    @Override
    @GetMapping("building-floor-dm-modify")
    public String showBuildingFloorDmModify() {
        return TemplatePath.METADATA_BUILDING_FLOOR_DM_MODIFY;
    }

    @Override
    @GetMapping("academy-classes-dm-list")
    public String showAcademyClassesDmList() {
        return TemplatePath.METADATA_ACADEMY_CLASSES_DM_LIST;
    }

    @Override
    @GetMapping("academy-classes-dm-detail")
    public String showAcademyClassesDmDetail() {
        return TemplatePath.METADATA_ACADEMY_CLASSES_DM_DETAIL;
    }

    @Override
    @GetMapping("academy-classes-dm-modify")
    public String showAcademyClassesDmModify() {
        return TemplatePath.METADATA_ACADEMY_CLASSES_DM_MODIFY;
    }
}
