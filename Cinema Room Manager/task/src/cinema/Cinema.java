package cinema;
import java.util.Scanner;

public class Cinema {
    private char[][] seats;
    private int rows;
    private int seatsPerRow;
    private int totalIncome;
    private int currentIncome;
    private int purchaseTickets;

    public Cinema(int rows, int seatsPerRow) {
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
        this.seats = new char[rows][seatsPerRow];
        this.totalIncome = calculateTotalIncome();
        this.currentIncome = 0;
        this.purchaseTickets = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsPerRow; j++) {
                seats[i][j] = 'S'; //reprezentuje dostupne sedadla
            }


        }


    }

    private int calculateTotalIncome() {
        int income = 0;
        for (int i = 0; i < rows; i++) {
            if (i < rows / 2) {
                income += seatsPerRow * 10;  // prva polka rows ticket price 10$
            } else {
                income += seatsPerRow * 8;  // druha polka rows ticket price 8$
            }
        }

        return income;
    }

    public void showSeats() {
        System.out.println("\nCinema:");
        System.out.print(" ");
        for (int i = 1; i <= seatsPerRow; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < seatsPerRow; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }


    }

    public void buyTicket(Scanner scanner) {
        int row, seat;
        while (true) {
            System.out.println("\nEnter a row number:");
            row = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            seat = scanner.nextInt();

            if (row < 1|| row > rows || seat < 1 || seat > seatsPerRow) {
                System.out.println("Wrong input! Please enter valid seat coordinates.");

            }else if (seats[row - 1][seat - 1] == 'B') {
                System.out.println("That ticket has already been purchased!");

            }else {
                break;
            }

        }

        int price = (row <= rows / 2) ? 10 : 8;
        System.out.println("Ticket price: $" + price);
        seats[row - 1][seat - 1] = 'B';  // B reprezentuje booknute sedadlo
        currentIncome += price;
        purchaseTickets++;


    }

    public void showStatistics() {
        double percentage = (double) purchaseTickets / (rows * seatsPerRow) * 100;
        System.out.printf("Number of purchased tickets: %d%n", purchaseTickets);
        System.out.printf("Percentage: %.2f%%%n", percentage);
        System.out.printf("Current income: $%d%n", currentIncome);
        System.out.printf("Total income: $%d%n", totalIncome);       
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsPerRow = scanner.nextInt();
        
        Cinema cinema = new Cinema(rows, seatsPerRow);
        
        while (true) {
            System.out.println("\n1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    cinema.showSeats();
                    break;
                case 2:
                    cinema.buyTicket(scanner);
                    break;
                case 3:
                    cinema.showStatistics();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }



}




