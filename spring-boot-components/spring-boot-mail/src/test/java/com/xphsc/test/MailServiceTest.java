package com.xphsc.test;

import com.xphsc.mail.MailApplication;
import com.xphsc.mail.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *  Created by ${huipei.x} on 2017-2-25
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= MailApplication.class)
public class MailServiceTest {


    @Autowired
    private MailService mailService;


    @Test
    public void testSimpleMail() throws Exception {
        mailService.sendSimpleMail(" xxxxx@163.com", "test simple mail", " hello this is simple mail");
    }

    @Test
    public void testHtmlMail() throws Exception {
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail(" xxxxx@163.com.com", "test simple mail", content);
    }

    @Test
    public void sendAttachmentsMail() {
        String filePath="\\tmp\\application.log";
        mailService.sendAttachmentsMail(" xxxxx@163.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
    }


    @Test
    public void sendInlineResourceMail() {
        String rscId = "neo006";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "\\Users\\summer\\Pictures\\favicon.png";

        mailService.sendInlineResourceMail(" xxxxx@163.com", "主题：这是有图片的邮件", content, imgPath, rscId);
    }



}
