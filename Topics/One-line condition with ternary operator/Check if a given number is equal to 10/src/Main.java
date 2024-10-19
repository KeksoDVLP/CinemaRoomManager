import java.util.Scanner;  // Required to read user input

public class Main {
    public static void main(String[] args) {

        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Read input
        int number = scanner.nextInt();

        String result = (number == 10) ? "Equal" : "Not Equal";

        System.out.println(result);

        // Put your code with ternary operator here
    }
}