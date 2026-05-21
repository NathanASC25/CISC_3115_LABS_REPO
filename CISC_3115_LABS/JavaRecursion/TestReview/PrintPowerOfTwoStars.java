import java.lang.ArithmeticException;
class PrintPowerOfTwoStars {
    static int fibonacci(int n) {
        if (n == 0 || n == 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    static void makeLineOfChars(int n, char c) {
        if (n == 0) {
            System.out.println();
            return;
        }
        System.out.print(c);
        makeLineOfChars(n - 1, c);
    }
    static void printChars(int n, char c) {
        if (n == 0) return;
        System.out.print(c);
        printChars(n - 1, c);
    }
    static void printTriangle(int n) {
        if (n == 0) return;
        if (n > 1) printTriangle(n - 1);
        makeLineOfChars(n, '*');
    }
    static void printPascalTriangle(int n, int k) {
        if (n <= 0) return;
        printChars(k / 2, ' ');
        printChars(n, '*');
        System.out.println();
        printPascalTriangle(n - 2, k + 2);
    }
    static void printPowerOfThreeStars(int n) {
        if (n == 0) {
            System.out.print("*");
            return;
        }
        if (n >= 1) {
            printPowerOfThreeStars(n - 1);
            printPowerOfThreeStars(n - 1);
            printPowerOfThreeStars(n - 1);
        }
    }
    static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }
    static int divide(int dividend, int divisor) {
        if (divisor == 0) throw new ArithmeticException("Divison by zero!");
        if (dividend < divisor) return 0;
        return 1 + divide(dividend - divisor, divisor);
    }
    static int multiply(int x, int y) {
        if (x == 0 || y == 0) return 0;
        return x + multiply(x, y - 1);
    }
    static int multiply1(int x, int y) {
        int total = 0;
        while (y > 0) {
            total += x;
            y -= 1;
        }
        return total;
    }
    static int divideBy2(int x) {
        if (x < 2) return 0;
        return 1 + divideBy2(x - 2);
    }
    static int multiplyBy2(int x) {
        if (x == 0) return 0;
        return 2 + multiplyBy2(x - 1);
    }
    public static void main(String[] args) {
        System.out.printf("\nProduct of 3 and 4: %d\n", multiply1(3, 4));
    }
}
