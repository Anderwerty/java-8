package com.epam.java8.homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        //# 1
        HashMap<Key, String> map = new HashMap<>();
        //16
        // (key,value) ---> hashCode(key) --> 1, 17, ...
        //
        //....
        // 16 --> 16*2=32

        Key key = new Key(1);

        map.put(key, "Is looking for");

        key.setValue(17); // ----> 17

        map.put(new Key(0), "1");
        map.put(new Key(2), "1");
        map.put(new Key(3), "1");
        map.put(new Key(4), "1");
        map.put(new Key(5), "1");
        map.put(new Key(1), "1");


        String result = map.get(key);
        System.out.println(result);

        //# 2

        Set<Map.Entry<Key, String>> entries = map.entrySet();
        Iterator<Map.Entry<Key, String>> iterator = entries.iterator();

        String findResult = "";

        while (iterator.hasNext()) {
            Map.Entry<Key, String> entry = iterator.next();
            if (key.equals(entry.getKey())) {
                findResult = entry.getValue();
            }
        }

        StringBuilder findResult1 = new StringBuilder();

        map.forEach((k, v) -> {
            if (key.equals(k)) {
                findResult1.append(v);
            }
        });

        System.out.println(findResult1);
        System.out.println(key);

    }
}

class Key {
    private int value;

    public Key(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Key key = (Key) o;
        return value == key.value;
    }

//    @Override
//    public int hashCode() {
//        return value;
//    }
}
