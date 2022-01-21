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
        checkPath();
    }

    /**
     * Проверка пути введеного пользователем.
     * Если путь не явялется директорией, то просим повторить ввод, иначе пользлватель выбирает функцию.
     */
    public static void checkPath() throws IOException {
        Menu.printPath();
        String path = "C:\\" + sc.next();
        if (!Files.isDirectory(Path.of(path))) {
            System.out.print("\nEnter the path to the file, not the directory! Please, try again.");
            checkPath();
        } else {
            choiceFeature(path);
        }
    }

    /**
     * Выбор функции.
     * @param path проверенный путь.
     */
    public static void choiceFeature(String path) throws IOException {
        Scanner sc = new Scanner(System.in);
        Menu.printMenu();
        int choice = sc.nextInt();
        if (choice > 0 && choice < 6) {
            switch (choice) {
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
        } else {
            System.out.println("\nWrong choice! Please, try again..");
            choiceFeature(path);
        }
    }
}
