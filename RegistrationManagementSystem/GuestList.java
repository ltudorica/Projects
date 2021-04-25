package RegistrationManagementSystem;

import java.util.ArrayList;

public class GuestList {

    private final int availableSeats;
    private ArrayList<Guest> invites;

    @Override
    public String toString() {
        return invites.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        GuestList aGuestList = (GuestList) obj;
        return this.invites.equals(aGuestList.invites);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.invites == null) ? 0 : this.invites.hashCode());
        return result;
    }

    public GuestList(int availableSeats) {
        this.availableSeats = availableSeats;
        this.invites = new ArrayList<>(availableSeats);
    }

    public int add() {
        System.out.println("Se adauga o noua persoana…");
        Guest newGuest = CommandSet.fullGuest();

        for (int i = 0; i < this.invites.size(); i++) {
            if (this.invites.get(i).equals(newGuest) || this.invites.get(i).samePhone(newGuest)) {
                System.out.println("Persoana este deja inscrisa la eveniment.");
                return -1;
            }
        }
        this.invites.add(newGuest);
        if (this.invites.size() > this.availableSeats) {
            System.out.println("Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine " +
                             (this.invites.size() - this.availableSeats) + ". Te vom notifica daca un loc devine disponibil.");
            return this.invites.size();
        } else {
            System.out.println(Print.confirmedSpot());
            return 0;
        }
    }

    public boolean check() {
        Print.searchMode();

        switch (CommandSet.readOption()) {
            case 1:
                Guest someGuest = CommandSet.nameGuest();

                for (int i = 0; i < this.invites.size(); i++) {
                    if (this.invites.get(i).sameName(someGuest)) {
                        Print.guestInList();
                        return true;
                    }
                }

                Print.guestNotInList();
                return false;

            case 2:
                Guest aGuest = CommandSet.emailGuest();

                for (int i = 0; i < this.invites.size(); i++) {
                    if (this.invites.get(i).sameEmail(aGuest)) {
                        Print.guestInList();
                        return true;
                    }
                }

                Print.guestNotInList();
                return false;

            case 3:
                Guest helpGuest2 = CommandSet.phoneGuest();

                for (int i = 0; i < this.invites.size(); i++) {
                    if (this.invites.get(i).samePhone(helpGuest2)) {
                        Print.guestInList();
                        return true;
                    }
                }

                Print.guestNotInList();
                return false;

            default:
                Print.tryAgain();
                return false;
        }
    }

    public boolean remove() {
        Print.remove();
        Print.searchMode();

        switch (CommandSet.readOption()) {
            case 1:
                Guest someGuest = CommandSet.nameGuest();
                boolean value = false;

                for (int i = 0; i < this.invites.size(); i++) {
                    if (this.invites.get(i).sameName(someGuest)) {
                        this.invites.remove(i);
                        Print.deletedPerson();
                        value = true;
                        break;
                    }
                }

                if (value && this.invites.size() >= this.availableSeats) {
                    System.out.println(this.invites.get(this.availableSeats - 1).getLastName() + " " +
                            this.invites.get(this.availableSeats - 1).getFirstName() +
                            " " + Print.confirmedSpot());
                }

                if (!value) {
                    Print.error();
                }

                return value;

            case 2:
                Guest aGuest = CommandSet.emailGuest();
                boolean valueEmail = false;

                for (int i = 0; i < this.invites.size(); i++) {
                    if (this.invites.get(i).sameEmail(aGuest)) {
                        this.invites.remove(i);
                        Print.deletedPerson();
                        valueEmail = true;
                        break;
                    }
                }

                if (valueEmail && this.invites.size() >= this.availableSeats) {
                    System.out.println(this.invites.get(this.availableSeats - 1).getLastName() + " " +
                            this.invites.get(this.availableSeats - 1).getFirstName() +
                            " " + Print.confirmedSpot());
                }

                if (!valueEmail) {
                    Print.error();
                }

                return valueEmail;

            case 3:
                Guest oneGuest = CommandSet.phoneGuest();
                boolean valuePhone = false;

                for (int i = 0; i < this.invites.size(); i++) {
                    if (this.invites.get(i).samePhone(oneGuest)) {
                        this.invites.remove(i);
                        Print.deletedPerson();
                        valuePhone = true;
                        break;
                    }
                }

                if (valuePhone && this.invites.size() >= this.availableSeats) {
                    System.out.println(this.invites.get(this.availableSeats - 1).getLastName() + " " +
                            this.invites.get(this.availableSeats - 1).getFirstName() +
                            " " + Print.confirmedSpot());
                }

                if (!valuePhone) {
                    Print.error();
                }

                return valuePhone;

            default:
                Print.tryAgain();
                return false;
        }
    }

    public boolean update() {
        Print.update();
        Print.searchMode();
        switch (CommandSet.readOption()) {
            case 1:
                Guest someGuest = CommandSet.nameGuest();
                boolean value = false;
                for (int i = 0; i < this.invites.size(); i++) {
                    if (this.invites.get(i).sameName(someGuest)) {
                        updateGuest(i);
                        value = true;
                        break;
                    }
                }

                if (!value) {
                    Print.error();
                }

                return value;
            case 2:
                Guest aGuest = CommandSet.emailGuest();
                boolean valueEmail = false;
                for (int i = 0; i < this.invites.size(); i++) {
                    if (this.invites.get(i).sameEmail(aGuest)) {
                        updateGuest(i);
                        valueEmail = true;
                        break;
                    }
                }

                if (!valueEmail) {
                    Print.error();
                }

                return valueEmail;

            case 3:
                Guest oneGuest = CommandSet.phoneGuest();
                boolean valuePhone = false;
                for (int i = 0; i < this.invites.size(); i++) {
                    if (this.invites.get(i).samePhone(oneGuest)) {
                        updateGuest(i);
                        valuePhone = true;
                        break;
                    }
                }

                if (!valuePhone) {
                    Print.error();
                }

                return valuePhone;

            default:
                Print.tryAgain();
                return false;
        }
    }

    private boolean updateGuest(int indexNo) {
        Print.updateMode();

        switch (CommandSet.readOption()) {
            case 1:
                Print.lastName();
                CommandSet.getSc().nextLine();
                this.invites.get(indexNo).setLastName(CommandSet.readGuest());
                return true;
            case 2:
                Print.firstName();
                CommandSet.getSc().nextLine();
                this.invites.get(indexNo).setFirstName(CommandSet.readGuest());
                return true;
            case 3:
                Print.email();
                CommandSet.getSc().nextLine();
                this.invites.get(indexNo).setEmail(CommandSet.readGuest());
                return true;
            case 4:
                Print.phoneNo();
                CommandSet.getSc().nextLine();
                this.invites.get(indexNo).setPhoneNo(CommandSet.readGuest());
                return true;
            default:
                Print.tryAgain();
                return false;
        }
    }

    public boolean guests() {

        if (this.invites == null || this.invites.isEmpty() || this.availableSeats == 0) {
            System.out.println("Lista de invitati este goala..");
            return false;
        }

        for (int i = 0; i < Math.min(this.availableSeats, this.invites.size()); i++) {
            System.out.println((i + 1) + ". " + this.invites.get(i).toString());
        }

        return true;
    }

    public boolean waitlist() {

        if (this.invites == null || this.invites.isEmpty() || this.invites.size() < this.availableSeats) {
            System.out.println("Lista de asteptare este goala..");
            return false;
        }

        int j = 1;
        for (int i = this.availableSeats; i < this.invites.size(); i++) {
            System.out.println(j + ". " + this.invites.get(i).toString());
            j++;
        }

        return true;
    }

    public void available() {
        System.out.println("Numarul de locuri ramase: " +
                ((this.invites.size() >= this.availableSeats) ? 0 : (this.availableSeats - this.invites.size())));
    }

    public void guests_no() {
        System.out.println("Numarul de participanti: " + Math.min(this.invites.size(), this.availableSeats));
    }

    public void waitlist_no() {
        System.out.println("Dimensiunea listei de asteptare: " +
                ((this.invites.size() <= this.availableSeats) ? 0 : (this.invites.size() - this.availableSeats)));
    }

    public void subscribe_no() {
        System.out.println("Numarul total de persoane: " + this.invites.size());
    }

    public boolean search(String string) {

        ArrayList<Guest> matchList = checkSearch(string);

        if (matchList == null || matchList.isEmpty()) {
            System.out.println("Nici un participant nu contine sirul de caractere introduse!");
            return false;
        }

        for (int i = 0; i < matchList.size(); i++) {
            System.out.print((i + 1) + ". Contact " + (i + 1) + ": contine");
            if (matchList.get(i).getLastName().toLowerCase().contains(string.toLowerCase())) {
                System.out.print(" numele = " + matchList.get(i).getLastName() + " ");
            }
            if (matchList.get(i).getFirstName().toLowerCase().contains(string.toLowerCase())) {
                System.out.print(" prenumele = " + matchList.get(i).getFirstName() + " ");
            }
            if (matchList.get(i).getEmail().toLowerCase().contains(string.toLowerCase())) {
                System.out.print(" email = " + matchList.get(i).getEmail() + " ");
            }
            if (matchList.get(i).getPhoneNo().toLowerCase().contains(string.toLowerCase())) {
                System.out.print(" numarul de telefon = " + matchList.get(i).getPhoneNo() + " ");
            }
            System.out.println();
        }

        return true;
    }

    private ArrayList<Guest> checkSearch(String string){
        ArrayList<Guest> matchingList = new ArrayList<>();

        for (int i = 0; i < this.invites.size(); i++) {
            Guest playGuest = this.invites.get(i);
            if (playGuest.getLastName().toLowerCase().contains(string.toLowerCase()) ||
                    playGuest.getFirstName().toLowerCase().contains(string.toLowerCase()) ||
                    playGuest.getEmail().toLowerCase().contains(string.toLowerCase()) ||
                    playGuest.getPhoneNo().toLowerCase().contains(string.toLowerCase())) {
                matchingList.add(playGuest);
            }
        }

        return matchingList;
    }


}
