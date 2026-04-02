import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.util.NoSuchElementException;
class PhonebookApp {
    public static void main(String[] args) {
        boolean done = false;
        int lookUps = 0;
        int reverseLookUps = 0;
        Scanner in = new Scanner(System.in);
        Phonebook phonebook = new Phonebook("phonebook.text");
        while (!done) {
            System.out.print("lookup, reverse-lookup, quit (l/r/q)? ");
            String input = in.next();
            int indexOfEntry = -1;
            switch (input) {
                case "l":
                    phonebook.lookup(in, indexOfEntry);
                    lookUps += 1;
                    break;
                case "r":
                    phonebook.reverseLookup(in, indexOfEntry);
                    reverseLookUps += 1;
                    break;
                case "q":
                    done = true;
                    break;
                default:
                    System.out.print("\nInvalid input.\n");
            }
	}
        in.close();
        System.out.printf("%d lookups performed\n", lookUps);
        System.out.printf("%d reverse lookups performed", reverseLookUps);
    }
}
class Phonebook {
    private final static int DEFAULTCAPACITY = 100;
    private int numOfElements = 0;
    private String fileName;
    private PhonebookEntry[] entries;
    private static Scanner scanEntries;
    public Phonebook(String fileName, int initialCap) {
        this.fileName = fileName;
        numOfElements = initialCap;
        entries = new PhonebookEntry[numOfElements];
        try {
            scanEntries = new Scanner(new File("./" + fileName));
            int index = 0;
            while (scanEntries.hasNext()) {
                entries[index] = PhonebookEntry.read(scanEntries);
                index += 1;
            }
            scanEntries.close();
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("\n***Exception*** Phonebook capacity exceeded - increase size of underlying array\n");
        }
        catch (IOException e) {
            System.out.print("\n***IOException*** phonebook text (No such file or directory\n");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Phonebook(String fileName) {
        this.fileName = fileName;
        numOfElements = DEFAULTCAPACITY;
        entries = new PhonebookEntry[numOfElements];
        try {
            scanEntries = new Scanner(new File("./" + fileName));
            int index = 0;
            while (scanEntries.hasNext()) {
                entries[index] = PhonebookEntry.read(scanEntries);
                index += 1;
            }
            scanEntries.close();
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("\n***Exception*** Phonebook capacity exceeded - increase size of underlying array\n");
        }
        catch (IOException e) {
            System.out.print("\n***IOException*** phonebook text (No such file or directory\n");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void lookup(Scanner sc, int indexOfEntry) {
        System.out.print("\nlast name? ");
        String lastName = sc.next();
        System.out.print("first name? ");
        String firstName = sc.next();
        Name tempName = new Name(firstName, lastName);
        for (int n = 0; n < entries.length; n += 1) {
            // Make sure entries are not null
            if (entries[n] != null && entries[n].getName().equals(tempName)) {
                indexOfEntry = n;
                break;
            }
        }
        if (indexOfEntry > -1) {
            System.out.printf("%s %s's phone number is %s\n\n", firstName, lastName, entries[indexOfEntry].getPhoneNumber().toString());
        }
        else {
            System.out.print("-- Name not found\n\n");
        }
    }
    public void reverseLookup(Scanner sc, int indexOfEntry) {
        System.out.print("\nphone number (nnn-nnn-nnnn)? ");
        PhoneNumber tempNumber = new PhoneNumber(sc.next());
        for (int n = 0; n < entries.length; n += 1) {
            // Make sure entries are not null
            if (entries[n] != null && entries[n].getPhoneNumber().equals(tempNumber)) {
                indexOfEntry = n;
            }
        }
        if (indexOfEntry > -1) {
            System.out.printf("%s belongs to %s %s\n\n", tempNumber.toString(), entries[indexOfEntry].getName().getFirstName(), entries[indexOfEntry].getName().getLastName());
        }
        else {
            System.out.print("-- Phone number not found\n\n");
        }
    }
}
