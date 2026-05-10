class Quotient {
    int quotient(int m, int k) {
        if (k > m) return 0;
        return 1 + quotient(m - k, k);
    }
}
