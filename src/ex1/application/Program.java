package ex1.application;

import ex1.model.entities.Account;
import ex1.model.exceptions.WithdrawException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter account data");
        try {
            System.out.print("Number: ");
            Integer accountNumber = sc.nextInt();
            sc.nextLine();
            System.out.print("Holder: ");
            String accountHolder = sc.nextLine();
            System.out.print("Initial balance: ");
            Double initialBalance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            Double withdrawLimit = sc.nextDouble();
            Account account = new Account(accountNumber, accountHolder, initialBalance, withdrawLimit);
            System.out.println();

            System.out.print("Enter amount for withdraw: ");
            account.withdraw(sc.nextDouble());
            System.out.print(account);

            sc.close();
        } catch (WithdrawException error) {
            System.out.println("Withdraw error: " + error.getMessage());
        } catch (Exception error) {
            System.out.println("Unexpected error");
        }
    }
}
