import java.util.Scanner;
public class PhonebookEntry2 {
        private Name name;
        private PhoneNumber phoneNumber;
        public PhonebookEntry2(Name name, PhoneNumber phoneNumber) {
                this.name = name;
                this.phoneNumber = phoneNumber;
        }
        public Name getName() {
                return name;
        }
        public PhoneNumber getPhoneNumber() {
                return phoneNumber;
        }
        @Override
        public String toString() {
                return name.toString() + ": " + phoneNumber.toString();
        }
        public boolean equals(Name name, PhoneNumber phoneNumber) {
                return this.name.equals(name) && this.phoneNumber.equals(phoneNumber);
        }
        public static PhonebookEntry2 read(Scanner sc) {
                if (sc.hasNext()) {
                        String lastName = sc.next();
                        String firstName = sc.next();
                        Name newName = new Name(lastName, firstName);
                        PhoneNumber newNumber = new PhoneNumber(sc.next());
                        PhonebookEntry2 newEntry = new PhonebookEntry2(newName, newNumber);
                        return newEntry;
                }
                return null;
        }
}
