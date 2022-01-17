package com.epam.task1;

import com.epam.task1.model.transport.Jeep;
import com.epam.task1.model.transport.VehicleConfiguration;
import com.epam.task1.model.user.Address;
import com.epam.task1.model.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;

public class TestSerialize {

    private static Jeep jeep;
    private static User<Jeep> user;
    private static File file;

    @BeforeAll
    public static void setUp() {
        jeep = new Jeep(
                1L,
                "Nissan",
                "Black",
                1_000_000,
                new VehicleConfiguration(4, "Diesel", "Left")
        );

        user = new User<>(
                "Mikhail",
                21,
                new Address("Street", 170),
                jeep
        );

        file = new File("src/main/resources/folderTask1/InfoAboutUser.txt");
    }

    /**
     * Так как в условии задания было сказано, что все числовые поля не должны быть сериализованы
     * мы не можем сравнить созданного пользователя и его копию из файла т.к они будут отличатся в полях где есть число,
     * поэтому будем сравнить по полям.
     */
    @Test
    public void testSerialize() {

        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {

            outputStream.writeObject(user);
            outputStream.writeObject(jeep);

            User<Jeep> userFromFile = (User<Jeep>) inputStream.readObject();
            Jeep jeepFromFile = (Jeep) inputStream.readObject();

            Assertions.assertEquals(user.getName(), userFromFile.getName());
            Assertions.assertEquals(user.getAddress().getStreet(), userFromFile.getAddress().getStreet());

            Assertions.assertEquals(jeep.getBrand(), jeepFromFile.getBrand());
            Assertions.assertEquals(jeep.getColor(), jeepFromFile.getColor());
            Assertions.assertEquals(jeep.getVehicleConfiguration().getHandDriveType(),
                    jeepFromFile.getVehicleConfiguration().getHandDriveType());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
