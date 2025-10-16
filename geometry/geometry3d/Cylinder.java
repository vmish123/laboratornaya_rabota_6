package lab.geometry.geometry3d;
import lab.geometry.geometry2d.*;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

import lab.Exceptions.*;

public class Cylinder {

    private static final Logger LOGGER = Logger.getLogger(Cylinder.class.getName()); // Создание логгера
    static {
        try {
            FileHandler fileHandler = new FileHandler("cylinder.log", true); // Создание хэндлера
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
            LOGGER.setLevel(Level.FINEST);
            LOGGER.setUseParentHandlers(false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected Figure base;
    protected double height;

    public Cylinder(String figure, double height) throws InvalidFigureException, NegativeNumberException {
        Scanner sc = new Scanner(System.in);
        // Использование исключения NegativeNumberException
        if (height <= 0) {
            throw new NegativeNumberException(height);
        }
        switch(figure) {
            case "Circle", "circle":
                System.out.println("Enter base radius: ");
                double rad = sc.nextDouble();
                base = new Circle(rad);
                break;
            case "Rectangle", "rectangle":
                System.out.println("Enter base side A: ");
                double sidea = sc.nextDouble();
                System.out.println("Enter base side B: ");
                double sideb = sc.nextDouble();
                base = new Rectangle(sidea, sideb);
                break;
            default:
                // Использование исключения InvalidFigureException
                throw new InvalidFigureException(figure);
        }
        this.height = height;
        LOGGER.finest("Created object Cylinder with height " + this.height);
    }

    public Cylinder(Figure base, double height) throws NegativeNumberException {
        // Использование исключения NegativeNumberException
        if (height <= 0) {
            throw new NegativeNumberException(height);
        }
        this.base = base;
        this.height = height;
        LOGGER.finest("Created object Cylinder with height " + this.height);
    }

    public Cylinder(Figure base) {
        this.base = base;
        System.out.println("Height set to default (1)");
        height = 1;
        LOGGER.finest("Created object Cylinder with height " + this.height);
    }

    public double Volume() {
        LOGGER.finest("The volume of the cylinder has been calculated and equal to " + base.Area()*this.height);
        return base.Area() * height;
    }
}