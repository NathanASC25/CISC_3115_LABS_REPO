public class PrintStars {
    void printTriangle(int n) {
        if (n == 0) {
            return;
        }
        if (n > 1) {
            printTriangle(n - 1);
        }
        printStars(n);
    }
    void printStars(int n) {
        String sequence = "";
        for (int index = 0; index < n; index += 1) sequence += "*";
        System.out.println(sequence);
    }
}
