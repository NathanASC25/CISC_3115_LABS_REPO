public class JavaRecursion1 {
    public static void main(String[] args) {
        int num = fibonacci(6);
        System.out.printf("\nResult: %d\n", num);
    }
    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    public static int addFun(int n) {
        if (n == 0) return 0;
        if (n == 1) return 2;
        return addFun(n - 1) + addFun(n - 2);
    }
}
