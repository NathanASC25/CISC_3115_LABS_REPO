import java.lang.ArithmeticException;
public class Main {
    public static void main(String[] args) {
        AddXY add = new AddXY();
	SubtractYFromX subtract = new SubtractYFromX();
        MultiplyXY multiply = new MultiplyXY();
        DivideXByY divide = new DivideXByY();
        int x = 3;
        int y = 2;
        System.out.printf("\nAddition between %d and %d: %d\n", x, y, add.addXY(x, y));
        System.out.printf("\nSubtraction of %d from %d: %d\n", x, y, subtract.subtractYFromX(x, y));
        System.out.printf("\nMultiplication of %d and %d: %d\n", x, y, multiply.multiplyXY(x, y));
        try {
            System.out.printf("\nDivision of %d and %d: %d\n", x, y, divide.divideXByY(x, y));
        }
        catch (ArithmeticException e) {
            System.out.printf("\n%s\n", e);
        }
    }
}
