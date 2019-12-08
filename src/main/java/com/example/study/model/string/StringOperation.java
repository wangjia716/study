package com.example.study.model.string;

import java.util.ArrayList;
import java.util.List;

public class StringOperation {

    public static String reverseWords(String s) {
        if (s.length() == 0) {
            return s;
        }
        List<String> subString = new ArrayList<>();
        String sub = "";
        for (int i=0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' ) {
                if (sub.length() != 0) {
                    subString.add(sub);
                    sub = "";
                    continue;
                }
                continue;
            } else {
                sub += s.charAt(i);
            }
        }
        if (sub.length() != 0) {
            subString.add(sub);
        }
        if (subString.size() == 0) {
            return "";
        }
        String result = "";
        for (int j= subString.size()-1;j>=0; j--) {
            if (j == 0) {
                result += subString.get(j) ;
            } else {
                result += subString.get(j) + ' ';
            }

        }
        return result;
    }

    public static int myAtoi(String str) {
        if (str.length() == 0) {
            return 0;
        }
        /**
         * 跳过空字符串
         */
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        if (i == str.length()) {
            return 0;
        }
        int flag = 1;
        char a = str.charAt(i);
        if (a == '-') {
            flag = -1;
            i++;
        }
        if (a == '+') {
            i++;
        }
        if (a >='0' && a <= '9') {
            flag = 1;
        }
        int result = 0;
        for (int j=i;j<str.length();j++) {
            if (str.charAt(j) < '0' || str.charAt(j) > '9') {
                break;
            }
            result = 10*result + str.charAt(j)-'0';
            if (flag ==1 &&j+1 < str.length()&& str.charAt(j+1) >= '0' && str.charAt(j+1) <= '9' && result > Integer.MAX_VALUE/10) {
                return Integer.MAX_VALUE;
            }
            if (flag ==1 &&j+1 < str.length()&& str.charAt(j+1) >= '0' && str.charAt(j+1) <= '9' && result == Integer.MAX_VALUE/10&& str.charAt(j+1)- '0' > Integer.MAX_VALUE%10) {
                return Integer.MAX_VALUE;
            }

            if (flag ==-1 &&j+1 < str.length()&& str.charAt(j+1) >= '0' && str.charAt(j+1) <= '9' && -result < Integer.MIN_VALUE/10) {
                return Integer.MIN_VALUE;
            }
            if (flag ==-1 &&j+1 < str.length()&& str.charAt(j+1) >= '0' && str.charAt(j+1) <= '9' && -result == Integer.MIN_VALUE/10 && -(str.charAt(j+1)- '0') < Integer.MIN_VALUE%10) {
                return Integer.MIN_VALUE;
            }
        }
        return result*flag;

    }

    public String minWindow(String s, String t) {

    }

    private boolean isSign(char sig) {
        if (sig == '+' || sig == '-') {
            return true;
        }
        return false;
    }

    private boolean isNumber(char sub) {
        if (sub == '1' ||
                sub == '2' ||
                sub == '3' ||
                sub == '4' ||
                sub == '5' ||
                sub == '6' ||
                sub == '7' ||
                sub == '8' ||
                sub == '9' ||
                sub == '0') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "   -42";
        System.out.println(myAtoi(s));
//        System.out.println(reverseWords(s1));
//        System.out.println(reverseWords(s2));
    }
}
