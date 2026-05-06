public class MultiplyXY {
    public int multiplyXY(int x, int y) {
        if (x == 0 || y == 0) {
            return 0;
        }
        if (y == 1) {
            return x;
        }
        x *= y;
        return multiplyXY(x, y - 1);
    }
}
