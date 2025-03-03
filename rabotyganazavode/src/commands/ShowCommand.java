package commands;

import service.WorkerService;
import exceptions.InvalidCommandArgumentsException;
import exceptions.OperationCancelledException;

// Вызывает service.showWorkers(), который печатает все объекты Worker из коллекции
public class ShowCommand implements Command {
    private WorkerService service;

    public ShowCommand() {
        // Пусто
    }

    public void setWorkerService(WorkerService service) {
        this.service = service;
    }

    @Override
    public void execute(String args) throws OperationCancelledException, InvalidCommandArgumentsException {
        if (service != null) {
            service.showWorkers();
        } else {
            System.out.println("WorkerService не инициализирован.");
        }
    }

    @Override
    public String toString() {
        return "show";
    }
}
