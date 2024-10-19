import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the integer input
        int number = scanner.nextInt();

        String result = (number > 0) ? "Positive" : (number < 0) ? "Negative" : "Zero";

        System.out.println(result);


        // Use a ternary operator to check if the integer is positive, negative or zero
        // and print the corresponding message

    }
}