package exceptions;


public class CommandPreconditionException extends Exception {

    public CommandPreconditionException(String message) {
        super(message);
    }
}
//Выбрасывается, когда для выполнения команды не соблюдены некоторые предварительные условия
