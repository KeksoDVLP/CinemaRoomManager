import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Getting the input from the user
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();





        // Write your condition here using the ternary operator
        String result = (number % 3 == 0 && number % 5 ==0) ? "FizzBuzz" :
                        (number % 3 == 0) ? "Buzz" :
                        (number % 5 == 0) ? "Fizz" :
                        Integer.toString(number);







        System.out.println(result);
    }
}