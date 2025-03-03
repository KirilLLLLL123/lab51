package exceptions;


public class CommandNotFoundException extends Exception {
    public CommandNotFoundException(String message) {
        super(message);
    }
}
// Выбрасывается, когда пользователь вводит неизвестную команду.