public class MakeStars {
    void printTriangle(int n) {
        if (n < 1) {
            return;
        }
        System.out.println(makeStars(n));
        printTriangle(n - 1);
    }
    String makeStars(int n) {
        String sequence = "";
        for (int index = 0; index < n; index += 1) sequence += "*";
        return sequence;
    }
}
