package com.epam.task2;

/**
 * GUI Меню.
 */
public class Menu {
    public static void getMenu(String path) {
        System.out.print("\n---------Menu---------" +
                "\nYou are here now: " + path +
                "\nSelect one of the functions: " +
                "\n1) - Search for the file name with the maximum number of letters ‘s’ in the name, display the path to it." +
                "\n2) - Print Top-5 largest files (by size in bytes)." +
                "\n3) - The average file size in the specified directory or any its subdirectory." +
                "\n4) - The number of files and folders, divided by the first letters of the alphabet." +
                "\n5) - Exit" +
                "\nYour choice: ");
    }

    public static void getPath(String path) {
        System.out.print("\nEnter the path: " + path);
    }
}
