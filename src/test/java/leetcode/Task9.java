package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


class Task9 {

    @Test
    void test() {
//        Assertions.assertFalse(isPalindrome(23));
//        Assertions.assertTrue(isPalindrome(232));
        Assertions.assertTrue(isMatch("aa", "a*"));
        Assertions.assertTrue(isMatch("aab", "c*a*b"));
        Assertions.assertFalse(isMatch("ab", ".*c"));
        Assertions.assertFalse(isMatch("aaa", "ab*a"));
    }
    public boolean isMatch(final String s, final String p) {
        return dfs(s, p, 0, 0, new Boolean[s.length()][p.length()]);
    }

    private boolean dfs(final String s, final String p, final int i, final int j, final Boolean[][] cache) {
        if(i >= s.length() && j >= p.length())
            return true;

        if(j >= p.length())
            return false;

        if(i < s.length() && cache[i][j] != null)
            return cache[i][j];

        final boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if(j + 1 < p.length() && p.charAt(j + 1) == '*') {
            final boolean r = dfs(s, p, i, j + 2, cache) || (match && dfs(s, p, i + 1, j, cache));

            if(i < s.length())
                cache[i][j] = r;

            return r;
        }

        if(match) {
            cache[i][j] = dfs(s, p, i + 1, j + 1, cache);

            return cache[i][j];
        }

        if(i < s.length())
            cache[i][j] = false;

        return false;
    }

    @Test
    void testArrays(){
        String s = "aaaa";
        String p = "bb";
        Boolean[][] booleans = new Boolean[s.length()][p.length()];
        for (int i = 0; i < booleans.length; i++) {
//            for (int j = 0; j < p.length(); j++) {
                System.out.println(Arrays.asList(booleans[i]));

//            }
        }

        System.out.println(Arrays.asList(booleans));
//        System.out.println(Arrays.asList(new Boolean[s.length()]));
    }

//    public boolean isMatch(String s, String p) {
//        int numberUsingPattern = 0;
//
//        for (char c : s.toCharArray()) {
//            char[] patternArray = p.toCharArray();
//            if (patternArray.length == numberUsingPattern) return false;
//            for (int number = numberUsingPattern; number < patternArray.length; number++) {
//                char p1 = patternArray[number];
//                if (c == p1 || isDotOreStar(p1)) {
//                    if (p1 == '*' && patternArray.length > number + 2 && patternArray[number + 1] == c) {
//                        numberUsingPattern = number + 2;
//                    } else {
//                        numberUsingPattern = number+1;
//                    }
//                    break;
//                } else {
//                    return false;
//                }
//            }
//        }
//        String substring = p.substring(numberUsingPattern);
//        return substring.length() == 0 || isStar(substring);
//    }

    private boolean isStar(String substring) {
        for (char c : substring.toCharArray()) {
            if (c == '*') {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isDotOreStar(char c) {
        return c == '.' || c == '*';
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        }
        int result = 0;
        int m = x;
        while (m > 0) {
            int i = m % 10;
            result = result * 10 + i;
            m = m / 10;
        }
        return x == result;
    }
}
