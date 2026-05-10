class OddEvenFact {
    long oddevenfact(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return n * oddevenfact(n - 2);
    }
}
