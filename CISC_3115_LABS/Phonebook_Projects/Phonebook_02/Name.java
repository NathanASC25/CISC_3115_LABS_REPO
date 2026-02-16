import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class Name {
        public static ArrayList<String> firstNames = new ArrayList<>();
        public static ArrayList<String> lastNames = new ArrayList<>();
        public static ArrayList<String> duplicates = new ArrayList<>();
        private String firstName;
        private String lastName;
        public static int numInputs = 0;
        public Name(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
        }
        public String toString() {
                return firstName + ", " + lastName;
        }
        public String getFirstName() {
                return firstName;
        }
        public String getLastName() {
                return lastName;
        }
        public boolean equals(Name name) {
                if (this.firstName.equals(name.firstName) &&
                    this.lastName.equals(name.lastName)) {
                            return true;
                    }
                return false;
        }
        public static Name read(Scanner scan) {
                try {
                		String lastName = scan.next();
                		String firstName = scan.next();
                		boolean con1 = firstNames.indexOf(firstName) > -1;
                		boolean con2 = lastNames.indexOf(lastName) > -1;
                		boolean con3 = firstNames.indexOf(firstName) == lastNames.indexOf(lastName);
                		if (con1 && con2 && con3) {
                				duplicates.add(lastName + ", " + firstName + " at lines " + (firstNames.indexOf(firstName) + 1) + " and " + (firstNames.size() + 1));	
                		}
                		lastNames.add(lastName);
                		firstNames.add(firstName);
                		numInputs += 1;
                		return new Name(firstName, lastName);	
                }
                catch (NoSuchElementException e) {
                		System.out.println("---");
                		System.out.printf("%d names input\n", numInputs);
                		System.out.println("Duplicates found in file: ");
                		for (String line : duplicates) {
                			System.out.printf("%s\n", line);	
                		}
                		throw new NoSuchElementException();
                }
        }
}

