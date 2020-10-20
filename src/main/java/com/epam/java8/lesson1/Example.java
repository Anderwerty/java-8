package com.epam.java8.lesson1;

public class Example {
    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();
        ArrayList.staticValue = 10;
    }
}

interface List<E> {
    int value = 1;

    void add(E element);

    E getByIndex(int index);

    default void clean() {

    }
}

class ArrayList<E> implements List<E> {
    public static int staticValue;
    public int value;

    @Override
    public void add(E element) {

    }

    @Override
    public E getByIndex(int index) {
        return null;
    }
}
