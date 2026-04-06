import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
class PhonebookApp {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.print("Usage: PhonebookApp 'phonebook-filename'\n");
            return;
        }
        boolean done = false;
        int lookUps = 0;
        Scanner in = new Scanner(System.in);
        Phonebook phonebook = new Phonebook(args[0]);
        while (!done) {
            System.out.print("lookup, quit (l/q)? ");
            String input = in.next();
            int indexOfEntry = -1;
            switch (input) {
                case "l":
                    phonebook.lookup(in);
                    lookUps += 1;
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
    }
}

class Phonebook {
    private String fileName;
    private Map<String, ArrayList<String>> entries = new HashMap<>();
    private static Scanner scanEntries;
    public Phonebook(String fileName) {
        this.fileName = fileName;
        try {
            scanEntries = new Scanner(new File("./" + fileName));
            while (scanEntries.hasNext()) {
                ArrayList<String> numbers = new ArrayList<>();
                String lastName = scanEntries.next();
                String firstName = scanEntries.next();
                int numOfIterations = scanEntries.nextInt();
                for (int i = 0; i < numOfIterations; i += 1) {
                    String numberType = scanEntries.next();
                    String number = scanEntries.next();
                    numbers.add(numberType + ": " + number);
                }
                entries.put(firstName + " " + lastName, numbers);
            }
            scanEntries.close();
        }
        //catch (ArrayIndexOutOfBoundsException e) {
        //    System.out.print("*** Exception *** Phonebook capacity exceeded - increase size of underlying array\n");
          //  System.exit(0);
        //}
        catch (IOException e) {
            System.out.print("*** IOException *** phonebook text (No such file or directory\n");
            System.exit(0);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
    public void lookup(Scanner sc) {
        System.out.print("last name? ");
        String lastName = sc.next();
        System.out.print("first name? ");
        String firstName = sc.next();
        //for (int n = 0; n < entries.size(); n += 1) {
            // Make sure entries are not null
           // if (entries[n] != null && entries[n].getName().equals(tempName)) {
             //   indexOfEntry = n;
              //  break;
            //}
        //}
        String fullName = firstName + " " + lastName;
        if (entries.containsKey(fullName)) {
            System.out.print(fullName + "'s phone numbers: " + entries.get(fullName) + "\n\n");
        }
        else {
            System.out.print("-- Name not found\n\n");
        }
    }
}
