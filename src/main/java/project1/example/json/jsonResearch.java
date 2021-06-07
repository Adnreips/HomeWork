package project1.example.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.*;

public class jsonResearch {


    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
//        String json = "[{\"actionId\":\"DEBIT_CARD_FEATURE__1\",\"audit\":{\"type\":\"MULTI_SELECT\",\"satellite\":{\"type\":\"DEBIT_CARD_FEATURE\",\"subtype\":1,\"isSelected\":true}},\"satellites\":{\"DEBIT_CARD_FEATURE__1\":{\"type\":\"DEBIT_CARD_FEATURE\",\"subtype\":1,\"isSelected\":true}}},{\"actionId\":\"VTB_MOBILE__2\",\"audit\":{\"type\":\"MULTI_SELECT\",\"satellite\":{\"type\":\"VTB_MOBILE\",\"subtype\":2,\"isSelected\":true}},\"satellites\":{\"VTB_MOBILE__2\":{\"type\":\"VTB_MOBILE\",\"subtype\":2,\"isSelected\":true}}}]";
        String json = "";
        Map<String, String[]> map = new LinkedHashMap<>();
        int actionsCount = 4;

        List<String> payloadFields1 = Arrays.asList("actionId", "id", "audit", "type", "isSelected", "group",
                "defaultNextBestOffers", "nboId", "nextBestOffers", "product", "satellites",
                "product.isSelected",
                "product.type",
                "product.subtype",
                "satellites.isSelected",
                "satellites.type",
                "satellites.subtype");
        System.out.println(payloadFields1.size());
        payloadFields1.forEach(payloadField -> map.put(payloadField, payloadField.split("\\.")));

        System.out.println(extract(json, map, actionsCount));
    }

    public static List<Object> extract(String json, Map<String, String[]> map, int actionsCount) {
        List<Object> listValues = new ArrayList<>();

        if (json.isBlank()) return listValues;
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode jsonNode = null;
        try {
            jsonNode = (ArrayNode) objectMapper.readTree(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
//        if (jsonNode == null) return listValues;


        if (jsonNode == null) return listValues;

        for (String[] payloadFields : map.values()) {
            for (int i = 0; i < actionsCount; i++) {
//                if (jsonNode.get(i) == null) return listValues;
                if (payloadFields.length == 1) {
//                    if (jsonNode.get(i) == null) {
//                        listValues.add(null);
//                    } else
                    listValues.add(jsonNode.path(i).path(payloadFields[0]));

                } else {
//                    if (jsonNode.get(i) == null || jsonNode.get(i).get(payloadFields[0]) == null) {
//                        listValues.add(null);
//                    } else
                    listValues.add(jsonNode.path(i).path(payloadFields[0]).path(payloadFields[1]));

                }
            }

        }
        System.out.println(listValues.size());
        return listValues;
    }


}

