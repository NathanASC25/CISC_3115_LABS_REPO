import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class FindLast {
        public static void main(String[] args) throws IOException {
                File nums = new File("./numbers.text");
                Scanner scanIn = new Scanner(System.in);
                System.out.print("Enter a number: ");
                while (scanIn.hasNextInt()) {
                        findNum(scanIn.nextInt(), nums);
                        System.out.print("\nEnter a number: ");
                }
                scanIn.close();
        }
        public static void findNum(int key, File file) throws IOException {
                int indexOfKey = -1;
                int index = 1;
                Scanner scanNums = new Scanner(file);
                while (scanNums.hasNextInt()) {
                        if (scanNums.nextInt() == key) indexOfKey = index;
                        index += 1;
                }
                scanNums.close();
                if (indexOfKey < 1) {
                        System.out.printf("%d does not appear in the file", key);
                        return;
                }
                System.out.printf("%d last appears in the file at position %d", key, indexOfKey);
        }
}
