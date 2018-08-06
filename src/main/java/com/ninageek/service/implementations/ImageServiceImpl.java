package com.ninageek.service.implementations;

import com.ninageek.dto.Image;
import com.ninageek.service.ImageService;
import com.ninageek.utils.UtilBase64Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ServletContext servletContext;

    public BufferedImage testMask(BufferedImage img) {
        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                if (y % 5 == 0) img.setRGB(x, y, 0xffffff);
            }
        }
        return img;
    }

    public BufferedImage rotateRight(BufferedImage img) {
        BufferedImage rotatedImage = new BufferedImage(img.getHeight(), img.getWidth(), img.getType());
        for (int x = 0; x < rotatedImage.getWidth(); x++) {
            for (int y = 0; y < rotatedImage.getHeight(); y++) {
                rotatedImage.setRGB(x, y, img.getRGB(y, (rotatedImage.getWidth() - 1) - x));
            }

        }
        return rotatedImage;

    }

    public BufferedImage rotateLeft(BufferedImage img) {
        BufferedImage rotatedImage = new BufferedImage(img.getHeight(), img.getWidth(), img.getType());
        for (int x = 0; x < rotatedImage.getWidth(); x++) {
            for (int y = 0; y < rotatedImage.getHeight(); y++) {
                rotatedImage.setRGB(x, y, img.getRGB((rotatedImage.getHeight() - 1) - y, x));
            }
        }
        return rotatedImage;
    }

    @Override
    public Image transformImage(Image image) {
        BufferedImage decodedImage = UtilBase64Image.decoder(image.getData());
        String a = image.getTransformation();
        BufferedImage transformedImage = null;
        if (a.equals("rotateRight")) {
            transformedImage = rotateRight(decodedImage);
        }
        String encodedImage = UtilBase64Image.encoder(transformedImage);
        image.setData(encodedImage);
        return image;
    }

    public void saveImage(BufferedImage image) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", bos);
            byte[] data = bos.toByteArray();
            Path path = Paths.get(servletContext.getRealPath("uploads") + "pic.jpg");
            System.out.println(servletContext.getRealPath("uploads") + "pic.jpg");
            Files.write(path, data);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
