package com.example.study.model.stack;

import java.util.Stack;

public class StackOperation {

    public static boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        char[] chars = s.toCharArray();
        Stack stack = new Stack();
        for (char element : chars) {
            matchAndPop(stack, element);
        }
        return stack.size() == 0;

    }

    public static int longestValidParentheses(String s) {

        if (s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();

        int longestValidSubStr = 0;
        Stack stack = new Stack();
        for (int i= 0;i< chars.length; i++) {
            if (stack.size() % 2 == 0 && i != chars.length-1) {
                stack.push(chars[i]);
                continue;
            }
            if (stack.size() %2  != 0) {
                Object highElement = stack.peek();
                if (match(highElement, chars[i])) {
                    stack.push(chars[i]);
                } else {
                    int currentSize = stack.size() -1;
                    longestValidSubStr = currentSize > longestValidSubStr ? currentSize : longestValidSubStr;
                    stack = new Stack();
                    stack.push(chars[i]);
                }
            }
        }

        return (stack.size() %2 == 0 && stack.size() > longestValidSubStr) ? stack.size() : longestValidSubStr;
    }

//    private boolean matchAndPopAndSum(Stack stack, char element) {
//
//    }

//    private static int iteratorLongest(char[] chars) {
//        if (chars.length == 0 || chars.length == 1) {
//            return 0;
//        }
//        if (match(chars[0], chars[1])) {
//            char[] newChars = new char[chars.length-2];
//            for (int i=0; i< newChars.length; i++) {
//                newChars[i] = chars[i+2];
//            }
//            return 2 + iteratorLongest(newChars);
//        } else {
//            char[] newChars = new char[chars.length-1];
//            for (int i=0; i< newChars.length; i++) {
//                newChars[i] = chars[i+1];
//            }
//            return iteratorLongest(newChars);
//        }
//
//    }

    public static void matchAndPop(Stack stack, char element) {
        if (stack.size() == 0) {
            stack.push(element);
            return;
        }
        Object highest = stack.peek();
        if (match(highest, element)) {
            stack.pop();
            return;
        } else {
            stack.push(element);
        }
    }

    public static int evalRPN(String[] tokens) {
        if (tokens.length <= 0) {
            return 0;
        }
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        Stack<String> strings = new Stack<>();
        for (String s : tokens) {
            if (!isOperateSymbol(s)) {
                strings.push(s);
            } else {
                String top = strings.pop();
                String second = strings.pop();
                String tmpResult = "0";
                if ("+".equals(s)) {
                    tmpResult = String.valueOf(Integer.parseInt(second)+Integer.parseInt(top));
                }
                if ("-".equals(s)) {
                    tmpResult = String.valueOf(Integer.parseInt(second)-Integer.parseInt(top));
                }
                if ("*".equals(s)) {
                    tmpResult = String.valueOf(Integer.parseInt(second)*Integer.parseInt(top));
                }
                if ("/".equals(s)) {
                    tmpResult = String.valueOf(Integer.parseInt(second)/Integer.parseInt(top));
                }

                strings.push(tmpResult);
            }
        }
        return Integer.parseInt(strings.peek());
    }

    private static boolean isOperateSymbol(String s) {
        if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)) {
            return true;
        }
        return false;
    }

    public static String decodeString(String s) {
        char[] chars = s.toCharArray();
        Stack stack = new Stack();
        for (int i=0; i< chars.length; i++) {
            if (chars[i] == ']') {
                String subStr = "";
                while ((char)stack.peek() != '[') {
                    subStr = stack.pop() + subStr;
                }
                stack.pop();
                String kStr = "";
                while (stack.size() != 0 && isNumber((char)stack.peek())) {
                    kStr = stack.pop() + kStr;
                }
                int k = Integer.parseInt(kStr);
                char[] decodeStringArr = decodeString(k, subStr);
                for (int j=0;j< decodeStringArr.length;j++) {
                    stack.push(decodeStringArr[j]);
                }
            } else {
                stack.push(chars[i]);
                continue;
            }

        }
        String result = "";
        while (stack.size() != 0) {
            result = stack.pop()  + result;
        }
        return result;
    }

    private static boolean isNumber(char a) {
        return a  >= '0' && a <= '9';
    }

    private static char[] decodeString(int k, String subStr) {
        String decodeString = "";
        for(int i=0; i<k; i++) {
            decodeString += subStr;
        }
        return decodeString.toCharArray();
    }


//
    private static boolean match(Object begin, Object end) {
        if (begin.equals('(') && end.equals(')')) {
            return true;
        }
        if (begin.equals('(') && end.equals('(')) {
            return true;
        }
        if (begin.equals(')') && end.equals(')')) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        String[] tokens = {"2", "1", "+", "3", "*"};
//        String[] tokens1 = {"4", "13", "5", "/", "+"};
//        String[] tokens2= {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
//        System.out.println(evalRPN(tokens));
//        System.out.println(evalRPN(tokens1));
//        System.out.println(evalRPN(tokens2));
//        System.out.println(longestValidParentheses(")("));
//        System.out.println(longestValidParentheses("()(())"));
          String s = "3[a]2[bc]";
          String s1 = "3[a2[c]]";
          String s2 = "2[abc]3[cd]ef";
          String s3 = "100[leetcode]";
        System.out.println(decodeString(s));
        System.out.println(decodeString(s1));
        System.out.println(decodeString(s2));
        System.out.println(decodeString(s3));
    }


}
