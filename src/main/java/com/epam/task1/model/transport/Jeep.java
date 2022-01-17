package com.epam.task1.model.transport;

import java.util.Objects;

/**
 * Джип - наследник Транспорта со своей ценой и конфигурацией.
 */
public class Jeep extends Transport {
    private transient Integer price;
    private VehicleConfiguration vehicleConfiguration;

    public Jeep(Long serialNumber, String brand, String color, Integer price, VehicleConfiguration vehicleConfiguration) {
        super(serialNumber, brand, color);
        this.price = price;
        this.vehicleConfiguration = vehicleConfiguration;
    }

    public Integer getPrice() {
        return price;
    }

    public VehicleConfiguration getVehicleConfiguration() {
        return vehicleConfiguration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jeep jeep = (Jeep) o;
        return Objects.equals(price, jeep.price) && Objects.equals(vehicleConfiguration, jeep.vehicleConfiguration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, vehicleConfiguration);
    }
}
