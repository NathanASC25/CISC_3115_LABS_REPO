class MakeStarBucks {
    String makeStarBucks(int n) {
        if (n == 0) return "";
        return "*" + makeStarBucks(n - 1) + "$";
    }
}
