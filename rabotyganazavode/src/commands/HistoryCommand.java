package commands;

import java.util.LinkedList;
import exceptions.OperationCancelledException;
import exceptions.InvalidCommandArgumentsException;

//HistoryCommand - показывает последние 9 введённых команд

public class HistoryCommand implements Command {
    private LinkedList<String> history;

    public HistoryCommand() {
        // Пусто
    }

    public void setHistory(LinkedList<String> history) {
        this.history = history;
    }


    public void execute(String args) throws OperationCancelledException, InvalidCommandArgumentsException {
        System.out.println("Последние команды:");
        for (String cmd : history) {
            System.out.println(cmd);
        }
    }


    public String toString() {
        return "history";
    }
}
