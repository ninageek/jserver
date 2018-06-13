package com.ninageek.controller;

import com.ninageek.dto.StringCheckerDto;
import com.ninageek.dto.StringCheckerResponseDto;
import com.ninageek.service.StringCheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class StringCheckerController {
    @Autowired
    StringCheckerService stringCheckerService;


    @RequestMapping(value = "/string-checker", method = RequestMethod.POST, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public StringCheckerResponseDto stringChecker(@RequestBody StringCheckerDto dto) {
        boolean isFirstStringPalindrome = stringCheckerService.isPalindrome(dto.getFirstString());
        boolean isSecondStringPalindrome = stringCheckerService.isPalindrome(dto.getSecondString());
        boolean permutationCheck = stringCheckerService.permutationCheck(dto.getFirstString(), dto.getSecondString());
        boolean traverseCheck = false;
        if (permutationCheck)
            traverseCheck = stringCheckerService.traverseCheck(dto.getFirstString(), dto.getSecondString());
        StringCheckerResponseDto stringCheckerResponseDto = new StringCheckerResponseDto();
        stringCheckerResponseDto.setFirstStringPalindrome(isFirstStringPalindrome);
        stringCheckerResponseDto.setSecondStringPalindrome(isSecondStringPalindrome);
        stringCheckerResponseDto.setPermutationCheck(permutationCheck);
        stringCheckerResponseDto.setTraverseCheck(traverseCheck);



        return stringCheckerResponseDto;
    }
}
