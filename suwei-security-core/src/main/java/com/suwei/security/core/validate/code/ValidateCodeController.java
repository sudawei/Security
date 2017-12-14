package com.suwei.security.core.validate.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : suwei
 * @description :
 * @date : 2017\12\13 0013 15:32
 */
@RestController
public class ValidateCodeController {

    public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";

    SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Autowired
    private ValidateCodeGenerator imageCodeGenerator;



    @GetMapping("/code/image")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //根据随机数生产图片
        ImageCode imageCode = imageCodeGenerator.generate(new ServletWebRequest(request));

        //将随机数存放到session中
        sessionStrategy.setAttribute(new ServletWebRequest(request),SESSION_KEY,imageCode);

        //将生产的图片返回
        ImageIO.write(imageCode.getImage(),"JPEG",response.getOutputStream());
    }

}
