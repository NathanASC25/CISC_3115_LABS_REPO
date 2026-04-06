import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.lang.UnsupportedOperationException;
import java.util.InputMismatchException;
import java.lang.NullPointerException;
class Authenticator {
    private User[] users = new User[100];
    public Authenticator(String fileName) throws IOException {
        int index = 0;
        Scanner scanFile = new Scanner(new File(fileName));
        while (scanFile.hasNextLine()) {
            String line = scanFile.nextLine();
            Scanner scanLine = new Scanner(line);
            User user = User.read(scanLine);
            users[index] = user;
            index += 1;
	}
    }
    public void authenticate(String username, String password) {
        boolean usernameFound = false, passwordMatched = false;
	int userIndex = -1;
        for (int index = 0; index < users.length; index += 1) {
            if (users[index] == null) {
                break;
	    }
	    if (users[index].getUsername().equals(username)) {
                userIndex = index;
                usernameFound = true;
            }
            if (users[index].verifyPassword(password)) {
                passwordMatched = true;
            }
        }
        if (!usernameFound) {
            throw new UnsupportedOperationException("No such user found");
        }
        if (!passwordMatched) {
            throw new InputMismatchException("Invalid password - hint: " + users[userIndex].getHint());
        }
    }
}
