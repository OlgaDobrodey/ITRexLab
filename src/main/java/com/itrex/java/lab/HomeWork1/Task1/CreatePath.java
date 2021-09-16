package com.itrex.java.lab.HomeWork1.Task1;

import java.io.File;

public class CreatePath {

    /**
     * формирует абсолютный пусть aClass
     * @param aClass - класс, абсолютный пусть aClass
     * @return абсолютный пусть aClass
     */
    public static String getPath(Class<?> aClass) {
        String path = aClass.getPackageName().replace(".", File.separator);
        String packageName = "src" + File.separator + path + File.separator;
        return packageName;
    }

}
