import java.util.NoSuchElementException;
public class Main {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4};
        BinarySearch obj = new BinarySearch();
        try {
            int index = obj.binarySearch(arr, arr.length - 1, 0, 2);
            System.out.printf("\nIndex of target found at: %d\n", index);
        }
        catch (NoSuchElementException e) {
            System.out.println(e);
        }
    }
}
