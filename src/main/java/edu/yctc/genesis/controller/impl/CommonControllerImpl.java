package edu.yctc.genesis.controller.impl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.yctc.genesis.constant.TemplatePath;
import edu.yctc.genesis.controller.CommonController;

@Controller
@ComponentScan({"edu.yctc.genesis.service"})
@RequestMapping("/")
/**
 * commonController接口实现
 *
 * @author wlt
 */
public class CommonControllerImpl implements CommonController {

    @Override
    @GetMapping("index")
    public String showIndex() {
        return TemplatePath.INDEX;
    }
}
