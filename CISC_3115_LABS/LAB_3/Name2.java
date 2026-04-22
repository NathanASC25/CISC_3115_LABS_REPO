// New Lab 3.1
import java.util.Scanner;
public class Name2 {
        private String firstName;
        private String lastName;
        private static int numInputs = 0;
        public Name2(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
        }
        public String toString() {
                return lastName + ", " + firstName;
        }
        public boolean equals(Name2 name) {
                if (this.firstName.equals(name.firstName) &&
                    this.lastName.equals(name.lastName)) {
                            return true;
                    }
                return false;
        }
        public static Name2 read(Scanner scan) {
                if (scan.hasNext()) {
                		String lastName = scan.next();
                		String firstName = scan.next();
                		numInputs += 1;
                		return new Name2(firstName, lastName);	
                }
                return null;
        }
}
