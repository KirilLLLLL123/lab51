package commands;

import exceptions.InvalidCommandArgumentsException;
import exceptions.OperationCancelledException;

         //Command – это общий контракт, которому следуют все команды
         //Каждая команда должна уметь выполнить некое действие через метод execute(String args)
public interface Command {
    void execute(String args) throws OperationCancelledException, InvalidCommandArgumentsException;
}
        // OperationCancelledException - если пользователь прервал ввод
        // InvalidCommandArgumentsException - если переданы неверные аргументы