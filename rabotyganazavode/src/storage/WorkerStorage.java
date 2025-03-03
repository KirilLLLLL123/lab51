package storage;

import model.Worker;
import java.util.List;

// Интерфейс для хранения и загрузки коллекции работников.
public interface WorkerStorage {
    List<Worker> loadWorkers() throws Exception;
    void saveWorkers(Iterable<Worker> workers) throws Exception;
}
