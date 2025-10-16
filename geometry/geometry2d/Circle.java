package lab.geometry.geometry2d;
import lab.Exceptions.NegativeNumberException;

import java.io.IOException;
import java.util.logging.*;

public class Circle implements Figure {

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
        LOGGER.setLevel(Level.SEVERE);
    }

    private double rad;
    private static double pi = 3.141592;

    public Circle(){
        System.out.println("Radius set to default (1)");
        rad = 1.0;
        LOGGER.severe("Created object Circle with radius set to " + rad);
    }

    public Circle(double rad) throws NegativeNumberException {
        // Использование исключения NegativeNumberException
        if (rad <= 0){
            throw new NegativeNumberException(rad);
        }
        System.out.println("Radius set to " + rad);
        this.rad = rad;
        LOGGER.severe("Created object Circle with radius set to " + rad);
    }

    @Override
    public double Area() {
        LOGGER.severe("The area of the circle has been calculated and equal to " + pi*Math.pow(rad, 2));
        return pi * Math.pow(rad, 2);
    }

    @Override
    public void Show() {
        System.out.println("> Circle's radius: " + rad);
        System.out.println("> Circle's area: " + Area());
        System.out.println("> Circle's length: " + 2*pi*rad);
        LOGGER.severe("Information about the circle was output to the console.");
    }
}