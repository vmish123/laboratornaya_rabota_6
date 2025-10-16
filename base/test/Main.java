package lab.base.test;

import lab.geometry.geometry2d.*;
import lab.geometry.geometry3d.Cylinder;

import lab.Exceptions.*;

import java.util.logging.*;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName()); // Создание логгера
    static {
        ConsoleHandler Handler = new ConsoleHandler();
        Handler.setFormatter(new SimpleFormatter()); // Создание хэндлера
        Handler.setLevel(Level.FINE);
        LOGGER.addHandler(Handler);
        LOGGER.setLevel(Level.FINE);
        LOGGER.setUseParentHandlers(false);
    }

    public static void main(String[] args) {

        // Обработка исключения NegativeNumberException
        try {
            Figure circle = new Circle(10);
            LOGGER.fine("Circle created successfully.");
            circle.Show();
        } catch (NegativeNumberException exc) {
            LOGGER.fine("Negative number exception");
            System.out.println("Error: " + exc.getMessage());
        }
        try {
            Figure rectangle = new Rectangle(9, 1);
            LOGGER.fine("Rectangle created successfully.");
            rectangle.Show();
        } catch (NegativeNumberException exc) {
            LOGGER.fine("Negative number exception");
            System.out.println("Error: " + exc.getMessage());
        }
        try {
            Figure base = new Rectangle(10, 10);
            LOGGER.fine("Base created successfully.");
            Cylinder cylinder1 = new Cylinder(base, 10);
            LOGGER.fine("Cylinder created successfully.");
            System.out.println(cylinder1.Volume());
        } catch (NegativeNumberException exc) {
            LOGGER.fine("Negative number exception");
            System.out.println("Error: " + exc.getMessage());
        }

        // Обработка исключения InvalidFigureException
        try {
            Cylinder cylinder2 = new Cylinder("rrrr", 10);
            LOGGER.fine("Cylinder created successfully.");
            System.out.println(cylinder2.Volume());
        } catch (InvalidFigureException | NegativeNumberException exc) {
            LOGGER.fine("Invalid figure exception");
            System.out.println("Error: " + exc.getMessage());
        }
    }
}
