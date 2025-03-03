package commands;

import service.WorkerService;
import exceptions.OperationCancelledException;
import exceptions.InvalidCommandArgumentsException;

//Выводит сумму всех зарплат
public class SumOfSalaryCommand implements Command {
    private WorkerService service;

    public SumOfSalaryCommand() {
        // Пусто
    }

    public void setWorkerService(WorkerService service) {
        this.service = service;
    }

    @Override
    public void execute(String args) throws OperationCancelledException, InvalidCommandArgumentsException {
        service.sumOfSalary();
    }

    @Override
    public String toString() {
        return "sum_of_salary";
    }
}
