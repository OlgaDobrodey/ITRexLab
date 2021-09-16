package com.itrex.java.lab.HomeWork2.Task3;

public class ExceptionHandler {

    public void OutOfMemoryErrorMetaspace(ExceptionProducer producer) {
        try {
            producer.OutOfMemoryErrorMetaspace();
        } catch (OutOfMemoryError ex) {
            Logger.getLogger().log(ex);
            System.out.println("Произошла ошибка. Информация в файле log.txt");
        }
    }
}

