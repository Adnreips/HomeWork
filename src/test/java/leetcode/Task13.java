package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task13 {

    @Test
    void testRomanToInt() {

        Assertions.assertEquals(35,romanToInt("XXXIV"));
    }

    public int romanToInt(String s) {
//        Map<String, Integer> romanToInteger = Map.ofEntries(
//                Map.entry("I", 1),
//                Map.entry("IV", 4),
//                Map.entry("V", 5),
//                Map.entry("IX", 9),
//                Map.entry("X", 10),
//                Map.entry("XL", 40),
//                Map.entry("L", 50),
//                Map.entry("XC", 90),
//                Map.entry("C", 100),
//                Map.entry("CD", 400),
//                Map.entry("D", 500),
//                Map.entry("CM", 900),
//                Map.entry("M", 1000)
//        );
//
//        Integer result = 0;
//        char[] chars = s.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            StringBuilder builder = new StringBuilder();
//            builder.append(chars[i]);
//            if (i + 1 < chars.length) {
//                String s2 = builder.toString() + chars[i + 1];
//                if (romanToInteger.containsKey(s2)) {
//                    result += romanToInteger.get(s2);
//                    i += 1;
//                    continue;
//                }
//            }
//                result += romanToInteger.get(builder.toString());
//        }
//        return result;
        int nums[] = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            switch (s.charAt(i)) {
                case 'M':
                    nums[i] = 1000;
                    break;
                case 'D':
                    nums[i] = 500;
                    break;
                case 'C':
                    nums[i] = 100;
                    break;
                case 'L':
                    nums[i] = 50;
                    break;
                case 'X' :
                    nums[i] = 10;
                    break;
                case 'V':
                    nums[i] = 5;
                    break;
                case 'I':
                    nums[i] = 1;
                    break;
            }
        }

        int sum = 0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] < nums[i+1])
                sum -= nums[i];
            else
                sum += nums[i];
        }

        return sum + nums[nums.length-1];
    }
}
