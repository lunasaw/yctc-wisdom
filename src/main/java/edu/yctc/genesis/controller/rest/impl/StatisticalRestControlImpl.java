package edu.yctc.genesis.controller.rest.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.yctc.genesis.controller.rest.StatisticalRestControl;
import edu.yctc.genesis.service.StatisticalIService;

/**
 * 统计rest实现
 * 
 * @author 15272
 */
@RestController
@ComponentScan({"edu.yctc.genesis.service"})
@RequestMapping("/reststatical")
public class StatisticalRestControlImpl implements StatisticalRestControl {

    @Autowired
    private StatisticalIService statisticalService;

    @Override
    @PostMapping("get-classroom-using-state")
    public Map<String, Integer> getClassroomUsingState() {
        return statisticalService.getClassroomUsingState();
    }

}
