package com.epam.task2;

import com.epam.task3.util.CreateEmptyFiles;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TestDiskAnalyzer {

    /**
     * Тут создаются файлы-пустышки!
     */
    private static final String PATH_TO_DIR = "C:\\run\\";

    /**
     * Сюда выводится результат всех функций.
     */
    private static final String pathToResult = "src/main/resources/folderTask2/info.txt";

    @BeforeAll
    public static void setUp() throws IOException {
        CreateEmptyFiles.createFile(PATH_TO_DIR);
    }

    @Test
    public void testFindMax() throws IOException {
        Feature.findMax(PATH_TO_DIR, "f");
        String expected = PATH_TO_DIR + "ffffile";
        String actual = Files.readString((Path.of(pathToResult)));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFindTop5() throws IOException {
        Feature.findTop5(PATH_TO_DIR);
        List<String> expectedList = List.of(PATH_TO_DIR + "fileGB",
                PATH_TO_DIR + "fileMB10",
                PATH_TO_DIR + "fileKB100",
                PATH_TO_DIR + "ffffile",
                PATH_TO_DIR + "fileKB");
        List<String> actualList = Files.readAllLines(Path.of(pathToResult));
        Assertions.assertEquals(expectedList, actualList);
    }

    @Test
    public void testFindAverage() throws IOException {
        Feature.findAverage(PATH_TO_DIR);
        double expected = 2.168664064E8;
        double actual = Double.parseDouble(Files.readString(Path.of(pathToResult)));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGroupFile() throws IOException {
        Feature.groupFile(PATH_TO_DIR);
        String expected = "r: [run]\n" +
                "f: [ffffile, fileGB, fileKB, fileKB100, fileMB10]\n";
        String actual = Files.readString(Path.of(pathToResult));
        Assertions.assertEquals(expected, actual);
    }

}
