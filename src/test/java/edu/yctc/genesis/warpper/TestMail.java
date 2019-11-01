package edu.yctc.genesis.warpper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.yctc.genesis.Application;
import edu.yctc.genesis.util.CaptchaUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestMail {

    @Autowired
    private MailWarpper mailWarpper;

    /**
     * 测试mail发送
     *
     * @throws Exception
     */
    @Test
    public void sendmail() throws Exception {
        String number = CaptchaUtil.generateVerificationCode();// 随机数
        String toMail = "1527215026@qq.com";
        String subject = "验证码已送到";
        String text = "验证码:" + number;
        mailWarpper.sendMail(toMail, subject, text);
    }
}
