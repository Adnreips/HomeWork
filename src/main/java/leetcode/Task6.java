package leetcode;

import java.util.Arrays;

public class Task6 {
    public static void main(String[] args) {
//        String input = "ABC";
//        System.out.println(convert(input, 2));

        String input = "Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.";
//        String input = "PAYPALISHIRING";
//        String input = "AA,";
        System.out.println(convert(input, 2));
//        System.out.println(Character.isDefined(input.charAt(2)));
    }
    //не мое решение
    public static String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currRow = 0;
        boolean down = false;

        for (char ch : s.toCharArray()) {
            rows[currRow].append(ch);

            if (currRow == 0 || currRow == numRows - 1) {
                down = !down;
            }

            currRow += down ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
//    14 symbols, 3 rows, 7 columns PAHNAPLSIIGYIR
//    0   2   4   6
//    P   A   H   N
//    A P L S I I G
//    Y   I   R

//    4 rows, 7 columns
//    0     3     6
//    P     I     N
//    A   L S   I G
//    Y A   H R
//    P     I

//    5 rows, 6 columns
//    0 1 2 3 4       8
//    P       H       i
//    A     S I     g
//    Y   I   R   d
//    P L     I G
//    A       N
//    Мое решение
//    public static String convert(String s, int numRows) {
//
//        int length = s.length();
//        if (length < numRows || numRows == 1) {
//            return s;
//        }
//        char[] charArray = s.toCharArray();
//        int symbolNumber = 0;
//        int numberOfWholeParts = length / numRows;
//        int i1 = (numberOfWholeParts - 1) * (numRows - 2);
//        i1 = i1 < 0 ? 0 : (numberOfWholeParts - 1) * (numRows - 2);
//        int columnsNumber = numberOfWholeParts + i1 + length - (numberOfWholeParts * numRows);
//        char[][] chars = new char[numRows][columnsNumber];
//        int numberFullColumn = 0;
//        StringBuilder builder = new StringBuilder();
//
//
//        for (int j = 0; j < length; j++) {
//            if (j == 0 || j == numberFullColumn) {
//                for (int i = 0; i < numRows; i++) {
//                    chars[i][j] = charArray[symbolNumber];
//                    symbolNumber++;
//                    if (symbolNumber == length) {
//                        break;
//                    }
//                }
//                    numberFullColumn += numRows - 1;
//            } else {
//                for (int i = 0; i < numRows; i++) {
//
//                    if (numberFullColumn - j == i) {
//                        chars[i][j] = charArray[symbolNumber];
//                        symbolNumber++;
//                    }
//                    if (symbolNumber == length) {
//                        break;
//                    }
//                }
//            }
//            if (symbolNumber == length) {
//                break;
//            }
//        }
//        for (int i = 0; i < numRows; i++) {
//            for (int j = 0; j < columnsNumber; j++) {
//                if (Character.getNumericValue(chars[i][j]) != -1 || isPunctuation(chars[i][j]))
//                    builder.append(chars[i][j]);
//            }
//        }
//        return builder.toString();
//    }
//    static boolean isPunctuation(char ch) {
//        if (ch == '!' || ch == '\"' || ch == '#' || ch == '$' || ch == '%' || ch == '&' || ch == '\'' || ch == '(' || ch == ')' || ch == '*' || ch == '+' || ch == ',' || ch == '-' || ch == '.' || ch == '/' || ch == ':' || ch == ';' || ch == '<' || ch == '=' || ch == '>' || ch == '?' || ch == '@' || ch == '[' || ch == '\\' || ch == ']' || ch == '^' || ch == '`' || ch == '{' || ch == '|' || ch == '}')
//            return true;
//        return false;
//    }
