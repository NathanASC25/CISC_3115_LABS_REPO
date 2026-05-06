public class PrintStars {
    void printTriangle(int n) {
        if (n > 1) {
            printTriangle(n - 1);
        }
        printStars(n);
    }
    void printStars(int n) {
        // Changing text color
	String yellow = "\u001B[33m";
        // Changing background color
        String blueBackground = "\u001B[44m";
        String reset = "\u001B[0m";
        String sequence = "";
        for (int index = 0; index < n; index += 1) sequence += " *";
        System.out.println(yellow + blueBackground + sequence + reset);
    }
}
