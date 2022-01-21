package com.epam.task2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;

public class Feature {

    /**
     * В этот файл заносится результаты работы всех функций.
     * Каждая функция перезаписывает старый результат на новый.
     */
    private static final String PATH_TO_FILE = "src/main/resources/folderTask2/info.txt";

    /**
     * Функция 1.
     * Здесь я решил сделать функцию немного универсальнее: мы получаем любую букву алфита для поиска,
     * а не только букву 's'.
     * Функция нужна для поиска имени файла с максимальным количеством букв "literal" в названии.
     * Результат работы функции заносим в файл info.txt, который находится в (resources/folderTask2).
     * <p>
     * Проходим по всем файлам и папкам в директории и ищем файл удовлетворяющий условию.
     *
     * @param path    путь к директории.
     * @param literal символ, по которому будем искать.
     */
    public static void findMax(String path, String literal) throws IOException {
        Optional<Path> max = Files
                .walk(Path.of(path), Integer.MAX_VALUE)
                .filter(fileName -> fileName.toString().contains(literal))
                .max(Comparator.comparingLong(o -> numberOfLitterInWord(literal, o)));

        if (max.isPresent()) {
            Files.write(Path.of(PATH_TO_FILE), max.get().toString().getBytes(StandardCharsets.UTF_8));
        } else {
            Files.write(Path.of(PATH_TO_FILE), "File not found".getBytes(StandardCharsets.UTF_8));
        }
    }

    /**
     * Функция 2.
     * Для поиска в директории топ 5 файлов по размеру в байтах.
     *
     * @param path путь к директории.
     */
    public static void findTop5(String path) throws IOException {
        List<String> collect = Files
                .list(Path.of(path))
                .sorted((o1, o2) -> (int) (getFileSize(o2) - getFileSize(o1)))
                .limit(5)
                .map(Path::toString)
                .collect(Collectors.toList());
        Files.write(Path.of(PATH_TO_FILE), collect);
    }

    /**
     * Функция 3.
     * Для подсчета среднего размера файлов в директории.
     *
     * @param path путь к директории.
     */
    public static void findAverage(String path) throws IOException {
        OptionalDouble average = Files
                .list(Path.of(path))
                .map(Feature::getFileSize)
                .mapToLong(s -> s).average();

        if (average.isPresent()) {
            Files.write(Path.of(PATH_TO_FILE),
                    String.valueOf(average.getAsDouble()).getBytes(StandardCharsets.UTF_8));
        } else {
            Files.write(Path.of(PATH_TO_FILE), "Directory is empty".getBytes(StandardCharsets.UTF_8));
        }
    }

    /**
     * Функция 4.
     * Для группировки файлов по буквам, на которые они начинаются.
     *
     * @param path путь к директории.
     */
    public static void groupFile(String path) throws IOException {
//        Files.walk(Path.of(path), Integer.MAX_VALUE)
//                .collect(Collectors.toMap(p -> p.getFileName().toString().charAt(0),
//                        Path::getFileName,
//                        (x, y) -> Path.of(x + ", " + y + ";")));

        Map<Character, List<Path>> collect = Files.walk(Path.of(path), Integer.MAX_VALUE)
                .collect(Collectors.groupingBy(p -> p.getFileName().toString().charAt(0),
                        Collectors.mapping(Path::getFileName, Collectors.toList())));

        // Для очистки файла от прежних записей.
        Files.write(Path.of(PATH_TO_FILE), "".getBytes(StandardCharsets.UTF_8));

        for (Map.Entry<Character, List<Path>> entry : collect.entrySet()) {
            Files.write(Path.of(PATH_TO_FILE),
                    (entry.getKey() + ": " + entry.getValue() + "\n").getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.APPEND);
        }
    }

    /**
     * (Метод для сортировки слов в функции 1).
     * Считаем сколько раз буква "ch" входит в название файла.
     *
     * @param ch   буква, введенная пользователем.
     * @param path путь к файлу.
     * @return кол-во букв.
     */
    private static long numberOfLitterInWord(String ch, Path path) {
        return path
                .getFileName()
                .toString()
                .chars()
                .filter(c -> c == ch.codePointAt(0))
                .count();
    }

    /**
     * Получаем размер файла в байтах.
     *
     * @param path путь к файлу.
     * @return размер файла.
     */
    private static long getFileSize(Path path) {
        long size = 0;
        try {
            size = Files.size(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return size;
    }
}
