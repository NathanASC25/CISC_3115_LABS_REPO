import java.util.Scanner;
public class User {
    private String username = "", password = "", passwordHint = "";
    public User(String username, String password, String passwordHint) {
        this.username = username;
        this.password = password;
        this.passwordHint = passwordHint;
    }
    public String getUsername() {
        return username;
    }
    public String getHint() {
        return passwordHint;
    }
    public boolean verifyPassword(String entry) {
        return password.equals(entry);
    }
    public String toString() {
        return "User " + getUsername();
    }
    public static User read(Scanner sc) {
        //try {
            String username = sc.next();
            String password = sc.next();
            String passwordHint = sc.next();
            return new User(username, password, passwordHint);
	//}
        //catch (NoSuchElementException e) {
          //  throw new NoSuchElementException(e.getMessage());
        //}
    }
}
