import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Phonebook {
    public static void main(String[] args) throws IOException {
        ArrayList<String> lastNames = new ArrayList<>();
        ArrayList<String> firstNames = new ArrayList<>();
        ArrayList<String> phoneNumbers = new ArrayList<>();
        scanDetails(lastNames, firstNames, phoneNumbers);
        Scanner scanInput = new Scanner(System.in);
        int lookUps = 0, reverseLookUps = 0;
        boolean done = false;
        while (!done) {
            System.out.print("lookup, reverse-lookup, quit (l/r/q)? ");
            String input = scanInput.next();
            switch (input) {
                case "l":
                    System.out.print("last name? ");
                    String lastName = scanInput.next();
                    System.out.print("first name? ");
                    String firstName = scanInput.next();
                    int indexOfLastName = -1, indexOfFirstName = -1;
                    for (int n = 0; n < lastNames.size(); n += 1) {
                        if (lastNames.get(n).equals(lastName)) {
                            indexOfLastName = n;
                            break;
                        }
                    }
                    for (int n = 0; n < firstNames.size(); n += 1) {
                        if (firstNames.get(n).equals(firstName)) {
                            indexOfFirstName = n;
                            break;
                        }
                    }
                    if (indexOfLastName > -1 && indexOfFirstName > -1 && indexOfLastName == indexOfFirstName) {
                        System.out.printf("%s %s's phone number is %s\n\n", firstName, lastName, phoneNumbers.get(indexOfFirstName));
                    }
                    else {
                        System.out.print("-- Name not found\n\n");
                    }
                    lookUps += 1;
                    break;
                case "r":
                    System.out.print("phone number (nnn-nnn-nnnn)? ");
                    String phoneNumber = scanInput.next();
                    int indexOfPhoneNumber = -1;
                    for (int n = 0; n < phoneNumbers.size(); n += 1) {
                        if (phoneNumbers.get(n).equals(phoneNumber)) {
                            indexOfPhoneNumber = n;
                            break;
                        }
                    }
                    if (indexOfPhoneNumber > -1) {
                        System.out.printf("%s belongs to %s, %s\n\n", phoneNumber, lastNames.get(indexOfPhoneNumber), firstNames.get(indexOfPhoneNumber));
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
                    System.out.print("Invalid input!\n\n");
            }
        }
        scanInput.close();
        System.out.printf("\n%d lookups performed\n", lookUps);
        System.out.printf("%d reverse lookups performed", reverseLookUps);
    }
    public static void scanDetails(ArrayList<String> lastNames, ArrayList<String> firstNames, ArrayList<String> phoneNumbers) throws IOException {
        Scanner scanDetails = new Scanner(new File("./phonebook.text"));
        while (scanDetails.hasNext()) {
            lastNames.add(scanDetails.next());
            firstNames.add(scanDetails.next());
            phoneNumbers.add(scanDetails.next());
        }
        scanDetails.close();
    }
}