package com.epam.task3.util.methods;

import java.io.*;

/**
 * FileStreams.
 */
public class IOCopy {

    public static void copyFile(String initialPath, String finalPath) {
        File originFile = new File(initialPath);
        File copiedFile = new File(finalPath);

        if (originFile.exists() && originFile.isFile()) {
            try (InputStream inputStream = new FileInputStream(originFile);
                 OutputStream outputStream = new FileOutputStream(copiedFile)) {
                int count;
                while ((count = inputStream.read()) > -1) {
                    outputStream.write(count);
                    outputStream.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("The source file does not exist");
        }
    }
}
