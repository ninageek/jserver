package com.ninageek.service;

import com.ninageek.dto.Image;

import java.awt.image.BufferedImage;

public interface ImageService {
    BufferedImage testMask(BufferedImage img);
    BufferedImage rotateRight(BufferedImage img);
    BufferedImage rotateLeft(BufferedImage img);
    Image transformImage(Image image);
    void saveImage(BufferedImage image);
}
