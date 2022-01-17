package com.epam.task3.util.methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * FileChannel.
 */
public class FileChannelCopy {

    public static void copyFile(String initialPath, String finalPath) {
        File originFile = new File(initialPath);
        File copiedFile = new File(finalPath);

        if (originFile.exists() && originFile.isFile()) {
            try (FileChannel sourceChannel = new FileInputStream(originFile).getChannel();
                 FileChannel destChannel = new FileOutputStream(copiedFile).getChannel()) {
                destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("The source file does not exist");
        }
    }
}
