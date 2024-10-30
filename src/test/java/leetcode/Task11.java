package leetcode;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class Task11 {

    @Test
    void testMaxArea() {

        Assertions.assertEquals(1, maxArea(new int[]{1, 1}));

    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        for (int i = 0; i < height.length; i++) {
            if (right - left <= 0) return maxArea;
            maxArea = Math.max(maxArea, calculateArea(height, left, right));
            if (height[left] > height[right]) {
                --right;
            } else {
                ++left;
            }
        }
        return maxArea;
    }

    public int calculateArea(int[] height, int left, int right) {
        int h = Math.min(height[left], height[right]);
        return (right - left) * h;
    }
}
