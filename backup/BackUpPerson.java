package backup;

import data.Person;

import java.io.FileWriter;
import java.io.IOException;


public class BackUpPerson {
    private static String fileName = "People.txt";

    public BackUpPerson() {
    }

    public static void backUpPerson(String idNumber, Person person) {
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            String line = idNumber + ":" + person + "\n";
            fileWriter.write(line);
            System.out.println("Contacts backed up.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
