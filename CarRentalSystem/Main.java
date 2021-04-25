package CarRentalSystem;

import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        FileReader file = null;

        try {
            file = new FileReader("./Teme/src/C26HashTable/RentalCars.txt");
            CarRentalSystem.setScanner(file);
            new CarRentalSystem().run();
        } catch (IOException e) {
            System.out.println("There is an issue with the file! ");
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
