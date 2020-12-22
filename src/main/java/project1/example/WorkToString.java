package project1.example;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * WorkToString
 *
 * @author "Andrei Prokofiev"
 */

public class WorkToString {

    public static void main(String[] args) {
        String string = "{\n" +
                "  id: 10002,\n" +
                "  from: \"EUR\",\n" +
                "  to: \"INR\",\n" +
                "  conversionMultiple: 75,\n" +
                "  port: 8000,\n" +
                "}";

        Map<String, Integer> map = new HashMap<>();
        System.out.println(string);

        String[] arrays = string.replaceAll(
                "[{}\n]", "").split(",");

        for (String s : arrays) {
            if (s.contains("id:")){
                map.put("id", Integer.valueOf(s.replace("id: ","").trim()));
            }
        }
        System.out.println(map.get("id"));

    }
}
