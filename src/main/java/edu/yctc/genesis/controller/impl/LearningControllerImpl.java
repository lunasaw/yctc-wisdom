package edu.yctc.genesis.controller.impl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.yctc.genesis.constant.TemplatePath;
import edu.yctc.genesis.controller.LearningController;

@Controller
@ComponentScan({"edu.yctc.genesis.service"})
@RequestMapping("/learning")
/**
 * learningController接口实现
 *
 * @author wlt
 */
public class LearningControllerImpl implements LearningController {

    @Override
    @RequestMapping("my-class-quality")
    public String showMyClassQuality() {
        return TemplatePath.LEARNING_MY_CLASS_QUALITY;
    }

    @Override
    @RequestMapping("my-schedule")
    public String showMySchedule() {
        return TemplatePath.LEARNING_MY_SCHEDULE;
    }

}
