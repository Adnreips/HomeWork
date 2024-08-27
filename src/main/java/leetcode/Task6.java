package leetcode;

import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task6 {
    public static void main(String[] args) {
        String input = "PAYPALISHIRING";
        String output = "PAHNAPLSIIGYIR";
//        String result = convert(input, 4);

        System.out.println(input.length());
    }
//    14 symbols, 3 rows, 7 columns
//    P   A   H   N
//    A P L S I I G
//    Y   I   R
    
//    4 rows, 7 columns
//    P     I    N
//    A   L S  I G
//    Y A   H R
//    P     I
    
//    5 rows, 5 columns
//    P      I    
//    A    H R   
//    Y   S  I
//    P L    N
//    A      G
    
    public static String convert(String input, int numRows) {
        List<StringBuilder> builderList = new ArrayList<>();
        for (int j = 0; j < numRows; j++) {
            StringBuilder builder = new StringBuilder();
            builderList.add(builder);
        }
        Arrays.asList(input.toCharArray());
        while ()
        
        
        
        for (int i = 0; i < input.length(); i++) {
            
        }
        
        //количество столбцов
        
        
        return null;
    }
}
