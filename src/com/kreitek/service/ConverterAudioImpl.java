package com.kreitek.service;

import com.kreitek.files.DirectoryImpl;

import com.kreitek.files.FileConverter;
import com.kreitek.files.FileImpl;
import com.kreitek.files.error.InvalidFileFormatException;
import com.kreitek.files.interfaces.ConverterAudio;
import com.kreitek.files.interfaces.FileWrite;

public class ConverterAudioImpl {
    public class converterAudioImpl extends FileConverter implements ConverterAudio {
        public converterAudioImpl(DirectoryImpl parent, String name) {
            super(parent, name);
        }



        public FileWrite convertMp3ToWav() {
            if (!"mp3".equalsIgnoreCase(getExtension())) {
                throw new InvalidFileFormatException("El fichero debe ser mp3");
            }

            int indexOfLastDot = name.lastIndexOf(".");
            String nameWithoutExtension = name;
            if (indexOfLastDot > 0) {
                nameWithoutExtension = name.substring(0, indexOfLastDot);
            }
            String newFileName = nameWithoutExtension + ".wav";
            FileWrite result = new FileImpl(parent, newFileName);
            result.open();
            // Lógica de conversión de mp3 a wav. Se lee de este fichero y se escribe en result
            result.close();
            return result;
        }


        public FileWrite convertWavToMp3() {
            if (!"wav".equalsIgnoreCase(getExtension())) {
                throw new InvalidFileFormatException("El fichero debe ser wav");
            }

            int indexOfLastDot = name.lastIndexOf(".");
            String nameWithoutExtension = name;
            if (indexOfLastDot > 0) {
                nameWithoutExtension = name.substring(0, indexOfLastDot);
            }
            String newFileName = nameWithoutExtension + ".mp3";
            FileWrite result = new FileImpl(parent, newFileName) {
            };
            result.open();
            // Lógica de conversión de wav a mp3. Se lee de este fichero y se escribe en result
            result.close();
            return result;
        }
}
}

