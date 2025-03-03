package commands;

import exceptions.InvalidCommandArgumentsException;
import exceptions.OperationCancelledException;
import java.util.Map;


 // Команда help выводит список доступных команд
 // Список команд определяется динамически на основе карты команд
public class HelpCommand implements Command {
    private Map<String, Command> commands; // Карта команд, которую устанавливает CommandHandler

    public HelpCommand() {
        // Пусто
    }

    public void setCommands(Map<String, Command> commands) {
        this.commands = commands;
    }

    public void execute(String args) throws OperationCancelledException, InvalidCommandArgumentsException {
        if (commands == null || commands.isEmpty()) {
            System.out.println("Список команд пуст.");
            return;
        }
        System.out.println("Доступные команды: ");

        // Динамически выводим имена всех команд
        for (String commandName : commands.keySet()) {
            System.out.println("- " + commandName);
        }
    }

    public String toString() {
        return "help";
    }
}
