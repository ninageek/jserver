package com.ninageek.dto;

public class StringCheckerRequestDto {
    private String firstString;
    private String secondString;

    public StringCheckerRequestDto() {
    }

    public StringCheckerRequestDto(String firstString, String secondString) {
        this.firstString = firstString;
        this.secondString = secondString;
    }

    public String getFirstString() {
        return firstString;
    }

    public String getSecondString() {
        return secondString;
    }

    public void setFirstString(String firstString) {
        this.firstString = firstString;
    }

    public void setSecondString(String secondString) {
        this.secondString = secondString;
    }
}
