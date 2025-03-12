package commands;

import exceptions.InvalidCommandArgumentsException;
import exceptions.OperationCancelledException;

public interface Command {
    void execute(String args) throws OperationCancelledException, InvalidCommandArgumentsException;
}
