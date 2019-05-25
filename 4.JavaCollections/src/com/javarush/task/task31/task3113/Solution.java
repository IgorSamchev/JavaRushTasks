package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.CONTINUE;

/* 
Что внутри папки?
*/
public class Solution {
    static int folderCount = -1;
    static int fileCount = 0;
    static long byteCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Path path = Paths.get(bufferedReader.readLine());
        bufferedReader.close();
        boolean isDirectory = Files.isDirectory(path);
        if (!isDirectory) {
            System.out.println(path.toAbsolutePath() + " - не папка");
            return;
        }

        Files.walkFileTree(path, new Visitor());


        System.out.println("Всего папок - " + folderCount);
        System.out.println("Всего файлов - " + fileCount);
        System.out.println("Общий размер - " + byteCount);
    }

    private static class Visitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            folderCount += 1;
            return CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            fileCount += 1;
            byteCount = byteCount + attrs.size();
            return CONTINUE;
        }
    }
}


