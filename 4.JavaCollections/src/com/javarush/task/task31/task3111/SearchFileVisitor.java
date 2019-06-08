package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.FileVisitResult.CONTINUE;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private boolean isPartOfNameUsed = false;
    private boolean isPartOfContentUsed = false;
    private boolean isMinSizeUsed = false;
    private boolean isMaxSizeUsed = false;
    private List<Path> foundFiles = new ArrayList<>();

    public SearchFileVisitor() {
        this.partOfName = null;
        this.partOfContent = null;
        this.minSize = 0;
        this.maxSize = 0;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
        isPartOfNameUsed = true;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
        isPartOfContentUsed = true;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
        isMinSizeUsed = true;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
        isMaxSizeUsed = true;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (!attrs.isRegularFile()) return CONTINUE;

        if (isPartOfNameUsed && !file.getFileName().toString().contains(this.partOfName))
            return CONTINUE;

        if (isMinSizeUsed && attrs.size() < minSize)
            return CONTINUE;

        if (isMaxSizeUsed && attrs.size() > maxSize)
            return CONTINUE;

        if (isPartOfContentUsed && !new String(Files.readAllBytes(file)).contains(partOfContent))
            return CONTINUE;



        foundFiles.add(file);

        return CONTINUE;

    }
}
