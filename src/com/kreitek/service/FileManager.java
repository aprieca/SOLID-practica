package com.kreitek.service;

import com.kreitek.files.DirectoryImpl;
import com.kreitek.files.FileImpl;
import com.kreitek.files.interfaces.FileSystemItem;

import java.util.List;

public class FileManager {

    public static int calculateSize(FileSystemItem fileSystemItem) {
        int totalSize = 0;

        if (fileSystemItem instanceof FileImpl) {
            totalSize = fileSystemItem.getSize();
        } else if (fileSystemItem instanceof DirectoryImpl) {
            for (FileSystemItem item : fileSystemItem.listFiles()) {
                totalSize += calculateSize(item);
            }
        }

        return totalSize;
    }

    public static int calculateSize(List<FileSystemItem> files) {
        int totalSize = 0;

        for(FileSystemItem item : files) {
            if (item instanceof FileImpl) {
                totalSize += item.getSize();
            } else if (item instanceof DirectoryImpl) {
                totalSize += calculateSize(item.listFiles());
            }
        }

        return totalSize;
    }

    // Aquí habría otros métodos para gestionar ficheros y directorios:
    // Crear ficheros, mover ficheros, eliminar ficheros, etc.
}
