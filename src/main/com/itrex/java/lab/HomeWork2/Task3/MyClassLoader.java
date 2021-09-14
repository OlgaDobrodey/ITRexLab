package main.com.itrex.java.lab.HomeWork2.Task3;


class MyClassLoader extends ClassLoader {
    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    public Class<?> getClass(String name, byte[] code) {
        return defineClass(name, code, 0, code.length);
    }
}
