public class AddXY {
    public int addXY(int x, int y) {
        if (x <= 0) {
            return y;
        }
        if (y <= 0) {
            return x;
        }
        x += 1;
        return addXY(x, y - 1);
    }
}
