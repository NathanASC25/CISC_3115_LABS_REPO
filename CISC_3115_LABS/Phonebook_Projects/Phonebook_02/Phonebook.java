import java.io.File;
import java.io.IOException;
import java.util.Scanner;
class Phonebook {
    public static void main(String[] args) {
        try {
            boolean done = false;
            int lookUps = 0;
            int reverseLookUps = 0;
            PhonebookEntry[] entries = new PhonebookEntry[100];
            Scanner scanEntries = new Scanner(new File("phonebook.text"));
            int index = 0;
            while (scanEntries.hasNext()) {
                entries[index] = PhonebookEntry.read(scanEntries);
                index += 1;
            }
            scanEntries.close();
            Scanner in = new Scanner(System.in);
            while (!done) {
                System.out.print("lookup, reverse-lookup, quit (l/r/q)? ");
                String input = in.next();
                int indexOfEntry = -1;
                switch (input) {
                    case "l":
                        System.out.print("\nlast name? ");
                        String lastName = in.next();
                        System.out.print("first name? ");
                        String firstName = in.next();
                        Name tempName = new Name(firstName, lastName);
                        for (int n = 0; n < entries.length; n += 1) {
                            if (entries[n].getName().equals(tempName)) {
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
                        lookUps += 1;
                        break;
		            case "r":
                        System.out.print("\nphone number (nnn-nnn-nnnn)? ");
                        PhoneNumber tempNumber = new PhoneNumber(in.next());
                        for (int n = 0; n < entries.length; n += 1) {
                            if (entries[n].getPhoneNumber().equals(tempNumber)) {
                                indexOfEntry = n;
                            }
                        }
                        if (indexOfEntry > -1) {
                            System.out.printf("%s belongs to %s %s\n\n", tempNumber.toString(), entries[indexOfEntry].getName().getFirstName(), entries[indexOfEntry].getName().getLastName());
                        }
                        else {
                            System.out.print("-- Phone number not found\n\n");
                        }
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
}
