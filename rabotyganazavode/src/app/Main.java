package app;

import commands.CommandHandler;
import input.InputManager;
import service.WorkerService;
import storage.CsvWorkerStorage;
import storage.WorkerStorage;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Ошибка: укажите имя CSV-файла в аргументах командной строки.");
            return;
        }
        String filename = args[0];

        WorkerStorage storage = new CsvWorkerStorage(filename);
        WorkerService service = new WorkerService(storage);
        InputManager inputManager = new InputManager();
        CommandHandler handler = new CommandHandler(service, inputManager);

        // Загружаем коллекцию из файла
        service.loadWorkers();

        // Запускаем интерактивный режим
        handler.run();
    }
}

