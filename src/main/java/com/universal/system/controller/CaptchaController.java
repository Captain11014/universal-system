package com.universal.system.controller;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.convert.impl.UUIDConverter;
import cn.hutool.core.lang.UUID;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.universal.system.common.constant.Constants;
import com.universal.system.common.result.AjaxResult;
import com.universal.system.common.utils.RedisCache;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author 姓陈的
 * 2023/10/24 10:05
 * 获取验证码
 */
@RestController
public class CaptchaController {

    @Resource
    private DefaultKaptcha defaultKaptcha;

    @Resource
    private RedisCache redisCache;


    /**
     * 获取验证码
     * @return
     * @throws IOException
     */
    @GetMapping("/captchaImage")
    public AjaxResult getCaptchaImage() throws IOException {
        AjaxResult ajax = AjaxResult.success();

        //保存验证码到redis
        String uuid = UUID.randomUUID().toString();
        String captchaKey = Constants.CAPTCHA_CODE_KEY + uuid;

        //生成验证码
        String code = defaultKaptcha.createText();
        redisCache.setCacheObject(captchaKey,code,Constants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);
        BufferedImage image = defaultKaptcha.createImage(code);

        // 转换流信息写出
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();

        try {
            ImageIO.write(image,"jpg",os);
        } catch (IOException e) {
            return AjaxResult.error(e.getMessage());
        }
        ajax.put("uuid", uuid);
        ajax.put("captchaImage", Base64.encode(os.toByteArray()));
        return ajax;


    }




}
