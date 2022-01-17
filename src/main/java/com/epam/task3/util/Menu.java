package com.epam.task3.util;

public class Menu {
    public static void getMenu() {
        System.out.print("\n---------Menu---------" +
                "\nSelect one of the functions: " +
                "\n1) - It uses FileStreams." +
                "\n2) - It uses FileStreams with buffer 100 kb." +
                "\n3) - It uses FileChannel;" +
                "\n4) - It uses NIO 2 File API." +
                "\n5) - Exit" +
                "\nYour choice: ");
    }

    public static void getInitialPath(String path) {
        System.out.print("\nEnter initial path: " + path);
    }

    public static void getFinalPath(String path) {
        System.out.print("\nEnter final path: " + path);
    }
}
