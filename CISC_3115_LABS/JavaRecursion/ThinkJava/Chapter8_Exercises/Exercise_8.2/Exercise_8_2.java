class Exercise_8_2 {
    public static void main(String[] args) {
        System.out.printf("\nOdd Sum of 5: %d\n", oddSum(5));
    }
    static int oddSum(int num) {
        if (num == 0 || num == 1) return num;
        if (num % 2 == 0) return oddSum(num - 1);
        return num + oddSum(num - 2);
    }
}
