package com.epam.java8.lesson2.example1;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {
    public static void main(String[] args) {

        List<String> numbers = Arrays.asList("One", "Two", "Three", null);

        long countResult = numbers.stream().filter(Objects::nonNull).count();
        //size() int.
        System.out.println(countResult);

        Stream<User> stream = Stream.of(null, new User(null), new User(new Address("London")),
                new User(new Address("Kiev")));
        // list:user --> (?) address --> list:city
        List<String> cities = stream
                .parallel()
                .filter(Objects::nonNull)
                .map(User::getAddress)
                .filter(Objects::nonNull)
                .map(Address::getCity)
                .filter(Objects::nonNull)
                //Collectors
                .collect(Collectors.toList());

        // () -> () ->

    }
}
