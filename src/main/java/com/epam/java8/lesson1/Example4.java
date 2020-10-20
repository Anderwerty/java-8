package com.epam.java8.lesson1;

import java.util.Optional;

import static java.util.Objects.nonNull;

public class Example4 {
    public static void main(String[] args) {

        City kiev = new City("Kiev");
        Address address = null;
//                new Address(kiev);
        User user = new User(address);

        // city name from user
        //#1
        String cityName = user.address.city.name;

        //#2 if-else
        String cityName1 = cityNameFromUser(user);

        //#3 Null pattern https://ru.wikipedia.org/wiki/Null_object_(%D1%88%D0%B0%D0%B1%D0%BB%D0%BE%D0%BD_%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F)
        City nullCity = new City("Null");
        Address nullAddress = new Address(nullCity);
        User nullUser = new User(nullAddress);

        //#4 Optional
        //#4.1. Optional + NULL-pattern
        String name = Optional.ofNullable(user).orElse(nullUser).address.city.name;
        if (name.equals("Null")) {
            System.out.println("City is null");
        }
        //#4.2. Just class Optional
        String city = Optional.ofNullable(user)
                .map(u -> u.address)
                .map(a -> a.city)
                .map(c -> c.name)
                .orElse(null);
//                .orElseThrow(IllegalArgumentException::new);

//                .orElseGet(() -> "null");
        System.out.println(city);
    }

    private static String cityNameFromUser(User user) {
        if (user != null) {
            Address address1 = user.address;
            if (nonNull(address1)) {
                City city = address1.city;
                if (city != null) {
                    return city.name;
                }
            }
        }

        return null;
    }
}

//NPE
class User {
    public Address address;

    public User(Address address) {
        this.address = address;
    }
}

class Address {
    public City city;

    public Address(City city) {
        this.city = city;
    }
}

class City {
    public String name;

    public City(String name) {
        this.name = name;
    }
}


