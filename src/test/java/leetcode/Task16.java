package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Task16 {
    @Test
    void test() {
        Assertions.assertEquals(2, threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        Assertions.assertEquals(3, threeSumClosest(new int[]{1,1,1,0}, 100));
        Assertions.assertEquals(2, threeSumClosest(new int[]{1,1,1,0}, -100));
        Assertions.assertEquals(0, threeSumClosest(new int[]{-4,2,2,3,3,3}, 0));
        Assertions.assertEquals(-2, threeSumClosest(new int[]{4,0,5,-5,3,3,0,-4,-5}, -2));
    }

    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            int left = i + 1;

            for (int j = left; j < nums.length; j++) {
                int right = nums.length - 1;
                while (j < right) {
                    int sum = nums[j] + nums[right] + nums[i];
                    int currentDistance = Math.abs(sum - target);
                    if(currentDistance < distance) {
                        result = sum;
                        distance = currentDistance;
                    }
                    right--;
                }
            }

        }
        return result;
    }
}
