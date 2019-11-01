package edu.yctc.genesis.warpper;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.yctc.genesis.util.CaptchaUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSms {

    @Autowired
    private SmsWarpper smsWarpper;

    @Test
    public void sendsms() throws IOException {
        String captcha = CaptchaUtil.generateVerificationCode();
        String mobile = "17715939829";
        String text = "【哈沐信息技术】您的验证码是" + captcha + "。如非本人操作，请忽略本短信。";
        boolean result = smsWarpper.sendSms(text, mobile);
        assertTrue(result);
    }
}
