// LAB 5.4
import java.util.Scanner;
import java.util.NoSuchElementException;
public class BorderedWindow extends Window {
    public BorderedWindow(int width, int height) {
        super(width, height);
    }
    @Override
    public String toString() {
        return super.toString() + " with a border";
    }
    @Override
    public void displayNormal() {
        for (int index1 = 0; index1 < getHeight() + 2; index1 += 1) {
            if (index1 == 0 || index1 == getHeight() + 1) {
                for (int index2 = 0; index2 < getWidth() + 2; index2 += 1) {
                    if (index2 == 0 || index2 == getWidth() + 1) {
                        System.out.print("+");
                        continue;
                    }
                    System.out.print("-");
                }
                System.out.println();
                continue;
            }
            for (int index2 = 0; index2 < getWidth() + 2; index2 += 1) {
                if (index2 == 0 || index2 == getWidth() + 1) {
                    System.out.print("|");
                    continue;
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static BorderedWindow read(Scanner sc) {
        try {
            int width = sc.nextInt();
            int height = sc.nextInt();
            return new BorderedWindow(width, height);
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }
}