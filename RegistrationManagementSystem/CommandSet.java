package RegistrationManagementSystem;

import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CommandSet {
    private static Scanner sc;

    public static void setScanner(FileReader file) throws IOException{
       sc = new Scanner(file);
    }

    public static Scanner getSc() {
        return sc;
    }

    public static String readGuest() {
        while (true) {
            try {
                return sc.nextLine();
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Incercati din nou!");
            }
        }
    }

    public static int readOption() {
        while (true) {
            try {
               return Integer.parseInt(sc.nextLine());
            } catch (InputMismatchException e) {
                sc.nextInt();
                System.out.println("Nu ati introdus o valoare intreaga. Incercati din nou.");
            }
        }
    }

    public static Guest fullGuest() {
        Guest newGuest = new Guest();
        Print.lastName();
        newGuest.setLastName(readGuest());
        Print.firstName();
        newGuest.setFirstName(readGuest());
        Print.email();
        newGuest.setEmail(readGuest());
        Print.phoneNo();
        newGuest.setPhoneNo(readGuest());
        return newGuest;
    }

    public static Guest nameGuest() {
        Guest newGuest = new Guest();
        Print.lastName();
        newGuest.setLastName(readGuest());
        newGuest.setFirstName(readGuest());
        return newGuest;
    }

    public static Guest emailGuest() {
        Guest newGuest = new Guest();
        Print.email();
        newGuest.setEmail(readGuest());
        return newGuest;
    }

    public static Guest phoneGuest() {
        Guest newGuest = new Guest();
        Print.phoneNo();
        newGuest.setPhoneNo(readGuest());
        return newGuest;
    }

}
