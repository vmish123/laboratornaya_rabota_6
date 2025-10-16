package lab.Exceptions;

// Исключение InvalidFigureException при некорректном вводе названия основания
public class InvalidFigureException extends Exception {
    public InvalidFigureException(String figureName) {
        super("Invalid figure name: " + figureName + ". Must be '(C/c)ircle' or '(R/r)ectangle'");
    }
}
