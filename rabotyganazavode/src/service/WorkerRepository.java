package service;

import model.Worker;
import java.util.HashMap;
import java.util.Map;


 // Отвечает за хранение работников в памяти
public class WorkerRepository {
    private final Map<Long, Worker> workers = new HashMap<>();

    public Map<Long, Worker> getWorkers() {
        return workers;
        // вернуть всю карту работников
    }

    public boolean containsWorker(long id) {
        return workers.containsKey(id);
        // проверить, есть ли работник в Map
    }

    public boolean isEmpty() {
        return workers.isEmpty();
        // проверить, пуста ли коллекция
    }

    public void saveWorker(Long key, Worker worker) {
        workers.put(key, worker);
        // сохранить (добавить или заменить) работника по ключу
    }

    public void removeWorker(Long key) {
        workers.remove(key);
        // удалить работника по ключу
    }
}
