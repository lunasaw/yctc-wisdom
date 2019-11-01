package edu.yctc.genesis.controller;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public interface TeachingController {

    /**
     * 展示教师-教室申请功能页面
     *
     * @param model
     * @param httpSession
     * @return
     */
    String showClassroomApplication(Model model, HttpSession httpSession);

    /**
     * 展示自己本学期的所有课堂
     * 
     * @param model
     * @param httpSession
     * @return
     */
    String showLessonDetailsList(Model model, HttpSession httpSession);

    /**
     * 展示指定课堂的详情页面
     * 
     * @param model
     * @param httpSession
     * @return
     */
    String showLessonDetailsDetails(Model model, HttpSession httpSession);

    /**
     * 展示自己本学期的所有课程
     * 
     * @param model
     * @param httpSession
     * @return
     */
    String showCourseDetailsList(Model model, HttpSession httpSession);

    /**
     * 展示指定课程的详情页面
     * 
     * @param model
     * @param httpSession
     * @return
     */
    String showCourseDetailsDetails(Model model, HttpSession httpSession);

    /**
     * 展示自己本学期的所有学生
     * 
     * @param model
     * @param httpSession
     * @return
     */
    String showStudentDetailsList(Model model, HttpSession httpSession);

    /**
     * 展示指定学生的详情页面
     * 
     * @param model
     * @param httpSession
     * @return
     */
    String showStudentDetailsDetails(Model model, HttpSession httpSession);

    /**
     * 展示教师-教学课表功能页面
     *
     * @return
     */
    String showTeachingSchedule();

    /**
     * 展示教师点名页
     * 
     * @return
     */
    String showCheckAttendance();

    /**
     * 展示状态检测页
     * 
     * @return
     */
    String showCheckState();

    /**
     * 展示知识点填写页A
     * 
     * @return
     */
    String showFillKnowledgeStepA();

    /**
     * 展示知识点填写页B
     * 
     * @return
     */
    String showFillKnowledgeStepB();

    /**
     * 展示知识点学情列表页
     * 
     * @return
     */
    String showLessonKnowledgePointList(Model model, HttpSession httpSession);

    /**
     * 展示知识点学情详情页
     * 
     * @return
     */
    String showLessonKnowledgePointDetails(Model model, HttpSession httpSession);
}
