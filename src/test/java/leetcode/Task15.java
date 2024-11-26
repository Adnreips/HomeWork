package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task15 {
    @Test
    void test() {
        Assertions.assertEquals(List.of(List.of(-1, -1, 2), List.of(-1, 0, 1)), threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        Assertions.assertEquals(List.of(List.of(0, 0, 0)), threeSum(new int[]{0, 0, 0, 0}));
//        [[-5,1,4],[-4,0,4],[-4,1,3],[-2,-2,4],[-2,1,1],[0,0,0]]
//        Assertions.assertEquals(List.of(List.of(-5, 1, 4), List.of(-4, 0, 4), List.of(-4, 1, 3), List.of(-2, -2, 4), List.of(-2, 1, 1), List.of(0, 0, 0)),)
        Assertions.assertEquals(List.of(List.of(-1,-1,2), List.of(-1,0,1)), threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);  // Sort the array first
        List<List<Integer>> l = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the main element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int res = 0 - nums[i];
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[start] + nums[end];

                if (sum == res) {
                    l.add(Arrays.asList(nums[i], nums[start], nums[end]));

                    // Skip duplicates for start and end
                    while (start < end && nums[start] == nums[start + 1]) start++;
                    while (start < end && nums[end] == nums[end - 1]) end--;

                    start++;
                    end--;
                } else if (sum > res) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return l;
    }

//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> resultList = new ArrayList<>();
//        if (nums == null || nums.length < 3) return List.of();
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                for (int k = 0; k < nums.length; k++) {
//                    int num1 = nums[i];
//                    int num2 = nums[j];
//                    int num3 = nums[k];
////                i != j, i != k, и j != k, и nums[i] + nums[j] + nums[k] == 0
//                    if (i != j && i != k && j != k && num1 + num2 + num3 == 0) {
//                        if (checkArray(num1, num2, num3, resultList)) continue;
//                        resultList.add(List.of(num1, num2, num3));
//                    }
//                }
//            }
//        }
//        return resultList;
//
//    }

    private boolean checkArray(int num1, int num2, int num3, List<List<Integer>> resultList) {
        boolean flag = false;
        for (List<Integer> list : resultList) {
            List<Integer> doNotCheck = new ArrayList<>();
            if (check(num1, list, doNotCheck) && check(num2, list, doNotCheck) && check(num3, list, doNotCheck)) {
                return true;
            }
        }
        return flag;
    }

    private boolean check(int num, List<Integer> list, List<Integer> doNotCheck) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == num && !doNotCheck.contains(i)) {
                doNotCheck.add(i);
                return true;
            }
        }
        return false;
    }
}
