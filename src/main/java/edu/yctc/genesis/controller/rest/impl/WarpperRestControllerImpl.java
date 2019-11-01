package edu.yctc.genesis.controller.rest.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.yctc.genesis.constant.ResultCode;
import edu.yctc.genesis.controller.rest.WarpperRestController;
import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.entity.UserDO;
import edu.yctc.genesis.service.MessageIService;
import edu.yctc.genesis.service.UserIService;

@RestController
@ComponentScan({"edu.yctc.genesis.service"})
@RequestMapping("/restwarpper")
@Async
/**
 * warpper rest接口实现
 * 
 * @author 15272
 */
public class WarpperRestControllerImpl implements WarpperRestController {

    @Autowired
    private MessageIService messageService;

    @Autowired
    private UserIService userService;

    @Override
    @PostMapping("send-mail")
    public ResultDO<Void> sendMail(@RequestBody String mail) {
        if (StringUtils.isBlank(mail)) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        ResultDO<UserDO> resultDO = userService.getUserDOByMail(mail);
        if (resultDO.isSuccess() == false) {
            return new ResultDO<>(false, resultDO.getCode(), resultDO.getMsg());
        }
        return messageService.sendVerificationCodeMail(mail);
    }

    @Override
    @PostMapping("send-sms")
    public ResultDO<Void> sendSms(@RequestBody String mobile) {
        if (StringUtils.isBlank(mobile)) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        ResultDO<UserDO> resultDO = userService.getUserDOByPhone(mobile);
        if (resultDO.isSuccess() == false) {
            return new ResultDO<>(false, resultDO.getCode(), resultDO.getMsg());
        }
        return messageService.sendVerificationCodeSms(mobile);
    }

    @Override
    @PostMapping("send-mail-for-update-mail")
    public ResultDO<Void> sendEmailForUpdateMail(@RequestBody String mail) {
        if (StringUtils.isBlank(mail)) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        return messageService.sendVerificationCodeMail(mail);
    }

    @Override
    @PostMapping("send-sms-for-update-mobile")
    public ResultDO<Void> sendSmsForUpdateMobile(@RequestBody String mobile) {
        if (StringUtils.isBlank(mobile)) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        return messageService.sendVerificationCodeSms(mobile);
    }
}
