package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {
    public static void main(String[] args) {

    }

   private FileWriter fileWriter;

    public FileConsoleWriter(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        fileWriter = new FileWriter(fd);
    }

    public String getEncoding() {
        return fileWriter.getEncoding();
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf,off,len);
        System.out.print(new String(cbuf, off, len));
    }

    public void write(int c) throws IOException{
        this.fileWriter.write(c);
        System.out.println(c);
    }

    public void write(String str) throws IOException{
        this.fileWriter.write(str);
        System.out.println(str);
    }

    public void write(String str, int off, int len){
        try {
            fileWriter.write(str, off, len);
            System.out.print(str.substring(off, off + len));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(char[] cbuf) throws IOException{
        this.fileWriter.write(cbuf);
        System.out.println(cbuf);
    }

    public void close() throws IOException{
        this.fileWriter.close();
    }
}
