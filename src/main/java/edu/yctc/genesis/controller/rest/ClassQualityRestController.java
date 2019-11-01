package edu.yctc.genesis.controller.rest;

import java.util.List;

import javax.servlet.http.HttpSession;

import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.vo.ClassScoreVO;

public interface ClassQualityRestController {

    /**
     * 获取已经上完课的课堂评分
     * 
     * @param httpSession
     * @return
     */
    public ResultDO<List<ClassScoreVO>> getMyClassQuality(HttpSession httpSession);
}
