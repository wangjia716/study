package com.example.study.model.list;



import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int begin = 0;
        int end = nums.length -1;
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = begin+1; i< end-1; i++) {
            int twoSum = -nums[i];
            for (int j = begin; j < i;) {
                for (int k=i+1; k<=end;) {
                    if (nums[k] == twoSum - nums[j] ) {
                        List<Integer> result = new LinkedList<>();
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[k]);
                        resultList.add(result);
                        break;
                    }
                    while (k < end && nums[k++] == nums[k]) {
                        k++;
                    }
                }
                while (j<i && nums[j++] == nums[j]) {
                    j++;
                }
            }
            while (i < end-1 && nums[i++] == nums[i]) {
                i++;
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);
    }
}
