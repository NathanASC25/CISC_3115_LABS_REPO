// Lab 5.5
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.IOException;
import java.io.File;
import java.util.InputMismatchException;
public class WindowApp {
    public static void main(String[] args) throws IOException {
        Scanner lineCounter = new Scanner(new File("./window.data"));
        int numOfLines = countNumOfLines(lineCounter);
        Window[] windows = new Window[numOfLines];
        Scanner input = new Scanner(new File("./window.data"));
        int scannerIndex = 0;
        int width, height;
        while (input.hasNextLine()) {
            String line = input.nextLine();
            Scanner scanLine = new Scanner(line);
            while (scanLine.hasNext()) {
                String windowType = scanLine.next();
                switch (windowType) {
                    case "C":
                        width = scanLine.nextInt();
                        height = scanLine.nextInt();
                        char backgroundColor = scanLine.next().charAt(0);
                        windows[scannerIndex] = new ColoredWindow(width, height, backgroundColor);
                        break;
                    case "B":
                        width = scanLine.nextInt();
                        height = scanLine.nextInt();
                        windows[scannerIndex] = new BorderedWindow(width, height);
                        break;
                    default:
                        throw new InputMismatchException("Wrong input type");
                }
            }
            scanLine.close();
            scannerIndex += 1;
        }
        input.close();
        System.out.println("Creating window data from file data, loading it into an array, and displaying");
        for (int index = 0; index < windows.length; index += 1) {
            System.out.println("--- Window " + index + ": " + windows[index]);
            windows[index].display();
            System.out.println();
        }
        System.out.println("\nTurning on visibility");
        for (int index = 0; index < windows.length; index += 1) {
            windows[index].setVisible(true);
            System.out.println("--- Window " + index + ": " + windows[index]);
            windows[index].display();
            System.out.println();
        }
        System.out.println("\nResizing (flipping width and height) and displaying");
        for (int index = 0; index < windows.length; index += 1) {
            windows[index].resize(windows[index].getHeight(), windows[index].getWidth());
            System.out.println("--- Window " + index + ": " + windows[index]);
            windows[index].display();
            System.out.println();
        }
        System.out.println("\nMinimizing and Displaying");
        for (int index = 0; index < windows.length; index += 1) {
            windows[index].minimize();
            System.out.println("--- Window " + index + ": " + windows[index]);
            windows[index].display();
            System.out.println();
        }
    }
    private static int countNumOfLines(Scanner sc) {
        int numOfLines = 0;
        while (sc.hasNextLine()) {
            numOfLines += 1;
            sc.nextLine();
        }
        sc.close();
        return numOfLines;
    }
}
