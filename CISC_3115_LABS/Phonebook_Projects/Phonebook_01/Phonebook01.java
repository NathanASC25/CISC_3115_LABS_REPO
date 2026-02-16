import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Phonebook01 {
    public static void main(String[] args) throws IOException {
        final int SIZE = scanNumOfFileLines();
        String[] firstNames = new String[SIZE];
        String[] lastNames = new String[SIZE];
        String[] phoneNumbers = new String[SIZE];
        scanDetails(firstNames, lastNames, phoneNumbers);
        Scanner scanInput = new Scanner(System.in);
        int lookUps = 0, reverseLookUps = 0;
        boolean done = false;
	    while (!done) {
            System.out.printf("lookup, reverse-lookup, quit (l/r/q)? ");
            String input = scanInput.next();
            switch (input) {
                case "l":
                    System.out.print("last name? ");
                    String lastName = scanInput.next();
                    System.out.print("first name? ");
                    String firstName = scanInput.next();
                    // Index Value of -1 in case which ever name is not found
                    int indexOfFirstName = -1, indexOfLastName = -1;
                    for (int n = 0; n < firstNames.length; n += 1) {
                        if (firstNames[n].equals(firstName)) {
                            indexOfFirstName = n;
                            break;
                        }
                    }
                    for (int n = 0; n < lastNames.length; n += 1) {
                        if (lastNames[n].equals(lastName)) {
                            indexOfLastName = n;
                            break;
                        }
                    }
                    if (indexOfFirstName > -1 && indexOfLastName > -1 && indexOfFirstName == indexOfLastName) {
                        System.out.printf("%s %s's phone number is %s\n\n", firstName, lastName, phoneNumbers[indexOfFirstName]);
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
                    for (int n = 0; n < phoneNumbers.length; n += 1) {
                        if (phoneNumbers[n].equals(phoneNumber)) {
                            indexOfPhoneNumber = n;
                            break;
                        }
                    }
                    if (indexOfPhoneNumber > -1) {
                        System.out.printf("%s belongs to %s, %s\n\n", phoneNumber, lastNames[indexOfPhoneNumber], firstNames[indexOfPhoneNumber]);
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
                    System.out.printf("Invalid input!\n\n");
            }
        }
        scanInput.close();
        System.out.printf("\n%d lookups performed\n", lookUps);
        System.out.printf("%d reverse lookups performed", reverseLookUps);
    }
    public static int scanNumOfFileLines() throws IOException {
        int numOfLines = 0;
        Scanner scanNumOfFileLines = new Scanner(new File("./phonebook.text"));
        while (scanNumOfFileLines.hasNext()) {
            numOfLines += 1;
            scanNumOfFileLines.next();
            scanNumOfFileLines.next();
            scanNumOfFileLines.next();
        }
        return numOfLines;
    }
    public static void scanDetails(String[] firstNames, String[] lastNames, String[] phoneNumbers) throws IOException {
        int index = 0;
        Scanner scanDetails = new Scanner(new File("./phonebook.text"));
        while (scanDetails.hasNext()) {
            lastNames[index] = scanDetails.next();
            firstNames[index] = scanDetails.next();
            phoneNumbers[index] = scanDetails.next();
            index += 1;
        }
        scanDetails.close();
    }
}