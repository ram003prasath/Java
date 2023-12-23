import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

class QuadraticEquationGenerator<T extends Number> {
    private T x;

    public QuadraticEquationGenerator(T x) {
        this.x = x;
    }

    public void generateEquations() {
        Random random = new Random();

        // Generate two random coefficients for each equation
        double a1 = random.nextDouble();
        double b1 = random.nextDouble();
        double c1 = random.nextDouble();

        double a2 = random.nextDouble();
        double b2 = random.nextDouble();
        double c2 = random.nextDouble();

        // Display the generated quadratic equations
        System.out.println("Quadratic Equation 1: " + a1 + "x^2 + " + b1 + "x + " + c1);
        System.out.println("Quadratic Equation 2: " + a2 + "x^2 + " + b2 + "x + " + c2);

        // Evaluate the equations for the given 'x'
        double result1 = evaluateEquation(a1, b1, c1, x);
        double result2 = evaluateEquation(a2, b2, c2, x);

        System.out.println("Result for x = " + x + " in Equation 1: " + result1);
        System.out.println("Result for x = " + x + " in Equation 2: " + result2);
    }

    private double evaluateEquation(double a, double b, double c, T x) {
        // Evaluate the quadratic equation for the given 'x'
        double xValue = x instanceof Integer ? ((Integer) x).doubleValue() : (Double) x;
        return a * Math.pow(xValue, 2) + b * xValue + c;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a value for x: ");
            Object x;

            if (scanner.hasNextInt()) {
                x = scanner.nextInt();
            } else if (scanner.hasNextDouble()) {
                x = scanner.nextDouble();
            } else {
                throw new InvalidInputException("Invalid input. Please enter a valid integer or double for x.");
            }

            QuadraticEquationGenerator<Object> equationGenerator = new QuadraticEquationGenerator<>(x);
            equationGenerator.generateEquations();
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter a valid integer or double for x.");
        } finally {
            scanner.close();
        }
    }
}
