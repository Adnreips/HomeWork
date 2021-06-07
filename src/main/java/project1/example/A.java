package project1.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import javax.json.Json;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * A
 *
 * @author "Andrei Prokofiev"
 */
public class A {
//    int var1 = 123;
//    //declaring final variables
//    final int var2 = 345;
//    final int var3;
//
//    //Trying to initialize a blank final variable
////    var = 555; //Error
//    A() {
//        var1 = 111; //No Error
////        var2 = 333; //Compilation Error
////Initializing a blank final variable
//        var3 = 444; //No Error
//    }
//
//    //passing final parameters
//    void avg(int param1, final int param2) {
//        param1 = 2345; //No Error
////        param2 = 1223; //Compilation Error
//    }
//
//    //declaring final fields
//    void show() {
//        final int fieldVal = 300000;
////        fieldVal = 400000; //Error
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof A)) return false;
//        A a = (A) o;
//        return var1 == a.var1 && var2 == a.var2 && var3 == a.var3;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(var1, var2, var3);
//    }

    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

//        String json = "{ \"f1\" : \"v1\" } ";
//
//
//        JsonNode jsonNode = objectMapper.readTree(json);
//
//        System.out.println(jsonNode.get("f1").asText());

        String json = "[{\"satellites\":{\"DEBIT_CARD_FEATURE__1\":{\"isSelected\":true,\"type\":\"DEBIT_CARD_FEATURE\",\"subtype\":1}}}" +
                ",{\"satellites\":{\"VTB_MOBILE__2\":{\"isSelected\":true,\"type\":\"VTB_MOBILE\",\"subtype\":2}}}]";
        JsonNode jsonNode = objectMapper.readTree(json);
        System.out.println(jsonNode.get(0).get("satellites").get("DEBIT_CARD_FEATURE__1"));

//        System.out.println(traverse(jsonNode));
        ;

//
//        System.out.println(jsonNode.get("satellites"));
////        traverse(jsonNode);
//
//        ArrayNode arrayNode =(ArrayNode) jsonNode;
//        System.out.println(jsonNode.get(0).get("satellites").get("DEBIT_CARD_FEATURE__1"));



    }
    public static void update(String jsonString, Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.readerForUpdating(object).readValue(jsonString);
        } catch (JsonProcessingException e) {
            //			logger.warn("update json string:" + jsonString + " to object:" + object + " error.", e);
        } catch (IOException e) {
            //			logger.warn("update json string:" + jsonString + " to object:" + object + " error.", e);
        }
    }
    public static JsonNode traverse(JsonNode root){

        if(root.isObject()){
            Iterator<String> fieldNames = root.fieldNames();
            while(fieldNames.hasNext()) {
                String fieldName = fieldNames.next();
                if (fieldName.equals("isSelected")){
                    System.out.println("++++++++++++++++");
                    return root.get(fieldName);
                }
                JsonNode fieldValue = root.get(fieldName);
                traverse(fieldValue);
            }
        } else
            if(root.isArray()){
            ArrayNode arrayNode = (ArrayNode) root;
            for(int i = 0; i < arrayNode.size(); i++) {
                JsonNode arrayElement = arrayNode.get(i);
                traverse(arrayElement);
            }
        } else {
            // JsonNode root represents a single value field - do something with it.
                System.out.println(root);
                return root;

        }
            return null;
    }


}
