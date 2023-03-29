package com.kreitek.files.interfaces;

import com.kreitek.files.DirectoryImpl;

import java.util.List;

public interface FileSystemItem {
    String getName();
    void setName(String name);
    DirectoryImpl getParent();
    void setParent(DirectoryImpl directory);
    String getFullPath();
    int getSize();
}
