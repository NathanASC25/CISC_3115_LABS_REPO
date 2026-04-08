// Lab 5.3
import java.util.Scanner;
import java.util.NoSuchElementException;
public class ColoredWindow extends Window {
    private char backgroundColor;
    private int width;
    private int height;
    public ColoredWindow(int width, int height, char backgroundColor) {
        super(width, height);
        setColor(backgroundColor);
    }
    public ColoredWindow(int width, int height) {
        super(width, height);
        backgroundColor = '.';
    }
    @Override
    public String toString() {
        return super.toString() + " with background color '" + getColor() + "'";
    }
    public char getColor() {
        return backgroundColor;
    }
    public void setColor(char backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
    @Override
    public void displayNormal() {
        for (int index1 = 0; index1 < getHeight(); index1 += 1) {
            for (int index2 = 0; index2 < getWidth(); index2 += 1) {
                System.out.print(getColor());
            }
            System.out.println();
        }
    }
    public static ColoredWindow read(Scanner sc) {
        try {
            int newWidth = sc.nextInt();
            int newHeight = sc.nextInt();
            char newBackgroundColor = sc.next().charAt(0);
            return new ColoredWindow(newWidth, newHeight, newBackgroundColor);
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
