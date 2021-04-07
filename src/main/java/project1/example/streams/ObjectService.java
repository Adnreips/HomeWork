package project1.example.streams;

import java.util.HashMap;

public class ObjectService {

    public volatile HashMap<Object, Object> map;

    public void main(String[] args) {
        map = new HashMap<>();
        map.put(1,1);
        map.put("d"," d");
    }

}
