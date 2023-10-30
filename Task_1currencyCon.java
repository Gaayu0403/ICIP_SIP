
import java.util.Scanner;

public class Task_1currencyCon 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Currency Converter");
        System.out.println("1. USD to EUR");
        System.out.println("2. EUR to USD");
        System.out.print("Choose an option (1/2): ");
        int option = scanner.nextInt();

        if (option == 1) 
        {
            System.out.print("Enter the amount in USD: ");
            double usdAmount = scanner.nextDouble();
            double exchangeRate = 0.85; // 1 USD to EUR
            double eurAmount = usdAmount * exchangeRate;
            System.out.println("Converted amount: " + eurAmount + " EUR");
        } 
        else if (option == 2) 
        {
            System.out.print("Enter the amount in EUR: ");
            double eurAmount = scanner.nextDouble();
            double exchangeRate = 1.18; // 1 EUR to USD
            double usdAmount = eurAmount * exchangeRate;
            System.out.println("Converted amount: " + usdAmount + " USD");
        } 
        else {
            System.out.println("Invalid option. Please choose 1 or 2.");
        }
        
        scanner.close();
    }
}
