package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task12 {

    @Test
    void testIntToRoman() {
        Assertions.assertEquals("MMMDCCXLIX", intToRoman(3749));
    }
    public String intToRoman(int num) {
        String result = "";
        Pair[] arabianToRomanArray = new Pair[]{
                new Pair(1, "I"), new Pair(4, "IV"), new Pair(5, "V"), new Pair(9, "IX"),
                new Pair(10, "X"), new Pair(40, "XL"), new Pair(50, "L"), new Pair(90, "XC"),
                new Pair(100, "C"), new Pair(400, "CD"), new Pair(500, "D"), new Pair(900, "CM"),
                new Pair(1000, "M")
        };
        int N = num;
        int i = 12;
        while (N > 0)
        {
            while (arabianToRomanArray[i].arabian > N)
            {
                i--;
            }
            result += arabianToRomanArray[i].roman;
            N -= arabianToRomanArray[i].arabian;
        }
        return result;
    }

     static class Pair {
        private Integer arabian;
        private String roman;
         public Pair(Integer arabian, String roman) {
             this.arabian = arabian;
             this.roman = roman;
         }
     }
}
