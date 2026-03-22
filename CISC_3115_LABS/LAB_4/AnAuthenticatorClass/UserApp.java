import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
public class UserApp {
    public static void main(String[] args) throws IOException {
        ArrayList<User> users = new ArrayList<>();
	Scanner scanFile = new Scanner(new File("./users.data"));
        while (scanFile.hasNextLine()) {
            String line = scanFile.nextLine();
            Scanner scanLine = new Scanner(line);
            users.add( User.read(scanLine) );
        }
        for (User user : users) {
            System.out.print(user);
            System.out.println(" hint: " + user.getHint());
            if (!user.verifyPassword(user.getUsername())) {
                System.out.println("OK -- the password is different than the user name");
            }
            else {
                System.out.println("*** Error the password should not be the same as the user name");
            }
            System.out.println();
        }
    }
}
