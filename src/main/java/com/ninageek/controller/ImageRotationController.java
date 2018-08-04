package com.ninageek.controller;

import com.ninageek.dto.Image;
import com.ninageek.service.ImageService;
import com.ninageek.utils.UtilBase64Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/api")
public class ImageRotationController {
    @Autowired
    ImageService imageService;

    @RequestMapping(value = "/image-transformation", method = RequestMethod.POST,
            consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
            produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public Image imageTransformation(@RequestBody Image image) {
        return imageService.transformImage(image);

    }
}