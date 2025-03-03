package input;

import exceptions.OperationCancelledException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Arrays;

//Отвечает за удобное взаимодействие с пользователем (ввод данных) и валидацию этого ввода

public class InputManager {
    private final Scanner scanner = new Scanner(System.in);

 // Метод getInput() во всём коде, когда нужно узнать у пользователя что-то (например,Введите имя: ),
 // мы вызываем String name = getInput("Введите имя: ")
    public String getInput(String prompt) throws OperationCancelledException {
        System.out.print(prompt);
        String input = scanner.nextLine().trim(); //trim() – убирает пробелы в начале и конце
        if ("cancel".equalsIgnoreCase(input)) {
            throw new OperationCancelledException("Операция отменена пользователем.");
        }
        return input;
    }


     // Метод getEnum() запрашивает ввод значения перечисления (enum) с проверкой на корректность
    public <T extends Enum<T>> T getEnum(Class<T> enumClass, String prompt) throws OperationCancelledException {
        while (true) {
            System.out.print(prompt);
            String input = getInput("").trim();
            if (input.isEmpty()) return null; // пустой ввод интерпретируется как null
            try {
                return Enum.valueOf(enumClass, input.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка! Введите одно из значений: " + Arrays.toString(enumClass.getEnumConstants()));
            }
        }
    }

      //  getDouble() запрашивает ввод значения типа double в заданном диапазоне
    public double getDouble(String prompt, double min, double max) throws OperationCancelledException {
        while (true) {
            try {
                String input = getInput(prompt);
                double value = Double.parseDouble(input);
                if (value < min || value > max) {
                    System.out.println("Ошибка: число должно быть в диапазоне (" + min + ", " + max + ").");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите корректное число.");
            }
        }
    }


    //getLong() запрашивает ввод целого числа
    public long getLong(String prompt) throws OperationCancelledException {
        while (true) {
            try {
                String input = getInput(prompt);
                return Long.parseLong(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите корректное целое число.");
            }
        }
    }


     // getLong() запрашивает ввод целого числа в заданном диапазоне
    public long getLong(String prompt, long min, long max) throws OperationCancelledException {
        while (true) {
            try {
                String input = getInput(prompt);
                long value = Long.parseLong(input);
                if (value < min || value > max) {
                    System.out.println("Ошибка: число должно быть в диапазоне (" + min + ", " + max + ").");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите корректное целое число.");
            }
        }
    }


     // getInt() запрашивает ввод целого числа int в заданном диапазоне

    public int getInt(String prompt, int min, int max) throws OperationCancelledException {
        while (true) {
            try {
                String input = getInput(prompt);
                int value = Integer.parseInt(input);
                if (value < min || value > max) {
                    System.out.println("Ошибка: число должно быть в диапазоне (" + min + ", " + max + ").");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите корректное целое число.");
            }
        }
    }


     //getDate() запрашивает ввод даты в формате YYYY-MM-DD
    public LocalDate getDate(String prompt) throws OperationCancelledException {
        while (true) {
            try {
                String input = getInput(prompt);
                return LocalDate.parse(input);
            } catch (Exception e) {
                System.out.println("Ошибка: введите дату в формате YYYY-MM-DD.");
            }
        }
    }
}
