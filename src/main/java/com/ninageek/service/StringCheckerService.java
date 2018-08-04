package com.ninageek.service;

import com.ninageek.dto.StringCheckerRequestDto;
import com.ninageek.dto.StringCheckerResponseDto;

public interface StringCheckerService {
    boolean isPalindrome(String string);
    boolean permutationCheck(String stringOne, String stringTwo);
    boolean traverseCheck(String stringOne, String stringTwo);
    void validate(StringCheckerRequestDto requestDto, StringCheckerResponseDto responseDto);
}
