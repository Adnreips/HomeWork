package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task14 {

    @Test
    void test(){
        Assertions.assertEquals("fl", longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();

        int min = minLength(strs);
        for (int i = 0; i < min; i++) {
            char prevValue = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) != prevValue) {
                    return result.toString();
                }
            }
            result.append(prevValue);

        }

        return result.toString();
    }

    private int minLength(String[] strs) {
        int min = strs[0].length();
        for (String str : strs) {
            if (str != null && str.length() < min) min = str.length();
        }
        return min;
    }
}
