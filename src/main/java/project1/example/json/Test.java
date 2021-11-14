package project1.example.json;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Test {
    public static void main(String[] args) {

        String regex = "apple";
        String input = "crabapple";

        try {

            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(input);
            while (m.find())
                System.out.println("Found [" + m.group() + "] starting at "
                        + m.start() + " and ending at " + (m.end() - 1));
        } catch (PatternSyntaxException pse) {
            System.err.println("Неправильное регулярное выражение: " + pse.getMessage());
            System.err.println("Описание: " + pse.getDescription());
            System.err.println("Позиция: " + pse.getIndex());
            System.err.println("Неправильный шаблон: " + pse.getPattern());
        }
    }
}

