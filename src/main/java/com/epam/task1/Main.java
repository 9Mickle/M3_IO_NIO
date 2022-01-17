package com.epam.task1;

import com.epam.task1.model.transport.Jeep;
import com.epam.task1.model.transport.VehicleConfiguration;
import com.epam.task1.model.user.Address;
import com.epam.task1.model.user.User;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        Jeep jeep = new Jeep(
                1L,
                "Nissan",
                "Black",
                1_000_000,
                new VehicleConfiguration(4, "Diesel", "Left")
        );

        User<Jeep> user = new User<>(
                "Mikhail",
                21,
                new Address("Street", 170),
                jeep
        );

        File file = new File("src/main/resources/folderTask1/InfoAboutUser.txt");

        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {

            outputStream.writeObject(user);
            outputStream.writeObject(jeep);
            User<Jeep> userFromFile = (User<Jeep>) inputStream.readObject();
            Jeep jeepFromFile = (Jeep) inputStream.readObject();

            System.out.println(GetInfo.getUserInfo(userFromFile));
            System.out.println(GetInfo.getTransportInfo(jeepFromFile));

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
