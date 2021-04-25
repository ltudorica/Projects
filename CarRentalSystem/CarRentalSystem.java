package CarRentalSystem;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CarRentalSystem {
    private static Scanner sc = new Scanner(System.in);
    private Map<String, String> rentedCars = new HashMap<>(100, 0.5f);
    private Map<String, LinkedList<String>> ownerCars = new HashMap<>(100, 0.5f);
    private int totalRented;

    public static void setScanner(FileReader file) throws IOException {
        sc = new Scanner(file);
    }

    static String getPlateNo() {
        while (true) {
            try {
                System.out.println("Introduceti numarul de inmatriculare:");
                return sc.nextLine();
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Incercati din nou!");
            }
        }
    }

    static String getOwnerName() {
        while (true) {
            try {
                System.out.println("Introduceti numele proprietarului:");
                return sc.nextLine();
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Incercati din nou!");
            }
        }
    }

    boolean isCarRent(String plateNo) {
        return this.rentedCars.containsKey(plateNo.toLowerCase());
    }

    String getCarRent(String plateNo) {
        // 1.3
        if (!isCarRent(plateNo.toLowerCase())) {
            System.out.println("Masina nu este inchiriata / nu se afla in baza de date.");
            return " No Car ";
        }
        return this.rentedCars.get(plateNo.toLowerCase());
    }

    void rentCar(String plateNo, String ownerName) {
        // 1.1 - Cand se va incerca adaugarea unei masini deja inchiriate, nu se va mai puutea efectua asta. Masina ar trebui intai returnata, iar apoi adaugata din nou;
        if (this.rentedCars.containsKey(plateNo.toLowerCase())) {
            System.out.println("Masina este deja inchiriata.");
        } else {
            this.rentedCars.put(plateNo.toLowerCase(), ownerName);
            totalRented++;
            // 2
            if (!this.ownerCars.containsKey(ownerName)) {
                this.ownerCars.put(ownerName, new LinkedList<>());
            }
            this.ownerCars.get(ownerName).add(plateNo);
        }
    }


    void returnCar(String plateNo) {
        // 1.2
        if (isCarRent(plateNo.toLowerCase())) {
            String aux = this.rentedCars.get(plateNo);
            this.rentedCars.remove(plateNo.toLowerCase());
            this.ownerCars.get(aux).remove(plateNo);
            totalRented--;

            System.out.println("Masina a fost returnata cu succes!");
        } else {
            System.out.println("Masina nu a fost inchiriata!");
        }
    }

    // 1.4
    int totalRented() {
        return this.totalRented;
    }

    // 2.1
    int getCarsNo(String ownerName) {
        return this.ownerCars.get(ownerName).size();
    }

    // 2.2
    LinkedList<String> getCarsList(String ownerName) {
        return this.ownerCars.get(ownerName);
    }

    static void printCommandsList() {
        System.out.println("help         - Afiseaza aceasta lista de comenzi");
        System.out.println("add          - Adauga o noua pereche (masina, sofer)");
        System.out.println("check        - Verifica daca o masina este deja luata");
        System.out.println("remove       - Sterge o masina existenta din hashtable");
        System.out.println("getOwner     - Afiseaza proprietarul curent al masinii");
        System.out.println("totalRented  - Afiseaza numarul total de masini inchiriate"); //1.4
        System.out.println("totalCars    - Afiseaza numarul total de masini inchiriate de un anumit proprietar"); //2.1
        System.out.println("carsList     - Afiseaza toate masinile inchiriate de un anumit proprietar"); //2.2
        System.out.println("quit         - Inchide aplicatia");
    }

    public void run() {
        boolean quit = false;
        while (!quit) {
            System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
            String command = sc.nextLine();
            switch(command) {
                case "help":
                    printCommandsList();
                    break;
                case "add":
                    rentCar(getPlateNo(), getOwnerName());
                    break;
                case "check":
                    System.out.println(isCarRent(getPlateNo()));
                    break;
                case "remove":
                    returnCar(getPlateNo());
                    break;
                case "getOwner":
                    System.out.println(getCarRent(getPlateNo()));
                    break;
                case "totalRented":   //1.4
                    System.out.println("Au fost inchiriate " + totalRented() + " masini");
                    break;
                case "totalCars":   //2.1
                    System.out.println(getCarsNo(getOwnerName()));
                    break;
                case "carsList":   // 2.2
                    System.out.println(getCarsList(getOwnerName()));
                    break;
                case "quit":
                    System.out.println("Aplicatia se inchide...");
                    quit = true;
                    break;
                default:
                    System.out.println("Unknown command. Choose from:");
                    printCommandsList();
            }
        }
    }

}
