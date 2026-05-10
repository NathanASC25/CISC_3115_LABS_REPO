class Copy {
    void copy(Scanner obj) {
        if (!obj.hasNext()) {
            return;
        }
        System.out.println(obj.next());
        copy(obj);
    }
}
