class Exercise_8_4 {
    public static void main(String[] args) {
        System.out.print("\nResult of Ackermann function with values m = 4 and n = 1\n");
        System.out.printf("\n%d\n", ack(4, 1));
    }
    // Ackermann function
    static int ack(int m, int n) {
        if (m == 0) return n + 1;
        if (n == 0) return ack(m - 1, 1);
        return ack(m - 1, ack(m, n - 1));
    }
}
