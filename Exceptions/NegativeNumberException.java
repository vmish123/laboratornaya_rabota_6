package lab.Exceptions;

// Исключение NegativeNumberException при некорректном вводе числовых значений
public class NegativeNumberException extends Exception {
    public NegativeNumberException(double number) {
        super("Incorrect value: " + number + ". Must be a positive number more than zero.");
    }
}