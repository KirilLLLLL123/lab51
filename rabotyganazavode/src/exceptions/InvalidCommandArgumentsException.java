package exceptions;

public class InvalidCommandArgumentsException extends Exception {
    public InvalidCommandArgumentsException(String message) {
        super(message);
    }
}
// Сигнализирует, что у команды некорректные аргументы