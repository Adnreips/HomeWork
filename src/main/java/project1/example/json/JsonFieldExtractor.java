package project1.example.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//@Service("JsonFieldExtractor")
@RequiredArgsConstructor
public class JsonFieldExtractor {
    private final ObjectMapper objectMapper;
    private List<Object> listValues;

    @SneakyThrows
    public List<Object> extract(String jsonString, Map<String, String[]> payloadFieldsPathMap, int actionsCount) {
        listValues = new ArrayList<>();

        if (jsonString.isBlank()) return listValues;

        ArrayNode jsonNode = (ArrayNode) objectMapper.readTree(jsonString);

        for (String[] payloadFields : payloadFieldsPathMap.values()) {
            for (int i = 0; i < actionsCount; i++) {
                if (payloadFields.length != 1) {
                    listValues.add(jsonNode.path(i).path(payloadFields[0]).path(payloadFields[1]));
                } else {
                    listValues.add(jsonNode.path(i).path(payloadFields[0]));
                }
            }
        }
        return listValues;
    }
}
