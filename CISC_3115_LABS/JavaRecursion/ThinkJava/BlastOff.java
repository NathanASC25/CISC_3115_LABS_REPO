class BlastOff {
    public static void main(String[] args) {
        System.out.print("\n");
        blastOff(5);
        System.out.print("\n");
        reverseBlastOff(5);
        System.out.print("\n");
    }
    static void blastOff(int n) {
        if (n == 0) {
            System.out.println("Blastoff!");
        }
        else {
            System.out.println(n);
            blastOff(n - 1);
        }
    }
    static void reverseBlastOff(int n) {
        if (n == 0) System.out.println("Blastoff!");
	else {
            reverseBlastOff(n - 1);
            System.out.println(n);
        }
    }
}
