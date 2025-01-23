package com.zzpig.train.business.controller;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/kaptcha")
public class KaptchaController {

    @Qualifier("getDefaultKaptcha")
    @Autowired
    DefaultKaptcha defaultKaptcha;

    @Resource
    public StringRedisTemplate stringRedisTemplate;

    @GetMapping("/image-code/{imageCodeToken}")
    public void generateCaptcha(@PathVariable String imageCodeToken, HttpServletResponse response) throws IOException {
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();

        // 1. 生成验证码文本
        String createText = defaultKaptcha.createText();
        // 2. 将验证码存入 Redis，有效期为 5 分钟
        stringRedisTemplate.opsForValue().set(imageCodeToken, createText, 300, TimeUnit.SECONDS);
        // 3. 生成验证码图片
        BufferedImage captchaImage = defaultKaptcha.createImage(createText);

        try {
            // 4. 将图片写入响应流
            ImageIO.write(captchaImage, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException | IOException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        byte[] captchaImageAsJpeg = jpegOutputStream.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(captchaImageAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }
}
