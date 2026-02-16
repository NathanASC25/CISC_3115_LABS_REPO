import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class PhonebookEntry {
        private Name name;
        private PhoneNumber phoneNumber;
        private static int numOfEntries = 0;
        private static ArrayList<Name> names = new ArrayList<>();
        private static ArrayList<PhoneNumber> numbers = new ArrayList<>();
        private static ArrayList<String> dupNames = new ArrayList<>();
        private static ArrayList<String> dupNumbers = new ArrayList<>();
        private static ArrayList<String> dupEntries = new ArrayList<>();
        public PhonebookEntry(Name name, PhoneNumber phoneNumber) {
                this.name = name;
                this.phoneNumber = phoneNumber;
        }
        public Name getName() {
                return name;
        }
        public PhoneNumber getPhoneNumber() {
                return phoneNumber;
        }
        public String toString() {
                return name.toString() + ": " + phoneNumber.toString();
        }
        public boolean equals(Name name, PhoneNumber phoneNumber) {
                return this.name.equals(name) && this.phoneNumber.equals(phoneNumber);
        }
        public static PhonebookEntry read(Scanner sc) {
                try {
                        boolean samePhone = false;
                        boolean sameName = false;
                        int namesIndex = -1;
                        int phonesIndex = -1;
                        String lastName = sc.next();
                        String firstName = sc.next();
                        Name newName = new Name(firstName, lastName);
                        PhoneNumber newNumber = new PhoneNumber(sc.next());
                        PhonebookEntry newEntry = new PhonebookEntry(newName, newNumber);
                        for (int n = 0; n < names.size(); n += 1) {
                                if (names.get(n).equals(newName)) {
                                        namesIndex = n;
                                        sameName = true;
                                        break;
                                }
                        }
                        for (int n = 0; n < numbers.size(); n += 1) {
                                if (numbers.get(n).equals(newNumber)) {
                                        phonesIndex = n;
                                        samePhone = true;
                                        break;
                                }
                        }
                        if (sameName && samePhone && namesIndex == phonesIndex) {
                                dupEntries.add("Duplicate entries for " + newEntry.toString() + " at lines " + (namesIndex + 1) + " and " + (names.size() + 1));
                        }
                        else if (sameName) {
                                dupNames.add("Duplicate names for " + newName.toString() + " at lines " + (namesIndex + 1) + " and " + (names.size() + 1));
                        }
                        else if (samePhone) {
                                dupNumbers.add("Duplicate numbers for " + newNumber.toString() + " at lines " + (phonesIndex + 1) + " and " + (numbers.size() + 1));
                        }
                        names.add(newName);
                        numbers.add(newNumber);
                        numOfEntries += 1;
                        return newEntry;
                }
                catch (NoSuchElementException e) {
                        System.out.println("---");
                        System.out.printf("%d entries processed\n", numOfEntries);
                        System.out.println("Duplicates in file: ");
                        for (String dupName : dupNames) {
                                System.out.printf("%s\n", dupName);
                        }
                        for (String dupNumber : dupNumbers) {
                                System.out.printf("%s\n", dupNumber);
                        }
                        for (String dupEntry : dupEntries) {
                                System.out.printf("%s\n", dupEntry);
                        }
                        throw new NoSuchElementException();
                }
        }
}
