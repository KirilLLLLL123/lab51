package exceptions;


public class CSVFormatException extends Exception {
    public CSVFormatException(String message) {
        super(message);
    }
}
// Сообщает о проблемах при чтении/записи CSV-файла

