package edu.yctc.genesis.controller.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import edu.yctc.genesis.dao.TeacherLessonDAO;
import edu.yctc.genesis.dao.UserDAO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.yctc.genesis.constant.TemplatePath;
import edu.yctc.genesis.controller.TeachingController;
import edu.yctc.genesis.controller.session.SessionContentHolder;

@Controller
@ComponentScan({"edu.yctc.genesis.service"})
@RequestMapping("/teaching")
/**
 * teachingController接口实现
 *
 * @author wlt
 */
public class TeachingControllerImpl implements TeachingController {

    @Resource
    TeacherLessonDAO teacherLessonDAO;//老师课时

    @Override
    @RequestMapping("classroom-application")
    public String showClassroomApplication(Model model, HttpSession httpSession) {
        long userId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
        model.addAttribute("userId", userId);
        return TemplatePath.TEACHING_CLASSROOM_APPLICATION;
    }

    @Override
    @GetMapping("lesson-details-list")
    public String showLessonDetailsList(Model model, HttpSession httpSession) {
        long userId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
        model.addAttribute("userId", userId);
        return TemplatePath.LESSON_DETAILS_LIST;
    }

    @Override
    @GetMapping("lesson-details-details")
    public String showLessonDetailsDetails(Model model, HttpSession httpSession) {
        long userId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
        model.addAttribute("userId", userId);
        return TemplatePath.LESSON_DETAILS_DETAILS;
    }

    @Override
    @GetMapping("course-details-list")
    public String showCourseDetailsList(Model model, HttpSession httpSession) {
        long userId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
        model.addAttribute("userId", userId);
        return TemplatePath.TEACHING_COURSE_DETAILS_LIST;
    }

    @Override
    @GetMapping("course-details-details")
    public String showCourseDetailsDetails(Model model, HttpSession httpSession) {
        long userId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
        model.addAttribute("userId", userId);
        return TemplatePath.TEACHING_COURSE_DETAILS_DETAILS;
    }

    @Override
    @GetMapping("student-details-list")
    public String showStudentDetailsList(Model model, HttpSession httpSession) {
        long userId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
        model.addAttribute("userId", userId);
        return TemplatePath.TEACHING_STUDENT_DETAILS_LIST;
    }

    @Override
    @GetMapping("student-details-details")
    public String showStudentDetailsDetails(Model model, HttpSession httpSession) {
        long userId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
        model.addAttribute("userId", userId);
        return TemplatePath.TEACHING_STUDENT_DETAILS_DETAILS;
    }

    @Override
    @RequestMapping("teaching-schedule")
    public String showTeachingSchedule() {
        return TemplatePath.TEACHING_TEACHING_SCHEDULE;
    }

    @Override
    @GetMapping("check-attendance")
    public String showCheckAttendance() {
        return TemplatePath.TEACHING_CHECK_ATTENDANCE;
    }

    @Override
    @GetMapping("check-state")
    public String showCheckState() {
        return TemplatePath.TEACHING_CHECK_STATE;
    }

    @Override
    @GetMapping("lesson-knowledge-point-list")
    public String showLessonKnowledgePointList(Model model, HttpSession httpSession) {
        long userId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
        System.out.println(userId);
        model.addAttribute("userId", userId);
        return TemplatePath.TEACHING_LESSON_KNOWLEDGE_POINT_LIST;
    }

    @Override
    @GetMapping("lesson-knowledge-point-list-a")
    public String showLessonKnowledgePointList_a(Model model, HttpSession httpSession) {
        long userId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
        System.out.println(userId);
        model.addAttribute("userId", userId);
        return TemplatePath.TEACHING_LESSON_KNOWLEDGE_POINT_LIST_A;
    }

    @Override
    @GetMapping("lesson-knowledge-point-details")
    public String showLessonKnowledgePointDetails(Model model, HttpSession httpSession) {
        long userId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
        System.out.println(userId);
        model.addAttribute("userId", userId);
        return TemplatePath.TEACHING_LESSON_KNOWLEDGE_POINT_DETAILS;
    }

    @Override
    @GetMapping("lesson-knowledge-point-details-a")
    public String showLessonKnowledgePointDetails_a(Model model, HttpSession httpSession) {
        long userId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
        System.out.println(userId);
        model.addAttribute("userId", userId);
        return TemplatePath.TEACHING_LESSON_KNOWLEDGE_POINT_DETAILS_A;
    }

    @Override
    @GetMapping("fill-knowledge-step-a")
    public String showFillKnowledgeStepA() {
        return TemplatePath.TEACHING_FILL_KNOWLEDGE_STEP_A;
    }

    @Override
    @GetMapping("fill-knowledge-step-b")
    public String showFillKnowledgeStepB() {
        return TemplatePath.TEACHING_FILL_KNOWLEDGE_STEP_B;
    }

}
