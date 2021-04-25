package RegistrationManagementSystem;

import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static boolean readComands(GuestList myList) {

        String random = "help";

        while (!random.equals("quit")) {
            Print.waitCom();

            switch (CommandSet.readGuest()) {
                case "help":
                    Print.fullComandList();
                    break;
                case "add":
                    myList.add();
                    break;
                case "check":
                    myList.check();
                    break;
                case "remove":
                    myList.remove();
                    break;
                case "update":
                    myList.update();
                    break;
                case "guests":
                    myList.guests();
                    break;
                case "waitlist":
                    myList.waitlist();
                    break;
                case "available":
                    myList.available();
                    break;
                case "guests_no":
                    myList.guests_no();
                    break;
                case "waitlist_no":
                    myList.waitlist_no();
                    break;
                case "subscribe_no":
                    myList.subscribe_no();
                    break;
                case "search":
                    System.out.println("Introduceti datele de cautat");
                    myList.search(CommandSet.readGuest());
                    break;
                case "quit":
                    random = "quit";
                    break;
                default:
                    Print.tryAgain();
                    break;
            }

        }
        System.out.println("Aplicatia se inchide...");

        return true;
    }

    public static void main(String[] args) throws IOException {
        FileReader file = null;

        try {
            file = new FileReader("file.txt");
            CommandSet.setScanner(file);
            System.out.println("Bun venit! Introduceti numarul de locuri disponibile:");
            GuestList myList = new GuestList(CommandSet.readOption());
            readComands(myList);
        } catch (IOException e) {
            System.out.println("Este ceva in neregula cu acest fisier!");
            e.printStackTrace();
        } finally {
            try {
                if (file != null) {
                    file.close();
                }
            } catch (IOException e) {
                System.out.println("Exception raised when attempting to close the file");
                e.printStackTrace();
            }
        }


    }
}
