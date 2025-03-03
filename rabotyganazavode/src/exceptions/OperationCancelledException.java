package exceptions;


public class OperationCancelledException extends Exception {
    public OperationCancelledException(String message) {
        super(message);
    }
}
// Возникает, когда пользователь вводит команду cancel, прерывая ввод данных.