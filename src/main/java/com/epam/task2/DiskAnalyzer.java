package com.epam.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Утилита для анали диска.
 * Вводить пути строго только до директории включительно.
 */
public class DiskAnalyzer {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        //Будем принимать путь к файлам на диске С.
        String path = "C:\\";

        //Просим пользователя ввести путь.
        Menu.getPath(path);
        //Если введнный путь не является директорией, то просим повторить ввод.
        path = checkPath(path + sc.next());

        //Показываем пользователю меню и просим выбрать одну из функций.
        Menu.getMenu(path);
        int userChoice = sc.nextInt();

        //Будем выводить меню до тех пор, пока пользователь не выберет в меню номер 5 - это выход.
        while (userChoice != 5) {
            //Проверяем, если пользовтель ввел цифру не из пункта меню, то просим его повторить ввод.
            if (userChoice > 5 || userChoice < 1) {
                System.out.print("\nWrong choice! Please, try again." +
                        "\nEnter: ");
                userChoice = sc.nextInt();
            }

            //Функции.
            switch (userChoice) {
                case 1: {
                    System.out.print("Enter liter: ");
                    String liter = sc.next();
                    Feature.findMax(path, liter);
                    break;
                }
                case 2: {
                    Feature.findTop5(path);
                    break;
                }
                case 3: {
                    Feature.findAverage(path);
                    break;
                }
                case 4: {
                    Feature.groupFile(path);
                    break;
                }
                default: {
                    System.out.println("Exit...");
                    break;
                }
            }
            path = "C:\\";

            //После выполнении функции снова просим пользователя ввести путь к директории.
            Menu.getPath(path);
            path += checkPath(path + sc.next());

            //Показываем меню.
            Menu.getMenu(path);
            userChoice = sc.nextInt();
        }
    }

    /**
     * Проверка пути введеного пользователем.
     * Если путь не явялется директорией, то просим повторить ввод, иначе возвращаем путь.
     *
     * @param path путь.
     * @return проверенный путь.
     */
    public static String checkPath(String path) {
        while (!Files.isDirectory(Path.of(path))) {
            System.out.print("\nEnter the path to the file, not the directory! Please, try again.");
            path = "C:\\";

            System.out.print("\nEnter: " + path);
            path += sc.next();
        }
        return path;
    }
}
