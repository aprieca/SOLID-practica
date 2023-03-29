package com.kreitek.files.interfaces;

public interface FileWrite {
    void write(byte[] buffer);

    void open();

    void close();
}
