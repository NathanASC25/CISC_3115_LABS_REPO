import java.util.NoSuchElementException;
public class BinarySearch {
    public int binarySearch(int[] arr, int high, int low, int target) {
        if (low >= high || low < 0 || high >= arr.length) {
            throw new NoSuchElementException("\nIndex not found\n");
        }
        int mid = (low + (high - low)) / 2;
        if (arr[mid] > target) {
            return binarySearch(arr, mid - 1, low, target);
        }
        if (arr[mid] < target) {
            return binarySearch(arr, high, mid + 1, target);
        }
        return mid;
    }
}
