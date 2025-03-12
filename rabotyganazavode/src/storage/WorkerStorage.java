package storage;

import model.Worker;
import java.util.List;

public interface WorkerStorage {
    List<Worker> loadWorkers() throws Exception;
    void saveWorkers(Iterable<Worker> workers) throws Exception;
}
