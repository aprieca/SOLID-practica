package com.kreitek.service;

import com.kreitek.files.DirectoryImpl;
import com.kreitek.files.FileImpl;
import com.kreitek.files.interfaces.FileSystemItem;

import java.util.List;

public class FileManager {

    public static int calculateSize(List<FileSystemItem> files) {
        int totalSize = 0;

        for(FileSystemItem item : files) {

                totalSize += item.getSize();
        }

        return totalSize;
    }

    // Aquí habría otros métodos para gestionar ficheros y directorios:
    // Crear ficheros, mover ficheros, eliminar ficheros, etc.
}
