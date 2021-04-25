package RegistrationManagementSystem;

public class Guest {
    private String lastName;
    private String firstName;
    private String email;
    private String phoneNo;

    public Guest() {
    }

    public Guest(String lastName, String firstName, String email, String phoneNo) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPhoneNo() {
        return this.phoneNo;
    }

    @Override
    public String toString() {
        return "Nume: " + this.firstName + " " + this.lastName + ", Email: " + this.email +
                ", Telefon: " + this.phoneNo;
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

        Guest aGuest = (Guest) obj;
        return this.lastName.equalsIgnoreCase(aGuest.lastName) && this.firstName.equalsIgnoreCase(aGuest.firstName) &&
                this.email.equalsIgnoreCase(aGuest.email);

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
        result = prime * result + ((this.lastName == null) ? 0 : this.lastName.hashCode());
        result = prime * result + ((this.firstName == null) ? 0 : this.firstName.hashCode());
        return result;
    }

    public boolean sameName(Guest g) {
        return this.lastName.equalsIgnoreCase(g.lastName) && this.firstName.equalsIgnoreCase(g.firstName);
    }

    public boolean sameEmail(Guest g) {
        return this.email.equalsIgnoreCase(g.email);
    }

    public boolean samePhone(Guest g) {
        return this.phoneNo.equalsIgnoreCase(g.phoneNo);
    }

}
