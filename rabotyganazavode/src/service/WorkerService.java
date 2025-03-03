package service;

import model.Position;
import model.Worker;
import storage.WorkerStorage;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


   // Класс WorkerService для управления коллекцией работников.

public class WorkerService {
    private final WorkerStorage storage;
    private final Map<Long, Worker> workers = new HashMap<>(); // место, где именно храняться работники в памяти

    public WorkerService(WorkerStorage storage) {
        this.storage = storage;
    }

    public void loadWorkers() {
        try {
            List<Worker> list = storage.loadWorkers();
            for (Worker w : list) {
                workers.put(w.getId(), w);
            }
        } catch (Exception e) {
            System.out.println("Ошибка загрузки коллекции: " + e.getMessage());
        }
        // Вызывает storage.loadWorkers(), получая список объектов Worker из CSV или иного источника.
        // Заполняет Map<Long, Worker> – ключом берёт w.getId()
    }

    public void saveWorkers() {
        try {
            storage.saveWorkers(workers.values());
        } catch (Exception e) {
            System.out.println("Ошибка сохранения коллекции: " + e.getMessage());
        }
        // Передаёт workers.values() (все объекты) в storage.saveWorkers()
        // Так данные сохраняются обратно в файл (CSV)
    }

    public void showWorkers() {
        workers.values().forEach(System.out::println);
        // Проходит по всем работникам (то есть Collection<Worker> из workers.values()) и печатает их toString()
        // Так пользователь видит все элементы
    }

    public void insert(long key, Worker worker) {
        workers.put(key, worker);
        // Добавляет в Map новую пару (key, worker)
    }

    public void update(long id, Worker worker) {
        if (workers.containsKey(id)) {
            workers.put(id, worker);
        } else {
            System.out.println("Работник с таким id не найден.");
        }
        // Проверяет, есть ли работник под ключом id. Если есть – заменяет. Иначе пишет, что не найден
    }

    public void removeKey(long key) {
        workers.remove(key);
        // Удаляет работника по ключу
    }

    public boolean containsWorker(long id) {
        return workers.containsKey(id);
        // Проверяет, есть ли такой ключ
    }

    public void removeLowerKey(Long key) {
        if (workers.isEmpty()) {
            System.out.println("Коллекция пуста, нечего удалять.");
            return;
        }

        int initialSize = workers.size();
        workers.entrySet().removeIf(entry -> entry.getKey() < key);
        int removedCount = initialSize - workers.size();

        System.out.println("Удалено элементов: " + removedCount);
        // Удаляет все записи, у которых ключ < key
    }


    public void clear() {
        workers.clear();
        // очистка коллекции - пусто
    }

    public void replaceIfGreater(long key, Worker newWorker) {
        Worker existing = workers.get(key);
        if (existing != null && newWorker.getSalary() > existing.getSalary()) {
            workers.put(key, newWorker);
        }
        // Сравнивает зарплаты. Если у нового объекта newWorker зарплата больше, чем у старого, заменяет
        // Если старого объекта нет, ничего не делает. Если зарплата меньше или равна, тоже не меняет
    }

    public void sumOfSalary() {
        double sum = workers.values().stream().mapToDouble(Worker::getSalary).sum();
        System.out.println("Сумма всех зарплат: " + sum);
        // Складывает все зарплаты salary, выводит результат
    }

    public void countGreaterThanPosition(Position position) {
        long count = workers.values().stream()
                .filter(worker -> worker.getPosition() != null && worker.getPosition().ordinal() > position.ordinal())
                .count();
        System.out.println("Количество работников с должностью выше " + position + ": " + count);
        // Считает, сколько работников имеют position.ordinal() строго больше заданного
        // Печатает результат (Количество работников с должностью выше CLEANER: 2)
    }

    public void printFieldAscendingSalary() {
        workers.values().stream()
                .sorted((w1, w2) -> Double.compare(w1.getSalary(), w2.getSalary()))
                .forEach(worker -> System.out.println(worker.getSalary()));
        // Берёт все объекты из workers.values(), сортирует их по возрастанию зарплаты (salary), и печатает только зарплаты
        // Используется командой print_field_ascending_salary
    }

    public void printInfo() {
        System.out.println("Количество работников: " + workers.size());
        System.out.println("Тип коллекции: " + workers.getClass().getName());
        // Сколько сейчас объектов в workers
        // Какой тип коллекции используется
    }
    public boolean isCollectionEmpty() {
        return workers.isEmpty();
        // Есть ли работники???
    }
}
