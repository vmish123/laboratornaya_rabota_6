package lab.geometry.geometry2d;
import lab.Exceptions.NegativeNumberException;

import java.io.IOException;
import java.util.logging.*;

public class Rectangle implements Figure {

    private static final Logger LOGGER = Logger.getLogger("lab.geometry.geometry2d"); // Создание логгера (название общее для пакета)

    static {
        try {
            if(LOGGER.getHandlers().length == 0) { // Проверка на существование хэндлера
                FileHandler fileHandler = new FileHandler("figures.log", true); // Создание хэндлера
                fileHandler.setFormatter(new XMLFormatter());
                LOGGER.addHandler(fileHandler);
            }
            LOGGER.setUseParentHandlers(false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        LOGGER.setLevel(Level.INFO);
    }

    private double sidea, sideb;
    
    public Rectangle(){
        System.out.println("Rectangle's sides set to default (1)");
        sidea = 1.0;
        sideb = 1.0;
        LOGGER.info("Created object Rectangle with sides " + sidea + " and " + sideb);
    }

    public Rectangle(double sidea, double sideb) throws NegativeNumberException {
        // Использование исключений NegativeNumberException
        if (sidea <= 0) {
            throw new NegativeNumberException(sidea);
        }
        if (sideb <= 0) {
            throw new NegativeNumberException(sideb);
        }
        System.out.println("Rectangle's side A set to: " + sidea);
        System.out.println("Rectangle's side B set to: " + sideb);
        this.sidea = sidea;
        this.sideb = sideb;
        LOGGER.info("Created object Rectangle with sides " + this.sidea + " and " + this.sideb);
    }

    @Override
    public double Area() {
        LOGGER.info("The area of the rectangle has been calculated and equal to " + this.sidea*this.sideb);
        return sidea * sideb;
    }

    @Override
    public void Show() {
        System.out.println("> Rectangle's side A: " + sidea);
        System.out.println("> Rectangle's side B: " + sideb);
        System.out.println("> Rectangle's area: " + Area());
        System.out.println("> Rectangle's perimeter: " + (2 * sidea + 2 * sideb));
        LOGGER.info("Information about the rectangle was output to the console");
    }
}
