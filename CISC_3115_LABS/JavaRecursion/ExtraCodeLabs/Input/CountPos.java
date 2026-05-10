class CountPos {
    int countPos(Scanner sc) {
        if (!sc.hasNext()) return 0;
        int num  = sc.nextInt();
        if (num > 0) return 1 + countPos(sc);
        return countPos(sc);
    }
}
