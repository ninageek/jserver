package com.ninageek.controller;

import com.ninageek.dto.StringCheckerRequestDto;
import com.ninageek.dto.StringCheckerResponseDto;
import com.ninageek.service.StringCheckerService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public StringCheckerResponseDto stringChecker(@RequestBody StringCheckerRequestDto requestDto) {
        boolean permutationCheck = stringCheckerService.permutationCheck(requestDto.getFirstString(), requestDto.getSecondString());
        boolean traverseCheck = false;
        if (permutationCheck)
            traverseCheck = stringCheckerService.traverseCheck(requestDto.getFirstString(), requestDto.getSecondString());
        StringCheckerResponseDto responseDto = new StringCheckerResponseDto();
        responseDto.setFirstStringPalindrome(stringCheckerService.isPalindrome(requestDto.getFirstString()));
        responseDto.setSecondStringPalindrome(stringCheckerService.isPalindrome(requestDto.getSecondString()));
        responseDto.setPermutationCheck(permutationCheck);
        responseDto.setTraverseCheck(traverseCheck);
        stringCheckerService.validate(requestDto,responseDto );


        return responseDto;
    }
}
