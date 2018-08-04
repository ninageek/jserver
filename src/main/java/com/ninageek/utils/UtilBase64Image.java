package com.ninageek.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;

public class UtilBase64Image {
    public static String encoder(BufferedImage img) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ImageIO.write(img, "jpg", bos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] data = bos.toByteArray();
        return Base64.getEncoder().encodeToString(data);

    }

    public static BufferedImage decoder(String base64Image) {
        // Converting a Base64 String into Image byte array
        byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
        try {
            return ImageIO.read(new ByteArrayInputStream(imageByteArray));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}



