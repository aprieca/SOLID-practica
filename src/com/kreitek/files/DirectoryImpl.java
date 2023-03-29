package com.kreitek.files;

import com.kreitek.files.interfaces.Directory;
import com.kreitek.files.interfaces.FileSystemItem;

import java.util.ArrayList;
import java.util.List;

public class DirectoryImpl extends FileSystemItemBase implements Directory {

    private final List<FileSystemItem> files;

    public DirectoryImpl(FileSystemItem parent, String name) {
        super(parent, name);
        files = new ArrayList<>();
        // Aquí vendría lógica que rellena la lista de ficheros
    }


    @Override
    public List<FileSystemItem> listFiles() {
        return files;
    }

    @Override
    public void addFile(FileSystemItem file) {
        if (!files.contains(file)) {
            files.add(file);
            file.setParent(this);
        }
    }

    @Override
    public void removeFile(FileSystemItem file) {
        files.remove(file);
    }

    @Override
    public int getSize() {
        throw new UnsupportedOperationException(NO_ES_VALIDO_PARA_DIRECTORIOS);
    }


}
