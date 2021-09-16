package com.itrex.java.lab.HomeWork2.Task3;

import com.itrex.java.lab.HomeWork2.Task4.CreatePath;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Logger {

    private static volatile Logger logger;

    private Logger() {

    }

    static Logger getLogger() {
        Logger result = logger;
        if (result == null) {
            synchronized (Logger.class) {
                result = logger;
                if (result == null) {
                    result = logger = new Logger();
                }
            }
        }
        return result;
    }

    private static final String LOG_NAME = "log.txt";


    void log(Throwable throwable) {
        String filename = CreatePath.getPath(Logger.class)+LOG_NAME;
        try (PrintWriter out = new PrintWriter(new FileWriter(filename, true))) {
            out.println("Time and Date:  "+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
                    + " "+ throwable.getClass().getName()
                    + ":"+ throwable.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
