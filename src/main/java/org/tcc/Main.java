package org.tcc;

import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        String nameFile = "C:\\Users\\Luciano\\IdeaProjects\\calcula-mediaTempo\\src\\main\\resources\\replication_report100x20.txt";

        //String nameFile = args[0];

        int executionsNumber = 0;
        float timeValue = 0.0f;

        try (Scanner scannerNew = new Scanner(new FileReader(nameFile))) {
            while (scannerNew.hasNextLine()) {
                String currentLine = scannerNew.nextLine();

                if (!currentLine.isBlank()) {
                    String[] line = currentLine.trim().split("\\s+");
                    if (Objects.equals(line[1], "time....:")) {
                        executionsNumber++;
                        timeValue += Float.parseFloat(line[2]);
                    }
                }
            }
        }

        float average = (executionsNumber != 0) ? (timeValue / executionsNumber) : 0.0f;
        System.out.println(average);
    }
}