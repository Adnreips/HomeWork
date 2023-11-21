package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Task {
    public static void main(String[] args) {
//        nums = [2,7,11,15], target = 9
        int[] array1 = {3, 2, 4};

        int[] ints = twoSum(array1, 6);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> prevNumbers = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(prevNumbers.containsKey(complement)){
                int[] twoSumNumbers = {prevNumbers.get(complement), i};
                return twoSumNumbers;
            }
            prevNumbers.put(nums[i], i);
        }
        throw new IllegalArgumentException("No solution found");
    }

}
