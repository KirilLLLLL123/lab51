package commands;

import java.util.LinkedList;
import exceptions.OperationCancelledException;
import exceptions.InvalidCommandArgumentsException;

public class HistoryCommand implements Command {
    private LinkedList<String> history;

    public HistoryCommand() {
        // Пустой конструктор
    }

    public void setHistory(LinkedList<String> history) {
        this.history = history;
    }

    @Override
    public void execute(String args) throws OperationCancelledException, InvalidCommandArgumentsException {
        System.out.println("Последние команды:");
        for (String cmd : history) {
            System.out.println(cmd);
        }
    }

    @Override
    public String toString() {
        return "history";
    }
}
