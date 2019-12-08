package com.example.study.model.dynamic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicOperation {

//    public static boolean isMatch(String s, String p) {
//        if (p.length() == 0) {
//            return s.length() == 0;
//        }
//        boolean firstMatch = (s.length() != 0) && ((s.charAt(0) == p.charAt(0)) || (p.charAt(0) == '.'));
//        if (p.length() > 1 && p.charAt(1) == '*') {
//            return isMatch(s, p.substring(2)) || (firstMatch &&isMatch(s.substring(1), p));
//        }
//        return firstMatch && isMatch(s.substring(1), p.substring(1));
//    }
//
//    public static boolean isMatch2(String text, String pattern) {
//        if (pattern.isEmpty()) return text.isEmpty();
//        boolean first_match = (!text.isEmpty() &&
//                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
//
//        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
//            return (isMatch(text, pattern.substring(2)) ||
//                    (first_match && isMatch(text.substring(1), pattern)));
//        } else {
//            return first_match && isMatch(text.substring(1), pattern.substring(1));
//        }
//
//    }

    public static boolean isMatch3(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        boolean firstMatch = s.length() != 0 && ((s.charAt(0) == p.charAt(0)) || (p.charAt(0) == '.'));
        if (p.length() > 1 && p.charAt(1) == '*') {
            return isMatch3(s, p.substring(2)) || (firstMatch &&isMatch3(s.substring(1), p));
        }
        return firstMatch && isMatch3(s.substring(1), p.substring(1));
    }

    public static int minPathSum(int[][] grid) {
        int n = grid[0].length;
        int m = grid.length;
        int[][] result = new int[m][n];
        for (int i = 0; i< m;i++) {
            for (int j=0; j< n;j++) {
                result[i][j] = -1;
            }

        }
        return minPathSum(grid, m, n, result);
//        return Math.min(minPathSum(grid[m-1][]), minPathSum(grid[m-1][n-1])) + grid[m-1][n-1];
    }

    public static int coinChange(int[] coins, int amount) {
        int minmum = mimum(coins);
        Map<Integer, Integer> map = new HashMap<>(amount);
        return coinChange(coins, amount, minmum, map);
    }

    private static int mimum(int[] array) {
        if (array.length == 0) {
           return 0;
        }
        int mimum = Integer.MAX_VALUE;
        for (int i=0;i<array.length;i++) {
            if (mimum > array[i]) {
                mimum = array[i];
            }
        }
        return mimum;
    }


    private static int coinChange(int[] coins, int amount, int minmum, Map<Integer, Integer> map) {
        if (amount == 0) {
            return 0;
        }
        if (amount < minmum || amount < 0 || coins.length == 0) {
            return -1;
        }
        if (amount == minmum) {
            return 1;
        }
        if (map.containsKey(amount)) {
            return map.get(amount);
        }
        int result = -1;
        for (int i=0;i< coins.length;i++) {
            int tmp = coinChange(coins, amount-coins[i], minmum, map);
            if (-1 != tmp) {
                if (result == -1 || tmp < result) {
                    result = tmp+1;
                }
            }
        }
        map.put(amount, result);
        return result;
    }

    private static int minPathSum(int[][] grid, int row, int column, int[][] result) {
        if (row == 0 && column == 0) {
            return 0;
        }
        if (result[row-1][column-1] > -1) {
            return result[row-1][column-1];
        }
        if (row == 1 && column == 1) {
            result[row-1][column-1] = grid[row-1][column-1];
            return result[row-1][column-1];
        }
        if (row == 1 && column > 1) {
            result[row-1][column-1] = minPathSum(grid, row, column-1, result) + grid[row-1][column-1];
            return result[row-1][column-1];
        }
        if (column == 1 && row > 1) {
            result[row-1][column-1] = minPathSum(grid, row-1, column, result) + grid[row-1][column-1];
            return result[row-1][column-1];
        }
        result[row-1][column-1] =  Math.min(minPathSum(grid, row, column-1, result), minPathSum(grid, row-1, column, result)) + grid[row-1][column-1];
        return result[row-1][column-1];

    }

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfix = 0;
        for (int i=0; i< prices.length;i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            if (prices[i] - minPrice > maxProfix) {
                maxProfix = prices[i] - minPrice;
            }
        }
        return maxProfix;

    }

    public static int maxProduct(int[] nums) {
        int imax = 1;
        int imin = 1;
        int max = Integer.MIN_VALUE;
        for (int i=0;i<nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);
            max = Math.max(imax,max);

        }
        return max;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] result = new int[triangle.size()+1];
        for (int i = triangle.size()-1; i >= 0; i--) {
            for (int j = 0; j<= i; j++) {
                result[j] = Math.min(result[j], result[j+1]) + triangle.get(i).get(j);
            }
        }
        return result[0];
    }

    private int minimumTotal(List<List<Integer>> triangle, int row, int column) {
        if (row == 1) {
            return triangle.get(row-1).get(column-1);
        }
        if (column == 1) {
            return triangle.get(row-1).get(column-1) + minimumTotal(triangle, row-1, column);
        }
        if (column == triangle.get(row-1).size()) {
           return  triangle.get(row-1).get(column-1) + minimumTotal(triangle, row-1, column-1);
        }
        return triangle.get(row-1).get(column-1) + Math.min(minimumTotal(triangle, row-1, column -1), minimumTotal(triangle, row-1, column));


    }


    public static void main(String[] args) {
//        String s = "aa";
//        String p = "a" ;
//        String p1 = "a*" ;
//        String s1 = "ab";
//        String p3 = ".*";
//        String s4 = "aab";
//        String p4 = "c*a*b";
//        String s5 = "mississippi";
//        String p5 = "mis*is*p*.";
//        System.out.println(isMatch(s, p));
//        System.out.println(isMatch(s,p1));
//        System.out.println(isMatch(s1, p3));
//        System.out.println(isMatch(s4, p4));
//        System.out.println(isMatch(s5, p5));
//        System.out.println(isMatch("ab", ".*c"));
//        System.out.println(isMatch2("ab", ".*c"));
//        System.out.println(isMatch("b", ".*c"));
//        System.out.println(isMatch3("b", ".*c"));
//        System.out.println(isMatch3("ab", ".*c"));
//        System.out.println(isMatch3("b", ".*c"));
//        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
//        int n = grid[0].length;
//        int m = grid.length;
//        System.out.println(minPathSum(grid));
//        System.out.println(n);
//        int[] coins = {1, 2, 5};
//        System.out.println(coinChange(coins, 11));
//        int[] coinss = {2};
//        System.out.println(coinChange(coinss, 3));
//        int[] prices = {7,1,5,3,6,4};
//        System.out.println(maxProfit(prices));
//        int[] prices1 = {7,6,4,3,1};
//        System.out.println(maxProfit(prices1));
//        int[] nums = {2,3,-2,4};
//        int[] nums1 = {-2,0,-1};
//        System.out.println(maxProduct(nums));
//        System.out.println(maxProduct(nums1));


    }
}
