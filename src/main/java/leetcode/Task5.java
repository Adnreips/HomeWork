package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Task5 {
    public static void main(String[] args) {
//        String s = "bb", s2 = "babad", s3 = "cbbd";
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
//        System.out.println(longestPalindrome(s));
//        System.out.println(longestPalindrome(s2));
//        System.out.println(longestPalindrome(s3));
        System.out.println(findAllPalindromesUsingCenter(s));
    }
    public static String findAllPalindromesUsingCenter(String input) {
        Set<String> palindromes = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            palindromes.addAll(findPalindromes(input, i, i + 1));
            palindromes.addAll(findPalindromes(input, i, i));
        }
        String result = "";
        for (String palindrome : palindromes) {
            if(palindrome.length()>result.length()){
                result = palindrome;
            }
        }
        return result;
    }
    private static Set<String> findPalindromes(String input, int low, int high) {
        Set<String> result = new HashSet<>();
        while (low >= 0 && high < input.length() && input.charAt(low) == input.charAt(high)) {
            result.add(input.substring(low, high + 1));
            low--;
            high++;
        }
        return result;
    }

//    public static String longestPalindrome(String s) {
//        s=s.toLowerCase();
//        String temp = new String();
//        String result = new String();
//        List<Character> characterList = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
//
//        for (int j = 0; j < characterList.size(); j++) {
//            temp = "";
//            for (int i = j+1; i < characterList.size(); i++) {
//                Character c = characterList.get(i);
//                temp = temp.concat(String.valueOf(c));
//                if (chechForPolyndrom(temp)) {
//                    if (temp.length() >= result.length()) {
//                        result = new String(temp);
//                    }
//                }
//            }
//        }
//        return result;
//    }
//
//    private static boolean chechForPolyndrom(String text) {
//        return text.replaceAll("\\W", "")
//                .equalsIgnoreCase(new StringBuilder(text.replaceAll("\\W", ""))
//                        .reverse().toString());
//    }
//    private static boolean chechForPolyndrom(char[] text) {
//        int i1 = 0;
//        int i2 = text.length - 1;
//        while (i2>i1){
//            if(text[i1]!=text[i2]){
//                return false;
//            }
//            ++i1;
//            --i2;
//        }
//        return true;
//    }
}
