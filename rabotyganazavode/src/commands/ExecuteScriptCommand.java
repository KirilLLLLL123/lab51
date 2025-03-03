package commands;

import input.InputManager;
import exceptions.CommandNotFoundException;
import exceptions.InvalidCommandArgumentsException;
import exceptions.OperationCancelledException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.HashSet;

// 1.Команда execute_script file_name
// 2.Открывает file_name, построчно читает команды и вызывает commandHandler.runLine(commandLine)
// 3.Если встречаем снова execute_script на тот же файл, это означало бы рекурсию
// 4.Чтобы избежать бесконечного цикла, используется Set<String> executingScripts
// 5.Если файл уже там, значит мы повторно вызываем тот же скрипт
// 6.В конце убираем filename из executingScripts

public class ExecuteScriptCommand implements Command {
    private CommandHandler commandHandler;
    private InputManager inputManager;
    private Set<String> executingScripts = new HashSet<>();

    public ExecuteScriptCommand() {
        // Пусто
    }

    public void setCommandHandler(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    public void setInputManager(InputManager inputManager) {
        this.inputManager = inputManager;
    }

    public void setExecutingScripts(Set<String> executingScripts) {
        this.executingScripts = executingScripts;
    }

    @Override
    public void execute(String filename) throws OperationCancelledException, InvalidCommandArgumentsException {
        if (filename.isEmpty()) {
            throw new InvalidCommandArgumentsException("Ошибка: необходимо указать имя файла скрипта.");
        }

        if (executingScripts.contains(filename)) {
            throw new InvalidCommandArgumentsException("Ошибка: обнаружен цикл вызова скриптов.");
        }

        executingScripts.add(filename);

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String commandLine;
            while ((commandLine = reader.readLine()) != null) {
                System.out.println("> " + commandLine);
                try {
                    commandHandler.runLine(commandLine);
                } catch (CommandNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при выполнении скрипта: " + e.getMessage());
        } finally {
            executingScripts.remove(filename);
        }
    }

    @Override
    public String toString() {
        return "execute_script";
    }
}
