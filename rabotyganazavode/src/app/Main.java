package app;

import storage.WorkerStorage;
import storage.CsvWorkerStorage;
import storage.JsonWorkerStorage;
import storage.XmlWorkerStorage;
import service.WorkerService;
import commands.CommandHandler;
import input.InputManager;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Цикл для ввода допустимого формата данных
        String format;
        while (true) {
            System.out.println("Выберите формат данных (csv, json, xml):");
            format = scanner.nextLine().trim().toLowerCase();
            if (format.equals("csv") || format.equals("json") || format.equals("xml")) {
                break;
            }
            System.out.println("Неподдерживаемый формат. Пожалуйста, введите csv, json или xml.");
        }

        System.out.print("Введите имя файла (с расширением): ");
        String filename = scanner.nextLine().trim();

        WorkerStorage storage;
        switch (format) {
            case "csv":
                storage = new CsvWorkerStorage(filename);
                break;
            case "json":
                storage = new JsonWorkerStorage(filename);
                break;
            case "xml":
                storage = new XmlWorkerStorage(filename);
                break;
            default:
                // Этот блок не будет выполнен, так как цикл гарантирует корректный формат
                System.out.println("Неподдерживаемый формат.");
                return;
        }

        WorkerService service = new WorkerService(storage);
        InputManager inputManager = new InputManager();
        CommandHandler handler = new CommandHandler(service, inputManager);

        // Попытка загрузить данные из файла
        try {
            service.loadWorkers();
        } catch (Exception e) {
            System.out.println("Ошибка загрузки данных: " + e.getMessage());
        }

        // Запуск интерактивного режима
        handler.run();
    }
}
