package backup;

import data.Application;

import java.io.FileWriter;
import java.io.IOException;

public class BackUpApplication {
    private static String fileName = "Application.txt";

    public BackUpApplication() {
    }

    public static void backUpApplication(String idNumber, Application application) {
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            String line = idNumber + ":" + application + "\n";
            fileWriter.write(line);
            System.out.println("Applications backed up.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
