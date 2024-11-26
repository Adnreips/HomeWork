package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Task17 {
    @Test
    void test() {
        Assertions.assertEquals(List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"), letterCombinations("23"));
        Assertions.assertEquals(List.of(), letterCombinations(""));
        Assertions.assertEquals(List.of("w","x","y","z"), letterCombinations("9"));
    }

    private static final Map<Character, List<String>> symbolsMap = Map.of(
            '2', List.of("a", "b", "c"),
            '3', List.of("d", "e", "f"),
            '4', List.of("g", "h", "i"),
            '5', List.of("j", "k", "l"),
            '6', List.of("m", "n", "o"),
            '7', List.of("p", "q", "r", "s"),
            '8', List.of("t", "u", "v"),
            '9', List.of("w", "x", "y","z")
    );

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        char[] chars = digits.toCharArray();
        for (char aChar : chars) {
            List<String> joinAble = symbolsMap.get(aChar);
            result = concatSymbols(result, joinAble);
        }
        return result;
    }

    private List<String> concatSymbols(List<String> list, List<String> joinAble) {
        List<String> result = new ArrayList<>();
        if (list.isEmpty()) {
            result.addAll(joinAble);
        } else {
            for (String elementOfResult : list) {
                for (String s : joinAble) {
                    result.add(elementOfResult.concat(s));
                }
            }

        }
        return result;
    }
}
