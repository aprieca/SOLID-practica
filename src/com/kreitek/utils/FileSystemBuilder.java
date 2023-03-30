package com.kreitek.utils;

import com.kreitek.files.DirectoryImpl;
import com.kreitek.files.FileImpl;
import com.kreitek.files.interfaces.FileSystemItem;

public class FileSystemBuilder {

    private final DirectoryImpl root;
    private DirectoryImpl currentDirectory;

    public static FileSystemBuilder getBuilder() {
        return new FileSystemBuilder();
    }

    public FileSystemBuilder() {
        root = new DirectoryImpl(null, "");
        currentDirectory = root;
    }

    public FileSystemBuilder addFile(String name, int size) {
        FileImpl file = new FileImpl(currentDirectory, name);
        file.open();
        file.write(new byte[size]);
        file.close();
        currentDirectory.addFile(file);
        return this;
    }

    public FileSystemBuilder addDirectory(String name) {
        DirectoryImpl directory = new DirectoryImpl(currentDirectory, name);
        currentDirectory.addFile(directory);
        currentDirectory = directory;
        return this;
    }

    public FileSystemBuilder upOneDirectory() {
        if (currentDirectory.getParent() != null) {
            currentDirectory = (DirectoryImpl) currentDirectory.getParent();
        }
        return this;
    }

    public FileSystemItem build() {
        return root;
    }
}
