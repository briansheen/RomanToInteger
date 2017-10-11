package com.example;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String s = "MMMDLXXXVI";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        s = s.toUpperCase();
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        int sum = 0;
        for (int i = 0; i < s.length(); ++i) {
            if ((i + 1) < s.length()) {
                if (romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i + 1))) {
                    sum = sum + romanMap.get(s.charAt(i + 1)) - romanMap.get(s.charAt(i));
                    i++;
                } else {
                    sum = sum + romanMap.get(s.charAt(i));
                }
            } else {
                sum = sum + romanMap.get(s.charAt(i));
            }
        }
        return sum;
    }
}
