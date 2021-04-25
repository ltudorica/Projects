package RegistrationManagementSystem;

public class Print {
    public static void fullComandList() {
        System.out.println("help -  Afiseaza aceasta lista de comenzi" +
                "\nadd - Adauga o noua persoana (inscriere)" +
                "\ncheck - Verifica daca o persoana este inscrisa la eveniment" +
                "\nremove - Sterge o persoana existenta din lista" +
                "\nupdate - Actualizeaza detaliile unei persoane" +
                "\nguests - Lista de persoane care participa la eveniment" +
                "\nwaitlist - Persoanele din lista de asteptare" +
                "\navailable - Numarul de locuri libere" +
                "\nguests_no - Numarul de persoane care participa la eveniment" +
                "\nwaitlist_no - Numarul de persoane din lista de asteptare" +
                "\nsubscribe_no - Numarul total de persoane inscrise" +
                "\nsearch - Cauta toti invitatii conform sirului de caractere introdus" +
                "\nquit - Inchide aplicatia");
    }

    public static void searchMode() {
        System.out.println("Alege modul de autentificare, tastand: \n\t\"1\" - Nume si prenume" +
                "\n\t\"2\" - Email \n\t\"3\" - Numar de telefon (format \"+40733386463\")");
    }

    public static void updateMode() {
        System.out.println("Alege campul de actualizat, tastand: \n\t\"1\" - Nume \n\t\"2\" - Prenume" +
                "\n\t\"3\" - Email \n\t\"4\" - Numar de telefon (format \"+40733386463\")");
    }

    public static void lastName() {
        System.out.println("Introduceti numele de familie:");
    }

    public static void firstName() {
        System.out.println("Introduceti prenumele:");
    }

    public static void email() {
        System.out.println("Introduceti email:");
    }

    public static void phoneNo() {
        System.out.println("Introduceti numar de telefon (format \"+40733386463\"):");
    }

    public static void guestInList() {
        System.out.println("Persoana este inscrisa la eveniment");
    }

    public static void guestNotInList() {
        System.out.println("Persoana nu este inscrisa la eveniment");
    }

    public static void remove() {
        System.out.println("Se sterge o persoana existenta din lista…");
    }

    public static String confirmedSpot() {
        return "- Felicitari! Locul tau la eveniment este confirmat. Te asteptam!";
    }

    public static void deletedPerson() {
        System.out.println("Stergerea persoanei s-a realizat cu succes.");
    }

    public static void error() {
        System.out.println("Eroare: Persoana nu este inscrisa la eveniment.");
    }

    public static void tryAgain() {
        System.out.println("Incercati inca o data.");
    }

    public static void update() {
        System.out.println("Se actualizeaza detaliile unei persoane…");
    }

    public static void waitCom() {
        System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
    }
}
