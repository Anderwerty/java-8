package com.epam.java8.lesson1;

import java.util.function.BiFunction;

public class Example3 {
    public static void main(String[] args) {
//        BiFunction<Integer, Integer, Integer> functionMax1 =
//                (t, u) -> Math.max(t, u);
//
//        BiFunction<Integer, Integer, Integer> functionMax2 = Math::max;
//
//        Pair pair = new Pair("1", 2);
//        HashMap<Object, Object> map = new HashMap<>();
//        map.put(pair, "A");
////        pair.setValue("20");
//        Object o = map.get(pair);
//        System.out.println(o);

        BiFunction<Integer, String, Pair> pairFabric1 =
                (key, value) -> new Pair(value, key);

        BiFunction<String, Integer, Pair> pairFabric2 = Pair::new;
    }
}

class Pair {
    private final String key;
    private final Integer value;

    Pair(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

}
