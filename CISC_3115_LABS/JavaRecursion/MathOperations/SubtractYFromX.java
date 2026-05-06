public class SubtractYFromX {
    public int subtractYFromX(int x, int y) {
        if (y == 0 || x < y) {
            return x;
        }
        if (x == 0) {
            return -1 * y;
        }
        x -= 1;
        return subtractYFromX(x, y - 1);
    }
}
