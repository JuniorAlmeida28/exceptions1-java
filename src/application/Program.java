package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {
    public static void main(String[] args) {

        Scanner en = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Número do quarto: ");
            int roomNumber = en.nextInt();
            System.out.print("Data do check-in (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(en.next());
            System.out.print("Data do check-out (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(en.next());

            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reserva: " + reservation);

            System.out.println();
            System.out.println("Informe os dados para atualizar a reserva:");
            System.out.print("Data do check-in (dd/MM/yyyy): ");
            checkIn = sdf.parse(en.next());
            System.out.print("Data do check-out (dd/MM/yyyy): ");
            checkOut = sdf.parse(en.next());

            reservation.updateDate(checkIn, checkOut);
            System.out.println("Reserva: " + reservation);
        }
        catch (ParseException e){
            System.out.println("Data invalida: ");
        }
        catch (DomainException e) {
            System.out.println("Erro na reserva: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Erro Inesperado");
        }

        en.close();
    }
}
