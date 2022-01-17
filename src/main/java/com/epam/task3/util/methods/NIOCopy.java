package com.epam.task3.util.methods;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * NIO 2 File API.
 */
public class NIOCopy {
    public static void copyFile(String initialPath, String finalPath) {

        if (Files.exists(Path.of(initialPath))) {
            try {
                //Удаляем файл с таким же названием если он уже есть в директории.
                Files.deleteIfExists(Path.of(finalPath));
                Files.copy(Path.of(initialPath), Path.of(finalPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("The source file does not exist");
        }
    }
}
