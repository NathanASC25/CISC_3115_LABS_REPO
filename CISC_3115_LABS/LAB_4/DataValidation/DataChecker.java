import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class DataChecker {
    public static void main(String[] args) throws IOException {
        Scanner scanFile = new Scanner(new File("./numbers.text"));
        int lineCount = 0;
        int validLinesCount = 0;
        int corruptLinesCount = 0;
        while (scanFile.hasNextLine()) {
            lineCount += 1;
            String line = scanFile.nextLine();
            Scanner scanLine = new Scanner(line);
            boolean hasHeaderVal = scanLine.hasNextInt();
            if (!hasHeaderVal) {
                System.out.printf("*** Error (line %d): Line is empty - average can't be taken\n", lineCount);
                corruptLinesCount += 1;
                continue;
            }
            int headerVal = scanLine.nextInt();
            int numOfVals = 0;
            double valTotal = 0;
            while (scanLine.hasNextInt()) {
                valTotal += scanLine.nextInt();
                numOfVals += 1;
            }
            if (headerVal == 0) {
                System.out.printf("*** Error (line %d): Header value of 0 - average can't be taken\n", lineCount);
                corruptLinesCount += 1;
                continue;
            }
            else if (headerVal < 0) {
                System.out.printf("*** Error (line %d): Corrupt line - negative header value\n", lineCount);
                corruptLinesCount += 1;
                continue;
            }
            else if (numOfVals < headerVal) {
                System.out.printf("*** Error (line %d): Corrupt line - fewer values than header\n", lineCount);
                corruptLinesCount += 1;
                continue;
            }
            else if (numOfVals > headerVal) {
                System.out.printf("*** Error (line %d): Corrupt line - extra values on line\n", lineCount);
                corruptLinesCount += 1;
                continue;
            }
            double avg = valTotal / numOfVals;
            System.out.printf("The average of the values on line %d is %.1f\n", lineCount, avg);
            validLinesCount += 1;
        }
        System.out.printf("\nThere were %d valid lines of data\n", validLinesCount);
        System.out.printf("There were %d corrupt lines of data", corruptLinesCount);
    }
}
