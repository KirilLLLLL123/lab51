package exceptions;

public class StorageAccessException extends Exception {
    public StorageAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
// Используется в случае ошибок доступа к файлам