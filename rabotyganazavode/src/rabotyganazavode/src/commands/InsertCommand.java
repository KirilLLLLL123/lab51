package commands;

import input.InputManager;
import service.WorkerService;
import model.Worker;
import exceptions.OperationCancelledException;
import exceptions.InvalidCommandArgumentsException;


public class InsertCommand implements Command {
    private WorkerService service;
    private InputManager inputManager;

    public InsertCommand() {
        // Пустой конструктор
    }

    public void setWorkerService(WorkerService service) {
        this.service = service;
    }

    public void setInputManager(InputManager inputManager) {
        this.inputManager = inputManager;
    }

    @Override
    public void execute(String args) throws OperationCancelledException, InvalidCommandArgumentsException {
        try {
            long key = Long.parseLong(args.trim());
            Worker worker = WorkerCreator.createWorker(inputManager);
            service.insert(key, worker);
            System.out.println("Работник добавлен с ключом " + key);
        } catch (NumberFormatException e) {
            throw new InvalidCommandArgumentsException("Ключ должен быть числом.");
        }
    }

    @Override
    public String toString() {
        return "insert";
    }
}
