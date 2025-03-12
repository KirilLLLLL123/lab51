package commands;

import service.WorkerService;
import input.InputManager;
import model.Worker;
import exceptions.OperationCancelledException;
import exceptions.InvalidCommandArgumentsException;

public class ReplaceIfGreaterCommand implements Command {
    private WorkerService service;
    private InputManager inputManager;

    public ReplaceIfGreaterCommand() {
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
            if (!service.containsWorker(key)) {
                System.out.println("Работник с ключом " + key + " не найден.");
                return;
            }
            Worker worker = WorkerCreator.createWorker(inputManager);
            service.replaceIfGreater(key, worker);
            System.out.println("Команда выполнена.");
        } catch (NumberFormatException e) {
            throw new InvalidCommandArgumentsException("Ключ должен быть числом.");
        }
    }

    @Override
    public String toString() {
        return "replace_if_greater";
    }
}
