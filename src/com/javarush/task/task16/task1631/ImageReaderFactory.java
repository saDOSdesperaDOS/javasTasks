package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes imageType) throws IllegalArgumentException  {
        ImageReader imageReader=null;
        switch (imageType) {
            case JPG: imageReader = new JpgReader();
            case BMP: imageReader = new BmpReader();
            case PNG: imageReader = new PngReader();
        }
        return imageReader;
    }
}
