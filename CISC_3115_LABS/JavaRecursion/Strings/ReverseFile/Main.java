import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(new File("words.data"))) {
            ReverseFile reverse = new ReverseFile();
            reverse.copy(scan);
	}
        catch (IOException e) {
            System.out.printf("\n%s\n", e.getMessage());
        }
        finally {
            System.out.print("\nEnd of program.\n");
        }
    }
}
