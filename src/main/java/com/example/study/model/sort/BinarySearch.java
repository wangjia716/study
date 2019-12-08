package com.example.study.model.sort;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class BinarySearch {

    public static int lastIndex(int[] a, int n, int value){
        int low = 0;
        int high = n-1;
        int mid = -1;
        while (low <= high) {
            mid = low + (high - low)/2;
            if (a[mid] > value) {
                high = mid-1;
            }
            if (a[mid] < value) {
                low = mid+1;
            }
            if (a[mid] == value) {
                if ((mid == n-1) || (a[mid+1] != value) ) {
                    return mid;
                }
                low = mid+1;
            }
        }
//        if (a[mid] == value) {
//            return mid;
//        }
        return -1;
    }

    public static int firstGreater(int[] a, int n, int value){
        int low = 0;
        int high = n-1;
        while (low <= high) {
            int mid = low + ((high - low)>>1);
            if (a[mid] < value) {
                low = mid+1;
            }
            if (a[mid] == value) {
                if (a[mid+1] != value) {
                    return mid+1;
                } else {
                    low = mid+1;
                }
            }
            if (a[mid] > value) {
                if ((mid == n-1) || (a[mid-1] <= value) ) {
                    return mid;
                } else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }

    public static int lastNotGreater(int[] a, int n, int value){
        int low = 0;
        int high = n-1;
        while (low <= high) {
            int mid = low + ((high - low)>>1);
            if (a[mid] <= value) {
                if (a[mid+1] > value) {
                   return mid;
                }
                low = mid+1;
            }
            if (a[mid] > value) {
                high = mid-1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] a = new int[7];
//        a[0] = 1;
//        a[1] = 2;
//        a[2] = 4;
//        a[3] = 4;
//        a[4] = 5;
//        a[5] = 7;
//        a[6] = 8;
//        System.out.println(lastNotGreater(a, 2, 3));
//        int i = 0;
//        int len = 2;
//        System.out.println(1<len);
//        System.out.println(i + 1 < len);

        HashMap<Integer, Integer> m = new LinkedHashMap<>();
        m.put(3, 11);
        m.put(1, 12);
        m.put(5, 23);
        m.put(2, 22);



        m.put(3, 16);
        m.get(5);
        m.put(4, 15);
        m.put(6, 17);

        for (Map.Entry e : m.entrySet()) {
            System.out.println(e.getKey());
        }

    }

}
