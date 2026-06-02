class Exercise_8_3 {
    public static void main(String[] args) {
        System.out.printf("\nFactorial of 4: %d\n", prod(1,4));
    }
    // Method of calculating the factorial
    static int prod(int m, int n) {
        if (m == n) return n;
        int recurse = prod(m, n - 1);
        int result = n * recurse;
        return result;
    }
}
