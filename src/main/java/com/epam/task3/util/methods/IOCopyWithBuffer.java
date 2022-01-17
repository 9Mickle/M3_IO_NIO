package com.epam.task3.util.methods;

import java.io.*;

/**
 * FileStreams with buffer 100 kb.
 */
public class IOCopyWithBuffer {

    public static void copyFile(String initialPath, String finalPath) {
        File originFile = new File(initialPath);
        File copiedFile = new File(finalPath);

        if (originFile.exists() && originFile.isFile()) {
            try (InputStream inputStream = new FileInputStream(originFile);
                 OutputStream outputStream = new FileOutputStream(copiedFile)) {
                byte[] buffer = new byte[100];
                int count;
                while ((count = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, count);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("The source file does not exist");
        }
    }
}