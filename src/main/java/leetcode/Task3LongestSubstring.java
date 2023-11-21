package leetcode;

import java.util.*;

public class Task3LongestSubstring {
    public static void main(String[] args) {
        String input = "abcabcbb";
//        String input = "bbbbb";
//        String input = "pwwkew";
//        String input = " ";
//        String input = "au";
        System.out.println(findLongestSubstring(input));
        System.out.println(lengthOfLongestSubstring(input));
    }

    private static Integer findLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        if (charArray.length == 1) return 1;
        Set<Character> resultSet = new HashSet<>();
        Set<Character> carrierSet = new HashSet<>();
        for (int i = 0; i < charArray.length; i++) {
            if (resultSet.size() <= carrierSet.size()) {
                resultSet = carrierSet;
            }
            carrierSet = new TreeSet<>();
            carrierSet.add(charArray[i]);
            for (int j = i + 1; j < charArray.length; j++) {
                if (charArray[i] == charArray[j] || carrierSet.contains(charArray[j])) {
                    break;
                }
                carrierSet.add(charArray[j]);
            }
        }
        return resultSet.size();
    }
    public static  int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (!charMap.containsKey(s.charAt(right)) || charMap.get(s.charAt(right)) < left) {
                charMap.put(s.charAt(right), right);
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                left = charMap.get(s.charAt(right)) + 1;
                charMap.put(s.charAt(right), right);
            }
        }
        return maxLength;
    }
}
