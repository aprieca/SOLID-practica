package com.kreitek.files.interfaces;

public interface FileRead {
    void setPosition(int numberOfBytesFromBeginning);
    byte[] read(int numberOfBytesToRead);
    void open();
    void close();
}
