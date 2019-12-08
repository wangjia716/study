package com.example.study.model.Number;

import java.math.BigDecimal;

import static java.lang.Math.abs;

public class NumberOperation {

    public static Double sqrt(Double end) {
        Double begin = Double.valueOf(0);
        Double mid = end/2.000;
        while (abs(end - mid*mid) > 0.000001) {
            if (mid*mid < end) {
                begin = mid;
            } else if (mid*mid> end){
                end = mid;
            }
            mid = begin + (end - begin)/2.000;
        }
        return mid;

    }

    public static void main(String[] args) {
        Double num = Double.valueOf(3);
        System.out.println(sqrt(num));
    }
}
