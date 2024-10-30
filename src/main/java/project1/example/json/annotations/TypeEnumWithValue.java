package project1.example.json.annotations;

import com.fasterxml.jackson.annotation.JsonValue;


public enum TypeEnumWithValue {
    TYPE1(1, "Type A"), TYPE2(2, "Type 2");

    private Integer id;
    private String name;

//    public TypeEnumWithValue() {
//    }

    TypeEnumWithValue(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }
}
