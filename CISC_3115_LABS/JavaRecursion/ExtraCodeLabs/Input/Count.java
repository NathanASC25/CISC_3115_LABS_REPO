class Count {
    int count(Scanner sc) {
        if (!sc.hasNext()) return 0;
        sc.next();
        return 1 + count(sc);
    }
}
