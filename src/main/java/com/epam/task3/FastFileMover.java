package com.epam.task3;

import com.epam.task3.util.Menu;
import com.epam.task3.util.methods.FileChannelCopy;
import com.epam.task3.util.methods.IOCopy;
import com.epam.task3.util.methods.IOCopyWithBuffer;
import com.epam.task3.util.methods.NIOCopy;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Утилита для копирования файла.
 * Вводить пути строго до самого файла включительно.
 */

public class FastFileMover {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //Будем принимать путь к диску С.
        String initialPath = "C:\\";
        String finalPath = "C:\\";

        //Просим ввести путь к файлу, который нужно скопировать.
        Menu.getInitialPath(initialPath);
        //Проверяем путь.
        initialPath = checkPath(initialPath + sc.next());

        //Просим ввести путь, куда нужно копировать.
        Menu.getFinalPath(finalPath);
        finalPath = checkPath(finalPath + sc.next());

        //Если введнный конечный путь является директорией, то просим повторить ввод.
        while (Files.isDirectory(Path.of(finalPath))) {
            System.out.print("\nEnter the final path to the file, not the directory! Please, try again.");
            finalPath = "C:\\";
            System.out.print("\nEnter: " + finalPath);
            finalPath += sc.next();
        }

        //Просим пользователя выбрать один из методов копирования.
        Menu.getMenu();
        int userChoice = sc.nextInt();

        while (userChoice != 5) {
            //Проверяем, если пользовтель ввел цифру не из пункта меню, то просим его повторить ввод.
            if (userChoice > 5 || userChoice < 1) {
                System.out.print("\nWrong choice! Please, try again." +
                        "\nEnter: ");
                userChoice = sc.nextInt();
            }

            //Методы копирования.
            switch (userChoice) {
                case 1: {
                    IOCopy.copyFile(initialPath, finalPath);
                    break;
                }
                case 2: {
                    IOCopyWithBuffer.copyFile(initialPath, finalPath);
                    break;
                }
                case 3: {
                    FileChannelCopy.copyFile(initialPath, finalPath);
                    break;
                }
                case 4: {
                    NIOCopy.copyFile(initialPath, finalPath);
                    break;
                }
                default: {
                    System.out.println("Exit...");
                    break;
                }
            }

            initialPath = "C:\\";
            finalPath = "C:\\";

            //Просим ввести пути.
            Menu.getInitialPath(initialPath);
            initialPath = checkPath(initialPath + sc.next());

            Menu.getFinalPath(finalPath);
            finalPath = checkPath(finalPath + sc.next());

            //Показываем меню.
            Menu.getMenu();
            userChoice = sc.nextInt();

        }
    }

    /**
     * Проверка пути введеного пользователем.
     * Если путь явялется директорией, то просим повторить ввод, иначе возвращаем путь.
     *
     * @param path путь.
     * @return проверенный путь.
     */
    public static String checkPath(String path) {
        while (Files.isDirectory(Path.of(path))) {
            System.out.print("\nEnter the path to the file, not the directory! Please, try again.");
            path = "C:\\";
            System.out.print("\nEnter path: " + path);
            path += sc.next();
        }
        return path;
    }
}
