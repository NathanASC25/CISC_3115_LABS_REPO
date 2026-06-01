class Exercise_8_1 {
    public static void main(String[] args) {
        song(99);
    }
    static void song(int n) {
        if (n == 0) {
            System.out.println("No bottles of beer on the wall,");
            System.out.println("no bottles of beer,");
            System.out.println("ya' can't take one down, ya' can't pass it around,");
            System.out.println("'cause there are no more battles of beer on the wall!");
            return;
        }
        System.out.printf("%d bottles of beer on the wall,\n", n);
        System.out.printf("%d bottles of beer,\n", n);
        n -= 1;
        System.out.print("ya' take one down, ya' pass it around,\n");
        System.out.printf("%d bottles of beer on the wall.\n\n", n);
        song(n);
    }
}
