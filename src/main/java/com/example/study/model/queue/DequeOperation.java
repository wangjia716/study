package com.example.study.model.queue;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

public class DequeOperation {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque deque = new ArrayDeque(k);
        if (nums.length < k || k==0||nums.length==0) {
            return new int[0];
        }
        int[] result = new int[nums.length-k+1];
        for (int i=0;i<=k-1;i++) {
            deque.addFirst(nums[i]);
        }
        for (int j=0;j<nums.length-k;j++) {
            int max = calculateMax(deque);
            result[j] = max;
            deque.addFirst(nums[j+k]);
            deque.removeLast();
        }
        result[nums.length-k] = calculateMax(deque);
        return result;
    }

    public static int climbStairs(int n) {
        if (n<=2) {
            return n;
        }
        Map<Integer, Integer> tmp = new HashMap<>();
        tmp.put(1, 1);
        tmp.put(2, 2);
        for (int i=3;i < n; i++) {
            if (tmp.containsKey(i)) {
                return tmp.get(i);
            }
            if (tmp.containsKey(i-1) && tmp.containsKey(i-2)) {
                int iResult = tmp.get(i-1) + tmp.get(i-2);
                tmp.put(i, iResult);
            }
        }
        return tmp.get(n-1) + tmp.get(n-2);
    }

    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x<=3) {
            return 1;
        }
        if (x < 8) {
            return 2;
        }
        int begin = 0;
        int end = x/2;
        int midlle = (begin+end)/2;
        while (!( x/midlle > midlle && x/(midlle+1) < (midlle+1))) {
            if (midlle == x/midlle) {
                return midlle;
            }
            if (x/midlle > midlle) {
                begin = midlle;
                midlle= (begin+end)/2;
            }
            if (midlle > x/midlle) {
                end = midlle;
                midlle= (begin+end)/2;

            }
        }
        return midlle;

    }

    public static void reverseString(char[] s) {
        int begin=0;
        int end = s.length-1;
        while (begin < end) {
            char tmp = s[begin];
            s[begin] = s[end];
            s[end] = tmp;
            begin++;
            end--;
        }
        return;
    }


    private static int calculateMax(Deque<Integer> deque) {
        Integer max = Integer.MIN_VALUE;
        Iterator<Integer> integerIterator = deque.iterator();
        while (integerIterator.hasNext()) {
            Integer num = integerIterator.next();
            max = num > max ? num : max;
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] nums = {1,3,-1,-3,5,3,6,7};
//        int[] result = maxSlidingWindow(nums, 3);
//        System.out.println(maxSlidingWindow(nums, 3));

//        Arrays.stream(result).forEach(i-> System.out.println(i));
//        ArrayDeque deque = new ArrayDeque();
//        Arrays.stream(nums).forEach(i -> {deque.push(i);});
//        System.out.println(calculateMax(deque));
//        System.out.println(mySqrt(2));
//        System.out.println(mySqrt(8));
//        System.out.println(mySqrt(4));
//        System.out.println(mySqrt(2147395599));
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        for (char c : s) {
            System.out.println(c);
        }
        char[] s1 = {'H','a','n','n','a','h'};
        reverseString(s1);
        for (char c : s1) {
            System.out.println(c);
        }
    }
}

