package com.epam.java8.lesson2.example1;

public class User {
    private final Address address;

    public User(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}
