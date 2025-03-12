package commands;

import service.WorkerService;
import exceptions.OperationCancelledException;
import exceptions.InvalidCommandArgumentsException;

 // Команда print_field_ascending_salary выводит зарплаты работников в порядке возрастания.
public class PrintFieldAscendingSalaryCommand implements Command {
    private WorkerService service;

    public PrintFieldAscendingSalaryCommand() {
        // Пустой конструктор
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
