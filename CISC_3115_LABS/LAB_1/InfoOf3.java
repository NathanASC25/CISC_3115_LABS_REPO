import java.util.Scanner;
public class InfoOf3 {
        public static class HelperMethods {
                private int a;
                private int b;
                private int c;
                public HelperMethods(int a, int b, int c) {
                        this.a = a;
                        this.b = b;
                        this.c = c;
                }
                public boolean allAreEqual() {
                        return a == b && b == c;
                }
                public boolean twoAreEqual() {
			if (a == b && !(b == c)) {
                                return true;
                        }
			else if (b == c && !(a == b)) {
                                return true;
                        }
                        else if (a == c) {
                                return true;
                        }
                        return false;
                }
                public boolean noneAreEqual() {
                        if (allAreEqual()) {
                                return false;
                        }
                        return !(twoAreEqual());
                }
                public boolean areAscending() {
                        return a <= b && b <= c;
                }
                public boolean areDescending() {
                        return a >= b && b >= c;
                }
                public boolean strictlyAscending() {
                        return a < b && b < c;
                }
                public boolean strictlyDescending() {
                        return a > b && b > c;
                }
        }
        public static void main(String[] args) {
                Scanner scan = new Scanner(System.in);
                System.out.print("first number? ");
                int firstNum = scan.nextInt();
                System.out.print("second number? ");
                int secondNum = scan.nextInt();
                System.out.print("third number? ");
                int thirdNum = scan.nextInt();
                scan.close();
                HelperMethods methods = new HelperMethods(firstNum, secondNum, thirdNum);
                boolean allAreEqual = methods.allAreEqual();
                boolean twoAreEqual = methods.twoAreEqual();
                boolean noneAreEqual = methods.noneAreEqual();
                boolean areAscending = methods.areAscending();
                boolean areDescending = methods.areDescending();
                boolean strictlyAscending = methods.strictlyAscending();
                boolean strictlyDescending = methods.strictlyDescending();
                System.out.printf("allAreEqual: %b", allAreEqual);
                System.out.printf("\ntwoAreEqual: %b", twoAreEqual);
                System.out.printf("\nnoneAreEqual: %b", noneAreEqual);
                System.out.printf("\nareAscending: %b", areAscending);
                System.out.printf("\nareDescending: %b", areDescending);
                System.out.printf("\nstrictlyAscending: %b", strictlyAscending);
                System.out.printf("\nstrictlyDescending: %b\n", strictlyDescending);
        }
}
