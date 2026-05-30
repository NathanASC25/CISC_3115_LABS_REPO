class PrintPowerOfTwoStars {
    
void printPowerOfTwoStars(int n) {
    if (n == 0) {
    	System.out.print("*");
        return;
    }
    if (n > 1) {
    	printPowerOfTwoStars(n - 2);
    	if (n > 3) printPowerOfTwoStars(n - 4);
    	System.out.print("*");
    	if (n >= 5) return;
    }
    System.out.print("*");
    printPowerOfTwoStars(n - 1);
    // if (n == 1) return;
    // printPowerOfTwoStars(1);
}

}
