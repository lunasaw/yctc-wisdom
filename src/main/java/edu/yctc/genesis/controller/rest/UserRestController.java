package edu.yctc.genesis.controller.rest;

import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.entity.UserDO;
import edu.yctc.genesis.vo.UserInformationVO;

public interface UserRestController {

    /**
     * signup的rest方法
     *
     * @param userDO
     * @return
     */
    ResultDO<Void> signup(UserDO userDO);

    /**
     * signin的rest方法
     *
     * @param userDO
     * @return
     */
    ResultDO<Long> signin(UserDO userDO);

    /**
     * getUserInformationById的rest方法
     *
     * @param id
     * @return
     */
    ResultDO<UserInformationVO> getUserInformationById(long id);

}
