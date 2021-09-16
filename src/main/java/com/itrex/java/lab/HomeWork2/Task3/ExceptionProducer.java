package com.itrex.java.lab.HomeWork2.Task3;

import java.util.Base64;


public class ExceptionProducer {
    /*
    код заставляет загрузчик классов загружать множество различных классов.
    Это достигается путем взятия скомпилированного байт-кода класса mypackage.Myclass0 и настройки на итеративное создание
    новых классов путем изменения имени класса и регулировки длины имени класса:
     */
    public void OutOfMemoryErrorMetaspace() {
        String clazzBase64 = "yv66vgAAADcADAEAEm15cGFja2FnZS9NeWNsYXNzMAcAAQEAEGphdmEvbGFuZy9PYmplY3QHAAMBAApTb3VyY2VGaWxlAQANTXljbGFzczAuamF2YQEABjxpbml0PgEAAygpVgwABwAICgAEAAkBAARDb2RlACEAAgAEAAAAAAABAAEABwAIAAEACwAAABEAAQABAAAABSq3AAqxAAAAAAABAAUAAAACAAY=";

        byte[] compiledClazz = Base64.getDecoder().decode(clazzBase64);
        int classNameLength = Integer.valueOf(compiledClazz[12]);

        MyClassLoader myClassLoader = new MyClassLoader(Thread.currentThread().getContextClassLoader());

        for (int i = 0; ; i++) {
            byte[] bytes = String.valueOf(i).getBytes();
            byte[] bytecode = new byte[compiledClazz.length + bytes.length - 1];
            System.arraycopy(compiledClazz, 0, bytecode, 0, 30);
            bytecode[12] = (byte) (classNameLength + bytes.length - 1 & 0xFF);

            System.arraycopy(bytes, 0, bytecode, 30, bytes.length);
            System.arraycopy(compiledClazz, 31, bytecode, 30 + bytes.length, compiledClazz.length - 31);

            String classname = "mypackage.Myclass" + i;
            /*
            Создание нового класса.
            bytecode - байт-код класса (образ в памяти обычного .class-файла) в виде массива byte[].
            classname - имя класса mypackage.Myclass0
            ClassLoader.defineClass, который «превратит» его в готовый класс – объект типа Class.
             */
            Class c = myClassLoader.getClass(classname, bytecode);
        }

    }
}






