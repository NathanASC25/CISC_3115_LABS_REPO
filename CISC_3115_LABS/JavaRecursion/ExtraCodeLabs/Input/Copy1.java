class Copy1 {
    void copy(Scanner sc) {
        if (!sc.hasNext()) {
            return;
        }
        String word = sc.next();
        copy(sc);
        System.out.println(word);
    }
}
