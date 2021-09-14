package main.com.itrex.java.lab.HomeWork2.Task4;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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

    void log(String message, List<Integer> list, Integer value) {
        String filename = CreatePath.getPath(Logger.class)+LOG_NAME;
        try (PrintWriter out = new PrintWriter(new FileWriter(filename, true))) {
            out.println("Time and Date:  "+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))+ " "+message +" List: "+ list +" Value: " + value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
