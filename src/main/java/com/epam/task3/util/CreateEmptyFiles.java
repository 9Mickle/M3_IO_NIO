package com.epam.task3.util;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Создать файлы-путсышки разных объемов для тестов.
 */
public class CreateEmptyFiles {

    private static final int KB = 1024;
    private static final int KB100 = 1024 * 100;
    private static final int MB10 = 1024 * 1024 * 10;
    private static final int GB = 1024 * 1024 * 1024;

    private static final String path1 = "fileKB";
    private static final String path2 = "fileKB100";
    private static final String path3 = "fileMB10";
    private static final String path4 = "fileGB";
    private static final String path5 = "ffffile";

    public static void createFile(String path) throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile(path + path1, "rw");
        RandomAccessFile raf2 = new RandomAccessFile(path + path2, "rw");
        RandomAccessFile raf3 = new RandomAccessFile(path + path3, "rw");
        RandomAccessFile raf4 = new RandomAccessFile(path + path4, "rw");
        RandomAccessFile raf5 = new RandomAccessFile(path + path5, "rw");

        raf1.setLength(KB);
        raf2.setLength(KB100);
        raf3.setLength(MB10);
        raf4.setLength(GB);
        raf5.setLength(KB);
    }
}
