package com.kreitek.utils;

import com.kreitek.files.DirectoryImpl;
import com.kreitek.files.FileImpl;
import com.kreitek.files.interfaces.Directory;
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
        FileImpl fileImpl = new FileImpl(currentDirectory, name);
        fileImpl.open();
        fileImpl.write(new byte[size]);
        fileImpl.close();
        currentDirectory.addFile(fileImpl);
        return this;
    }

    public FileSystemBuilder addDirectory(String name) {
        DirectoryImpl directoryImpl = new DirectoryImpl(currentDirectory, name);
        currentDirectory.addFile(directoryImpl);
        currentDirectory = directoryImpl;
        return this;
    }

    public FileSystemBuilder upOneDirectory() {
        if (currentDirectory.getParent() != null) {
            currentDirectory = currentDirectory.getParent();
        }
        return this;
    }

    public FileSystemItem build() {
        return root;
    }
}
