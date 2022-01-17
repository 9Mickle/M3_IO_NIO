package com.epam.task3;

import com.epam.task3.util.CreateEmptyFiles;
import com.epam.task3.util.methods.FileChannelCopy;
import com.epam.task3.util.methods.IOCopyWithBuffer;
import com.epam.task3.util.methods.NIOCopy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestFastFileMover {

    /**
     * Тут будут создаваться файлы-пустышки для тестов!
     */
    private static final String PATH_TO_DIR = "C:\\run\\";

    private static final String pathOrigin = "C:\\run\\fileKB";
    private static final String pathCopied = "C:\\run2\\fileKB";

    /**
     * Создаём файлы перед тестом.
     */
    @BeforeAll
    public static void setUp() throws IOException {
        CreateEmptyFiles.createFile(PATH_TO_DIR);
    }

    /**
     * Тест работает очень медленно.
     * Запускать его только если копирауется маленький файл.
     */
//    @Test
//    public void testIOCopy() throws IOException {
//        long begin = System.currentTimeMillis();
//
//        IOCopy.copyFile(pathOrigin, pathCopied);
//
//        Assertions.assertTrue(Files.exists(Path.of(pathCopied)));
//        Assertions.assertEquals(Files.readAllLines(Path.of(pathOrigin)),
//                Files.readAllLines(Path.of(pathCopied)));
//
//        System.out.println("IOCopy time: " + (System.currentTimeMillis() - begin));
//    }

    @Test
    public void testIOCopyWithBuffer() throws IOException {
        long begin = System.currentTimeMillis();

        IOCopyWithBuffer.copyFile(pathOrigin, pathCopied);

        Assertions.assertTrue(Files.exists(Path.of(pathCopied)));
        Assertions.assertEquals(Files.readAllLines(Path.of(pathOrigin)),
                Files.readAllLines(Path.of(pathCopied)));

        System.out.println("IOCopyWithBuffer time: " + (System.currentTimeMillis() - begin));
    }

    @Test
    public void testFileChannelCopy() throws IOException {
        long begin = System.currentTimeMillis();

        FileChannelCopy.copyFile(pathOrigin, pathCopied);

        Assertions.assertTrue(Files.exists(Path.of(pathCopied)));
        Assertions.assertEquals(Files.readAllLines(Path.of(pathOrigin)),
                Files.readAllLines(Path.of(pathCopied)));

        System.out.println("FileChannelCopy time: " + (System.currentTimeMillis() - begin));
    }

    @Test
    public void testNIOCopy() throws IOException {
        long begin = System.currentTimeMillis();

        NIOCopy.copyFile(pathOrigin, pathCopied);

        Assertions.assertTrue(Files.exists(Path.of(pathCopied)));
        Assertions.assertEquals(Files.readAllLines(Path.of(pathOrigin)),
                Files.readAllLines(Path.of(pathCopied)));

        System.out.println("NIOCopy time: " + (System.currentTimeMillis() - begin));
    }
}
