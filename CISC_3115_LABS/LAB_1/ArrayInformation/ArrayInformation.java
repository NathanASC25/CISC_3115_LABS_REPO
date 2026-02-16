import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
public class ArrayInformation {
	public static void printArrContents(double[] arr, int size) {
                if (size <= 0 || size > arr.length || size != arr.length) return;
                System.out.print("The array: {");
                for (int index = 0; index < size - 1; index += 1) {
                        System.out.print(arr[index] + ", ");
                }
                System.out.printf(arr[size - 1] + "}");
                System.out.printf(" contains %d elements", size);
        }
        public static void firstElementOfArr(double[] arr, int size) {
                if (size <= 0) return;
                System.out.print("The first element of the array is " + arr[0]);
        }
        public static void lastElementOfArr(double[] arr, int size) {
                if (size <= 0 || size > arr.length || size != arr.length) return;
                System.out.print("The last element of the array is " + arr[size - 1] + " and is at position " + (size - 1));
        }
        public static void midElementOfArr(double[] arr, int size) {
                if (size <= 0 || size > arr.length || size != arr.length) return;
                double midElement;
                int indexOfMidElement;
                if (size % 2 == 0) {
                        midElement = arr[size / 2 - 1];
                        indexOfMidElement = size / 2 - 1;
                }
                else {
                        midElement = arr[size / 2];
                        indexOfMidElement = size / 2;
                }
                System.out.print("The middle element of the array is " + midElement + " and is at position " + indexOfMidElement);
        }
        public static void largestElementOfArr(double[] arr, int size) {
                if (size <= 0 || size > arr.length || size != arr.length) return;
                double largestElement = arr[0];
                int indexOfLargest = 0;
                for (int index = 1; index < size; index += 1) {
                        if (arr[index] > largestElement) {
                                largestElement = arr[index];
                                indexOfLargest = index;
                        }
                }
                System.out.print("The largest element of the array is " + largestElement + " and is at position " + indexOfLargest);
        }
        public static void smallestElementOfArr(double[] arr, int size) {
                if (size <= 0 || size > arr.length || size != arr.length) return;
                double smallestElement = arr[0];
                int indexOfSmallest = 0;
                for (int index = 1; index < size; index += 1) {
                        if (arr[index] < smallestElement) {
                                smallestElement = arr[index];
                                indexOfSmallest = index;
                        }
                }
                System.out.print("The smallest element of the array is " + smallestElement + " and is at position " + indexOfSmallest);
        }
        public static void main(String[] args) throws IOException {
                File nums = new File("./numbers.text");
                Scanner scanNums = new Scanner(nums);
                double[] arr = new double[scanNums.nextInt()];
                for (int index = 0; index < arr.length; index += 1) {
                        arr[index] = scanNums.nextDouble();
                }
                scanNums.close();
		System.out.print("\n");
                printArrContents(arr, arr.length);
                System.out.print("\n");
                firstElementOfArr(arr, arr.length);
                System.out.print("\n");
                lastElementOfArr(arr, arr.length);
                System.out.print("\n");
                midElementOfArr(arr, arr.length);
                System.out.print("\n");
                largestElementOfArr(arr, arr.length);
                System.out.print("\n");
                smallestElementOfArr(arr, arr.length);
                System.out.print("\n");
        }
}
