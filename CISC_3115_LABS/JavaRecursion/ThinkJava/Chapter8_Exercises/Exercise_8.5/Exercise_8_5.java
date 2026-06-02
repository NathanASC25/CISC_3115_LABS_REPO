class Exercise_8_5 {
    public static void main(String[] args) {
        System.out.printf("\nResult of 2 to the power of 3: %f\n", power(2,3));
    }
    // Exponentiation function
    static double power(double x, int n) {
        if (n == 0) return 1;
	// Potential modification for even powers
        return x * power(x, n - 1);
    }
}
