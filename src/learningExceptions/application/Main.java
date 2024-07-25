package learningExceptions.application;

import learningExceptions.model.entities.Reservation;
import learningExceptions.model.exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Room number: ");
            Integer roomNumber = sc.nextInt();
            sc.nextLine();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            LocalDate checkIn = LocalDate.parse(sc.nextLine(), formatter);
            System.out.print("Check-out date (dd/MM/yyyy): ");
            LocalDate checkOut = LocalDate.parse(sc.nextLine(), formatter);
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.print(reservation);
            System.out.println();

            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = LocalDate.parse(sc.nextLine(), formatter);
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = LocalDate.parse(sc.nextLine(), formatter);
            reservation.updateDates(checkIn, checkOut);
            System.out.print(reservation);
            sc.close();
        } catch (DomainException error) {
            System.out.println("Error in reservation: " + error.getMessage());
        } catch (Exception error) {
            System.out.println("Unexpected error");
        }

    }
}