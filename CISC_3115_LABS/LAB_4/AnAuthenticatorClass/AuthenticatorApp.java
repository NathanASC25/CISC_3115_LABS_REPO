import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.InputMismatchException;
import java.util.ArrayList;
public class AuthenticatorApp {
    public static void main(String[] args) throws IOException {
        Scanner userIn = new Scanner(System.in);
        Authenticator authenticator = null;
        try {
            authenticator = new Authenticator("./users.data");
        }
        catch (Exception e) {}
        ArrayList<User> users = new ArrayList<>();
        Scanner scanFile = new Scanner(new File("./users.data"));
        while (scanFile.hasNextLine()) {
            String line = scanFile.nextLine();
            Scanner scanLine = new Scanner(line);
            users.add( User.read(scanLine) );
            scanLine.close();
        }
        scanFile.close();
        String username = "", password = "";
        for (int index = 0; index < 3; index += 1) {
            try {
                System.out.print("username? ");
                username = userIn.nextLine();
                System.out.print("password? ");
                password = userIn.nextLine();
                try {
                    authenticator.authenticate(username, password);
                }
                catch (Exception e) {
                    System.out.print("*** " + e.getMessage() + "\n");
                    continue;
                }
                System.out.print("Welcome to the system");
                userIn.close();
                return;
            }
            catch (InputMismatchException e) {
                System.out.print(e.getMessage());
            }
            catch (NoSuchElementException e) {
                System.out.print(e.getMessage());
            }
        }
        System.out.print("Too many failed attempts... please try again later");
    }
}
