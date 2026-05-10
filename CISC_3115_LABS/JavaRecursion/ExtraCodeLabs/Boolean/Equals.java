class Equals {
    boolean equals(int x, int y) {
        if (x == 0 && y == 0 || x - 1 == y - 1) return true;
        if (x < 0 || y < 0) return false;
        return equals(x - 1, y - 1);
    }
}
