class Add {
    int add(Scanner sc) {
        if (!sc.hasNext()) return 0;
        return sc.nextInt() + add(sc);
    }
}
