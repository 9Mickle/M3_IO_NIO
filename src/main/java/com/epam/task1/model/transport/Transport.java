package com.epam.task1.model.transport;

import java.io.Serializable;

/**
 * Транспорт с серийным номером, брендом и цветом.
 */
public abstract class Transport implements Serializable {
    private transient Long serialNumber;
    private String brand;
    private String color;

    public Transport(Long serialNumber, String brand, String color) {
        this.serialNumber = serialNumber;
        this.brand = brand;
        this.color = color;
    }

    public Long getSerialNumber() {
        return serialNumber;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }
}
