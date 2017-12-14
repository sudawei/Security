package com.suwei.security.core.validate.code.image;

import com.suwei.security.core.validate.code.ValidateCode;

import java.awt.image.BufferedImage;

/**
 * @author : suwei
 * @description : 图片验证码
 * @date : 2017\12\13 0013 14:40
 */
public class ImageCode extends ValidateCode {

    private BufferedImage image;

    public ImageCode(BufferedImage image, String code, int expireIn) {
        super(code, expireIn);
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }


}
