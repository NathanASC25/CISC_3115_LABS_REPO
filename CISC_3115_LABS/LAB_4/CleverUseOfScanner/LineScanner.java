import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class LineScanner {
    public static void main(String[] args) throws IOException {
        Scanner scanFile = new Scanner(new File("./numbers.text"));
        int lineCount = 0;
        while (scanFile.hasNextLine()) {
            lineCount += 1;
            int numOfNums = 0;
            String line = scanFile.nextLine();
            Scanner scanLine = new Scanner(line);
            while (scanLine.hasNextInt()) {
                scanLine.nextInt();
                numOfNums += 1;
            }
            System.out.printf("There are %d numbers on line %d\n", numOfNums, lineCount);
        }
    }
}
