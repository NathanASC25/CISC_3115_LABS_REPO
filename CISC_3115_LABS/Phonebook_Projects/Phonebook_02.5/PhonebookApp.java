import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.util.NoSuchElementException;
class PhonebookApp {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        File textFile = new File("./phonebook.text");
    }
}
class Phonebook {
    private final static int DEFAULTCAPACITY = 100;
    private int numOfElements = 0;
    private File fileName;
    public Phonebook(String fileName, int initialCap) {
        this.fileName = fileName;
        numOfElements = initialCap;
    }
    public Phonebook(String fileName) {
        this.fileName = fileName;
        numOfElements = DEFAULTCAPACITY;
    }
    public int lookup() {
        
    }
    public int reverseLookup() {
        
    }
}
