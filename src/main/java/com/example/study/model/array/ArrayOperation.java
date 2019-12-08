package com.example.study.model.array;

import java.util.*;

public class ArrayOperation {

    public static int[] sortArrayByParity(int[] A) {
        int j = A.length-1;
        for (int i = 0; i < j; i++) {
            if (A[i]%2 == 0) {
                continue;
            }
            while (A[j]%2 != 0 && j > i){
                j--;
            }
            if (i >= j) {
                return A;
            }
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
            j--;
        }
        return A;
    }

    public static int[] sortArrayByParityII(int[] A) {
        int i = 0;
        int j = 1;
        for (;i<=A.length-1;i=i+2) {
            if (indexAndValue(i, A[i])) {
                continue;
            }
            while (j <= A.length -1 && indexAndValue(j, A[j])) {
                j=j+2;
            }
            if (j > A.length-1) {
              return A;
            }
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
            j= j+2;
        }
        return A;
    }

    public static int peakIndexInMountainArray(int[] A) {
//        if (A[0] > A[1]) {
//            return 0;
//        }
//        if (A[A.length-2] < A[]) {
//
//        }
        for (int i = 1; i < A.length -1; i++) {
            if (A[i] > A[i-1] && A[i] > A[i+1]) {
                return i;
            }
        }
        return -1;
    }

//    public List<List<String>> accountsMerge(List<List<String>> accounts) {
//    }


//    public static int search(int[] nums, int target) {
//        return search(nums, target, 0, nums.length-1);
//    }
//
//    public static int search(int[] nums, int target, int begin, int end) {
//
//        if (begin == end) {
//            if (target == nums[begin]) {
//                return begin;
//            }
//            return -1;
//        }
//        int mid = (begin+end)/2;
//        if (nums[mid] > nums[begin]) {
//            if (nums[mid] >= target & target > nums[begin]) {
//                return search(nums, target, begin, mid);
//            } else {
//                return search(nums, target, mid, end);
//            }
//        } else {
//            if (mid == end && nums[end] == target) {
//               return end;
//            }
//            if (mid == end && nums[end] != target) {
//                return -1;
//            }
//            return search(nums, target, mid, end);
//        }
//    }

    private static boolean indexAndValue(int i, int value){
        return (i%2== 0 && value %2 == 0) || i%2 ==1 && value %2 == 1;
    }

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public static List<Integer> majorityElement2(int[] nums) {
        Map<Integer, Integer> elementTimesMap = new HashMap<>();
        for (int i=0; i< nums.length; i++) {
            if(elementTimesMap.containsKey(nums[i])) {
                elementTimesMap.put(nums[i], elementTimesMap.get(nums[i]) + 1);
                continue;
            }
            elementTimesMap.put(nums[i], 1);
        }
        List<Integer> result = new ArrayList<>();
        for (int num : elementTimesMap.keySet()) {
            if (elementTimesMap.get(num) > nums.length/3) {
                result.add(num);
            }
        }
        return result;
    }

