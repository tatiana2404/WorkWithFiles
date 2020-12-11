package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File originFile=new File("D:\\Файлы");
        FileMethod m=new FileMethod("docx");
        File []allFiles=originFile.listFiles(m);

        for (File file : allFiles) {
            try {
                FileMethod.copyFile(file, new File("D:\\Курсы\\" + file.getName()));
                System.out.println("Done!");
            } catch (IOException e) {
                        e.printStackTrace();
            }
        }

    }
}
