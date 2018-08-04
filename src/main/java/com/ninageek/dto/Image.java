package com.ninageek.dto;

public class Image {
    private String name;
    private String data;
    private String transformation;

    public Image() {
    }

    public Image(String name, String data, String transformation) {
        this.name = name;
        this.data = data;
        this.transformation=transformation;
    }

    public String getTransformation() {
        return transformation;
    }

    public void setTransformation(String transformation) {
        this.transformation = transformation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        String info = String.format("Image name = %s, data = %s", name, data);
        return info;
    }
}
