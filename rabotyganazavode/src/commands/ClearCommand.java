package commands;

import service.WorkerService;
import exceptions.OperationCancelledException;
import exceptions.InvalidCommandArgumentsException;

public class ClearCommand implements Command {
    private WorkerService service;

    public ClearCommand() {
        // Пустой конструктор
    }

    public void setWorkerService(WorkerService service) {
        this.service = service;
    }

    @Override
    public void execute(String args) throws OperationCancelledException, InvalidCommandArgumentsException {
        service.clear();
        System.out.println("Коллекция очищена.");
    }

    @Override
    public String toString() {
        return "clear";
    }
}
