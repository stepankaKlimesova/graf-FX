package com.example.graffx;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class ConvertFile {

    public static String read(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new FileInputStream(file));
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine()).append("\n");
            }
        } catch (Exception e) {

        }
        return stringBuilder.toString();
    }

}

