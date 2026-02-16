import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class Averages {
        public static void main(String[] args) throws IOException {
                File nums = new File("./numbers.txt");
                Scanner scanNums = new Scanner(nums);
                int numOfSets = 0;
                while (scanNums.hasNextInt()) {
                        int total = 0;
                        int iterations = scanNums.nextInt();
                        System.out.printf("\nThe average of the %d integers ", iterations);
                        for (int n = iterations; n > 0; n -= 1) {
                                int num = scanNums.nextInt();
                                System.out.printf("%d ", num);
                                total += num;
                        }
                        double avg = (double) total / iterations;
                        System.out.printf("is %.1f", avg);
                        numOfSets += 1;
                }
                System.out.printf("\n%d sets of numbers processed", numOfSets);
                System.out.println();
        }
}
