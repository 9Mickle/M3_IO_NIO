package com.epam.task1.model.user;

/**
 * Пользователь.
 */
public class User <T> extends Person {

    private Address address;
    private T transport;

    public User(String name, Integer age, Address address, T transport) {
        super(name, age);
        this.address = address;
        this.transport = transport;
    }

    public T getTransport() {
        return transport;
    }

    public Address getAddress() {
        return address;
    }
}
