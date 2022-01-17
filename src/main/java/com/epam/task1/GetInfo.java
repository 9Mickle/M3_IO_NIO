package com.epam.task1;

import com.epam.task1.model.transport.Jeep;
import com.epam.task1.model.user.User;

/**
 * Утилитный класс для вывода информации о сущностях.
 */
public class GetInfo {

    /**
     * Получить информацию о пользователе.
     * @param user пользователь.
     */
    public static String getUserInfo(User<Jeep> user) {
        Jeep jeep = user.getTransport();
        return "User: " +
                "\n\tName: " + user.getName() +
                "\n\tAge: " + user.getAge() +
                "\n\tAddress: " + user.getAddress() +
                "\n\tCar: " +
                "\n\t\tSerial number: " + jeep.getSerialNumber() +
                "\n\t\tBrand: " + jeep.getBrand() +
                "\n\t\tPrice: " + jeep.getPrice() +
                "\n\t\tColor: " + jeep.getColor() +
                "\n\t\tConfiguration: " + jeep.getVehicleConfiguration();
    }

    /**
     * Получить информацию о джипе.
     * @param jeep джип.
     */
    public static String getTransportInfo(Jeep jeep) {
        return "Jeep: " +
                "\n\tSerial number: " + jeep.getSerialNumber() +
                "\n\tBrand: " + jeep.getBrand() +
                "\n\tPrice: " + jeep.getPrice() +
                "\n\tColor: " + jeep.getColor() +
                "\n\tConfiguration: " + jeep.getVehicleConfiguration();
    }
}
