import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner ler = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Room number: ");
        int number = ler.nextInt();
        System.out.println("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(ler.next());
        System.out.println("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(ler.next());

        if(!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: check-out date must be after chek-in date");
        }
        else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.println("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(ler.next());
            System.out.println("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(ler.next());

            Date now = new Date();
            if(checkIn.before(now) || checkOut.before(now)) {
                System.out.println("Error in reservation: Reservation dates for update must be future date");
            }
            else if(!checkOut.after(checkIn)) {
                System.out.println("Error in reservation: check-out date must be after chek-in date");
            }
            else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation: " + reservation);
            }

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        }
    }
}