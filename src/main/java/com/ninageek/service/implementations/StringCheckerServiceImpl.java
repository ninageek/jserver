package com.ninageek.service.implementations;

import com.ninageek.dto.StringCheckerRequestDto;
import com.ninageek.dto.StringCheckerResponseDto;
import com.ninageek.service.StringCheckerService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class StringCheckerServiceImpl implements StringCheckerService {
    @Override
    public boolean isPalindrome(String string) {
        char[] chars = string.toCharArray();
        int i1 = 0;
        int i2 = chars.length - 1;
        while (i2 > i1) {
            if (chars[i1] != chars[i2]) {
                return false;
            }
            ++i1;
            --i2;
        }
        return true;
    }


    @Override
    public boolean permutationCheck(String firstString, String secondString) {
        if (firstString.length() != secondString.length())
            return false;

        char[] a = firstString.toCharArray();
        char[] b = secondString.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }

    @Override
    public boolean traverseCheck(String firstString, String secondString) {

        if (firstString.length() != secondString.length())
            return false;
        else if (firstString.equals(secondString))
            return true;
        char[] a = firstString.toCharArray();
        char[] b = secondString.toCharArray();
        char[] c = new char[a.length];
        char[] d = new char[a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                c[j + 1] = a[j];
            }
            c[0] = a[a.length - 1];
            if (Arrays.equals(c, b)) {
                return true;
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                d[j] = a[j + 1];
            }
            d[a.length - 1] = a[0];
            if (Arrays.equals(d, b)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void validate(StringCheckerRequestDto requestDto, StringCheckerResponseDto responseDto) {
        if(requestDto.getFirstString().equals("")) responseDto.setFirstStringEmpty(true);
        if(requestDto.getSecondString().equals("")) responseDto.setSecondStringEmpty(true);
}}
