package com.epam.java8.lesson1;

public class Example2 {
    public static void main(String[] args) {
        MyInterface myInterface = new MyInterface() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }
        };

        MyInterface myInterface1 = (a, b) -> a + b;

        Comparable<Object> comparable = o -> 1;

    }
}

@FunctionalInterface
interface MyInterface {
    int add(int a, int b);
}

class MyClass implements MyInterface {

    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
