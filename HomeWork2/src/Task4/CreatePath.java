package Task4;

import java.io.File;

public class CreatePath {


    /**
     * формирует абсолютный пусть aClass
     * @param homeWorkName - название домашнего задания, String
     * @param aClass - класс, абсолютный пусть aClass
     * @return абсолютный пусть aClass
     */

    public static String getPath(String homeWorkName,Class<?> aClass){
        String root = System.getProperty("user.dir");
        String packageName = root + File.separator + homeWorkName + File.separator+
                "src"+File.separator + aClass.getPackageName()+ File.separator;
        return packageName;
    }
}
