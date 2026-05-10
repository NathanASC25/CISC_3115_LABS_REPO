class Product {
    int product(int m, int k) {
        if (k == 0 || m == 0) return 0;
        if (k == 1) return m;
        if (m == 1) return k;
        return m * product(m, k - 1);
    }
}
