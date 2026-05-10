class Harmonic {
    double harmonic(int n) {
        if (n == 1) return 1;
        return (1 / (double) n) + harmonic(n - 1);
    }
}
