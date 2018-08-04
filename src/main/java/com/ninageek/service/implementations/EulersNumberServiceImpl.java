package com.ninageek.service.implementations;

import com.ninageek.service.EulersNumberService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

@Service
public class EulersNumberServiceImpl implements EulersNumberService {
    @Override
    public String computeEulersNumber(int n) {
        BigDecimal e = new BigDecimal(0.0);
        for (int i = 0; i < n; i++) {
            BigDecimal temp = new BigDecimal(1.0);
            BigDecimal temp2 = new BigDecimal(factorial(i));
            temp2 = temp.divide(temp2, n, RoundingMode.UP);

            e = e.add(temp2);
        }
        return e.toString();
    }

    private BigInteger factorial(int x) {
        BigInteger temp = new BigInteger("1");
        for (int i = 1; i <= x; i++)
            temp = temp.multiply(new BigInteger("" + i));
        return temp;
    }
}
