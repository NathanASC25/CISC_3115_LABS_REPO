import java.util.Scanner;
import java.io.File;
public class ReverseFile {
    public void copy(Scanner sc) {
        if (!sc.hasNext()) {
            return;
        }
        String word = sc.next();
        copy(sc);
        System.out.println(word);
    }
}
