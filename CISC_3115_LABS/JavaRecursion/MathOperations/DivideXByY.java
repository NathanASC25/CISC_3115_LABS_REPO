import java.lang.ArithmeticException;
public class DivideXByY {
    public int divideXByY(int x, int y) {
        if (x <= 0 || y < 0) {
            return 0;
        }
        if (y == 0) {
            throw new ArithmeticException();
        }
        if (y == 1) {
            return x;
        }
        x /= y;
        return divideXByY(x, y - 1);
    }
}
