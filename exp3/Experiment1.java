import java.util.*;

public class Experiment1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number to calculate its square root:");

        try {
            String input = scanner.nextLine();
            double number = Double.parseDouble(input);
            if (number < 0) {
                throw new IllegalArgumentException("Square root of a negative number is not real.");
            }

            double squareRoot = Math.sqrt(number);
            System.out.println("The square root of " + number + " is: " + squareRoot);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid numeric value.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
