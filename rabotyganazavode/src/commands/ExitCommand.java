package commands;

import exceptions.OperationCancelledException;
import exceptions.InvalidCommandArgumentsException;

//Завершение работы программы
public class ExitCommand implements Command {
    public ExitCommand() {
        // Пусто
    }

    @Override
    public void execute(String args) throws OperationCancelledException, InvalidCommandArgumentsException {
        System.out.println("Завершение работы программы.");
        System.exit(0);
    }

    @Override
    public String toString() {
        return "exit";
    }
}
