import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.err.println("Error: it is necessary to pass the path and file name as an argument.");
            return;
        }

        String nameFile = args[0];

        int executionsNumber = 0;
        float timeValue = 0.0f;

        try (Scanner scannerNew = new Scanner(new FileReader(nameFile))) {
            while (scannerNew.hasNextLine()) {
                String currentLine = scannerNew.nextLine();

                if (currentLine.isBlank())
                    continue;

                String[] line = currentLine.trim().split("\\s+");

                if (line[1].equals("time....:")) {
                    executionsNumber++;
                    float currentValue = Float.parseFloat(line[2]);
                    timeValue += currentValue;
                }

            }
        }

        float average = (executionsNumber != 0) ? (timeValue / executionsNumber) : 0.0f;
        System.out.println(average);
    }
}