package commands;

import service.WorkerService;
import exceptions.OperationCancelledException;
import exceptions.InvalidCommandArgumentsException;

 //Просто вызывает service.printFieldAscendingSalary(),
 //который сортирует работников по зарплате и выводит зарплаты в порядке возрастания

public class PrintFieldAscendingSalaryCommand implements Command {
    private WorkerService service;

    public PrintFieldAscendingSalaryCommand() {
        // Пусто
    }

    public void setWorkerService(WorkerService service) {
        this.service = service;
    }

    @Override
    public void execute(String args) throws OperationCancelledException, InvalidCommandArgumentsException {
        service.printFieldAscendingSalary();
    }

    @Override
    public String toString() {
        return "print_field_ascending_salary";
    }
}