    public static int firstMissingPositive(int[] nums) {
        Map<Integer, Integer> numsMap= new HashMap<>();
        for (int i = 0; i < nums.length;i++) {
            if (!numsMap.keySet().contains(nums[i])) {
                numsMap.put(nums[i], 0);
            }
        }
        int result = 1;
        for (int i = 1; i<= nums.length+1; i++) {
            if (!numsMap.containsKey(i)) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static int[] sortedSquares(int[] A) {
        int minusPoint = -1;
        int plusPoint = -1;
        int[] result = new int[A.length];
        if (A[0] >= 0) {
            for (int i=0;i<A.length;i++) {
                result[i] = A[i]*A[i];
            }
            return result;
        }
        if (A[A.length-1] <0) {
            for (int j=A.length-1;j >=0;j--) {
                result[j] = A[j]*A[j];
            }
            return result;
        }
        for (int i =1; i<A.length;i++) {
            if (A[i-1] < 0 && A[i] >=0 ) {
                minusPoint = i-1;
                plusPoint = i;
            }
        }
        int i=0;
        while (i<A.length) {
            if (plusPoint >= A.length || ( (minusPoint>=0) && A[plusPoint] + A[minusPoint] >= 0)) {
                result[i] = A[minusPoint]*A[minusPoint];
                minusPoint--;
                i++;
                continue;
            }
            if (minusPoint <0 ||  (plusPoint < A.length &&A[plusPoint] + A[minusPoint] < 0)) {
                result[i] = A[plusPoint]*A[plusPoint];
                plusPoint++;
                i++;
                continue;
            }
        }
        return result;


    }

//    public static int search(int[] nums, int target) {
//        return search(nums, 0, nums.length-1, target);
//    }
//
//    public static int search(int[] nums, int beginIndex, int endIndex, int target) {
//        if (nums.length==0) {
//            return -1;
//        }
//        if (nums[beginIndex] == target) {
//            return beginIndex;
//        }
//        if (nums[endIndex] == target) {
//            return endIndex;
//        }
//        if (beginIndex == endIndex) {
//            if (nums[beginIndex] == target){
//                return beginIndex;
//            } else {
//                return -1;
//            }
//        }
//        int mid = (endIndex-beginIndex)/2 + beginIndex;
//        if (nums[mid] == target) {
//            return mid;
//        }
//        if (nums[mid] > nums[beginIndex]) {
//            if (nums[mid] > target && nums[beginIndex] < target) {
//                return search(nums, beginIndex, mid, target);
//            }
//            return search(nums, mid, endIndex, target);
//        } else {
//            if (target > nums[mid] && target < nums[beginIndex]) {
//                return search(nums, mid, endIndex, target);
//            }
//            return search(nums, beginIndex, mid, target);
//
//        }
//
//    }

    public static boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        return search(nums, target, 0, nums.length-1);
    }

    public static boolean search(int[] nums, int target , int beginIndex, int endIndex) {
        if (nums[beginIndex] == target) {
            return true;
        }
        if (nums[endIndex] == target) {
            return true;
        }
        if (beginIndex == endIndex && nums[beginIndex] != target) {
            return false;
        }
        if (endIndex < beginIndex) {
            return false;
        }
        int mid = (endIndex-beginIndex)/2+ beginIndex;
        if (mid == beginIndex || mid == endIndex) {
            return false;
        }
        if (nums[mid] == target) {
            return true;
        }
        if (nums[mid] > nums[beginIndex]) {
            if (target > nums[beginIndex] && target < nums[mid]) {
                return search(nums, target, beginIndex, mid);
            }
            return search(nums, target, mid, endIndex);
        } else if (nums[mid] < nums[beginIndex]){
            if (target > nums[mid] && target < nums[endIndex]) {
                return search(nums, target, mid, endIndex);
            }
            return search(nums, target, beginIndex, mid);
        } else {
            if (nums[endIndex] == nums[mid]) {
                return search(nums, target, beginIndex, mid) || search(nums, target, mid, endIndex);
            }
            return search(nums, target, mid, endIndex);
        }
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if (n==0) {
            return false;
        }
        if (target < matrix[0][0]) {
            return false;
        }
        int column = m-1;
        for (int i = 1; i< m;i++) {
            if (target >= matrix[i-1][0] && target < matrix[i][0]) {
                column = i-1;
            }
        }
        for (int j=0;j<n;j++) {
            if (matrix[column][j] == target) {
                return true;
            }

        }
        return false;

    }

    public static boolean equationsPossible(String[] equations) {
        ArrayList<Integer>[] graph = new ArrayList[26];
        for (int t =0;t<26;t++) {
            graph[t] = new ArrayList<>();
        }
        for (int i=0; i<equations.length;i++) {
            char[] chars = equations[i].toCharArray();
            if (chars[1] == '=') {
                int x = chars[0] - 'a';
                int y = chars[3] - 'a';
                graph[x].add(y);
                graph[y].add(x);

            }
        }
        int[] color = new int[26];
        int t = 0;
        for (int j=0;j<26;j++) {
            if (color[j] == 0) {
                t++;
                Stack<Integer> stack = new Stack<>();
                stack.push(j);
                while (!stack.isEmpty()) {
                    int value = stack.pop();
                    if (color[value] == 0 && graph[value].size() > 0) {
                        color[value] = t;
                    }
                    for (Integer element:
                         graph[value]) {
                        if (color[element] == 0 ) {
                            color[element] = t;
                            stack.push(element);
                        }

                    }
                }

            }
        }
        for (String equation : equations) {
            char[] chars = equation.toCharArray();
            if (chars[1] == '!') {
                if (chars[0]-'a' == chars[3]-'a' || color[chars[0]-'a'] != 0 && color[chars[0]-'a'] == color[chars[3]-'a']) {
                    return false;
                }
            }

        }
        return true;
    }

    public static int findCircleNum(int[][] M) {
        int N = M.length;
        if (N == 0) {
            return 0;
        }
        int[] circleColor = new int[N];
        int t =0;
        for(int i=0;i<N;i++) {
            Stack<Integer> stack = new Stack<>();
            t++;
            stack.push(i);
            while (!stack.isEmpty()) {
                int value = stack.pop();
                for (int j=0;j<N;j++) {
                    if (circleColor[j] != 0 || M[value][j] == 0) {
                        continue;
                    }
                    if (M[value][j] == 1 && circleColor[j] == 0) {
                        circleColor[j] = t;
                        if (value != j) {
                            stack.push(j);
                        }

                    }
                }
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i =0; i< N;i++) {
            if (circleColor[i] > 0) {
                map.put(circleColor[i], 1);
            }
        }
        return map.size();

    }

//    private void setCharToSet(List<Set<Integer>> unEqualSetList, char[] chars) {
//        if (unEqualSetList.size() == 0) {
//            Set<Integer> oldSetList = new HashSet<>();
//            oldSetList.add(chars[0] - 'a');
//            oldSetList.add(chars[3] - 'a');
//            unEqualSetList.add(oldSetList);
//        }
//        for (int j = 0; j < unEqualSetList.size() - 1; j++) {
//            if (unEqualSetList.get(j).contains(chars[0] - 'a') || unEqualSetList.get(j).contains(chars[3] - 'a')) {
//                Set<Integer> oldSetList = unEqualSetList.get(j);
//                oldSetList.add(chars[0] - 'a');
//                oldSetList.add(chars[3] - 'a');
//                continue;
//            } else {
//                Set<Integer> oldSetList = new HashSet<>();
//                oldSetList.add(chars[0] - 'a');
//                oldSetList.add(chars[3] - 'a');
//                unEqualSetList.add(oldSetList);
//                continue;
//            }
//
//        }
//    }


    public static void main(String[] args) {
//        int[] A = new int[1];
//        A[0] = 1;
//        System.out.println(Arrays.toString(sortArrayByParity(A)));

//        int[] B = new int[2];
//        B[0] = 1;
//        B[1] = 2;
//        System.out.println(Arrays.toString(sortArrayByParityII(B)));
//
//        int[] C = new int[2];
//        C[0] = 2;
//        C[1] = 1;
//        System.out.println(Arrays.toString(sortArrayByParityII(C)));
//
//        int[] D = new int[4];
//        D[0] = 2;
//        D[1] = 1;
//        D[2] = 3;
//        D[3] = 4;
//        System.out.println(Arrays.toString(sortArrayByParityII(D)));

//        int[] E = new int[4];
//        E[0] = 1;
//        E[1] = 1;
//        E[2] = 3;
//        E[3] = 1;
//        E[4] = 1;

//        E[5] = 1;
//        E[6] = 2;
//        E[7] = 2;
//        int[][] matrix = {{1,1,0}, {1,1,0},{0,0,1}};
//        int[][] matrix1 = {{1,1,0}, {1,1,1},{0,1,1}};
//        int[][] matrix2 = {{1,0,0}, {0,1,0},{0,0,1}};
//        System.out.println(findCircleNum(matrix));
//        System.out.println(findCircleNum(matrix1));
//        System.out.println(findCircleNum(matrix2));
        String[] equations = {"c==c","b==d","x!=z"};
        System.out.println(equationsPossible(equations));
    }
}
