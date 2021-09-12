package Task3;

public class ExceptionHandler {

    public void OutOfMemoryErrorMetaspace(ExceptionProducer producer) {
        while (true) {
            try {
                producer.OutOfMemoryErrorMetaspace();
            } catch (OutOfMemoryError ex) {
                Logger.getLogger().log(ex);
                System.out.println("Произошла ошибка. Информация в файле log.txt");
            }
        }
    }
}
