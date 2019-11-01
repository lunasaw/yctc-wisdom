package edu.yctc.genesis.controller.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.yctc.genesis.controller.rest.UserRestController;
import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.entity.UserDO;
import edu.yctc.genesis.service.UserIService;
import edu.yctc.genesis.vo.UserInformationVO;

@RestController
@ComponentScan({"edu.yctc.genesis.service"})
@RequestMapping("/restuser")
@Async
/**
 * userrest接口实现
 *
 * @author 15272
 */
public class UserRestControllerImpl implements UserRestController {

    @Autowired
    private UserIService userService;

    @Override
    @PostMapping("sign-up")
    public ResultDO<Void> signup(@RequestBody UserDO userDO) {
        return userService.signup(userDO);
    }

    @Override
    @PostMapping("sign-in")
    public ResultDO<Long> signin(@RequestBody UserDO userDO) {
        return userService.signin(userDO);
    }

    @Override
    @PostMapping("get-user-information-by-id")
    public ResultDO<UserInformationVO> getUserInformationById(@RequestBody long id) {
        return userService.getInformationByUserId(id);
    }

}
