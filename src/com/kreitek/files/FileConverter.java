package com.kreitek.files;
import com.kreitek.files.interfaces.FileSystemItem;

public abstract class FileConverter extends FileImpl {
    public FileConverter(FileSystemItem parent, String name) {
        super(parent, name);
    }

/*  Aquí habría clases comunes a otras clases que convierten tipos de fichero especificos
    tenemos file converterAudio, pero con otras clases
    podriamos convertir ficheros de video o cualquier otro formato que se necesite*/

}