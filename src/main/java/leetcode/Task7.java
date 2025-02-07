package leetcode;

public class Task7 {
    public static void main(String[] args) {

        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(9646324351));
    }

    public static int reverse(int x) {
        try {
            boolean check = x != (int) x;
        } catch (NumberFormatException e) {
            return 0;
        }

        String s = String.valueOf(x);
        String intermediateResult;
        if (s.contains("-")) {
            intermediateResult = "-" + getString(s.replace("-", ""));
        } else {
            intermediateResult = getString(s);
        }
        int result;
        try {
            result = Integer.parseInt(intermediateResult);
        } catch (NumberFormatException e) {
            result = 0;
        }
        return result;
    }

    private static String getString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
