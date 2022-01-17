package com.epam.task1.model.user;

import java.io.Serializable;

/**
 * Адрес пользователя.
 */
public class Address implements Serializable {
    private String street;
    private transient Integer numberOfHouse;

    public Address(String street, int numberOfHouse) {
        this.street = street;
        this.numberOfHouse = numberOfHouse;
    }

    @Override
    public String toString() {
        return
                "street='" + street + '\'' +
                ", numberOfHouse=" + numberOfHouse;
    }

    public String getStreet() {
        return street;
    }
}
