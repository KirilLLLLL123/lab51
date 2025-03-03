package exceptions;

public class InvalidDataException extends Exception {
    public InvalidDataException(String message) {
        super(message);
    }
}
// Сообщает об ошибках в данных при создании объектов