package com.kreitek.files.interfaces;
import java.util.List;

public interface Directory {
    public List<FileSystemItem> listFiles();
    void addFile(FileSystemItem file);
    void removeFile(FileSystemItem file);
}

