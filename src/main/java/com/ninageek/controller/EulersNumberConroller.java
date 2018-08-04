package com.ninageek.controller;

import com.ninageek.dto.EulersNumberRequestDto;
import com.ninageek.dto.EulersNumberResponseDto;
import com.ninageek.service.EulersNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EulersNumberConroller {
    @Autowired
    EulersNumberService eulersNumberService;

    @RequestMapping(value = "/eulers-number", method = RequestMethod.POST,
            consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
            produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public EulersNumberResponseDto stringChecker(@RequestBody EulersNumberRequestDto requestDto) {
        int n = requestDto.getN();
        String e = eulersNumberService.computeEulersNumber(n);
        EulersNumberResponseDto eulersNumberResponseDto = new EulersNumberResponseDto();
        eulersNumberResponseDto.setE(e);
        return eulersNumberResponseDto;
    }
}
