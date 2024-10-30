package leetcode;

public class Task8 {
    public static void main(String[] args) {
//        System.out.println(myAtoi("42"));
//        System.out.println(myAtoi("-042"));
        System.out.println(myAtoi("1337c0d3"));
//        System.out.println(myAtoi("0-1"));
//        System.out.println(myAtoi("-91283472332"));
//        System.out.println(myAtoi("3.14159"));
        System.out.println(myAtoi("   -042"));
//        System.out.println(myAtoi("+1"));
        System.out.println(myAtoi("   +0 123"));
        System.out.println(myAtoi("1337c0d3"));
        System.out.println(myAtoi("   -042"));
        System.out.println(myAtoi("-5-"));

    }

    public static int myAtoi(String s) {
        s=s.trim();
        String s1 = checkSpace(s);
        int result = 0;
        boolean positive = true;
        for (char c : s1.toCharArray()) {
            int v = c - '0';
            if (v < 0 && c != '+') {
                positive = false;
                continue;
            } else if (c == '+') {
                continue;
            }
            if (result > (Integer.MAX_VALUE - v) / 10) {
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + v;
        }
        return positive ? result : -result;
    }

    private static String checkSpace(String s) {
        char[] charArray = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        int countDigitSymbols = 0;
        for (char c : charArray) {
            boolean isMi = c == '-' || c == '+';
            if (isMi) {
                if (builder.length() > 0) {
                    return builder.toString();
                }
                builder.append(c);
                continue;
            }
            if (Character.isDigit(c)) {
                builder.append(c);
                countDigitSymbols++;
                continue;
            }
            if ((Character.isLetter(c) || isPunctuation(c)) && countDigitSymbols == 0) {
                return "0";
            } else if ((Character.isLetter(c) || isPunctuation(c)) && countDigitSymbols>0) {
                return builder.toString();
            }
        }
        return builder.toString();
    }

    static boolean isPunctuation(char ch) {
        if (ch == ' ' || ch == '!' || ch == '\"' || ch == '#' || ch == '$' || ch == '%' || ch == '&' || ch == '\'' || ch == '(' || ch == ')' || ch == '*' || ch == '+' || ch == ',' || ch == '-' || ch == '.' || ch == '/' || ch == ':' || ch == ';' || ch == '<' || ch == '=' || ch == '>' || ch == '?' || ch == '@' || ch == '[' || ch == '\\' || ch == ']' || ch == '^' || ch == '`' || ch == '{' || ch == '|' || ch == '}')
            return true;
        return false;
    }
}
