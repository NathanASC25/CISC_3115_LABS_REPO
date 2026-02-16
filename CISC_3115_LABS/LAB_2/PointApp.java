import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class PointApp {
        public static void main(String[] args) throws IOException {
                File coords = new File("points.text");
                Scanner scan = new Scanner(coords);
                Point origin = new Point(0,0);
                while (scan.hasNext()) {
                        int x1 = scan.nextInt();
                        int y1 = scan.nextInt();
                        // First point created
                        Point p1 = new Point(x1, y1);
                        int p1Quadrant = p1.quadrant();
                        int x2 = scan.nextInt();
                        int y2 = scan.nextInt();
                        // Second point created
                        Point p2 = new Point(x2, y2);
			int p2Quadrant = p2.quadrant();
                        System.out.print("p1: " + p1 + " (quadrant " + p1Quadrant + ") / p2: " + p2 + " (quadrant " + p2Quadrant + ")");
                        Point combinedPoint = p1.add(p2);
                        int combinedPointQuadrant = combinedPoint.quadrant();
                        System.out.print("\np1+p2: " + combinedPoint + " (quadrant " + combinedPointQuadrant + ")");
                        if (p1.xReflection().equals(p2)) {
                                System.out.print("\np1 and p2 are reflections across the x-axis");
                        }
                        if (p1.yReflection().equals(p2)) {
                                System.out.print("\np1 and p2 are reflections across the y-axis");
                        }
                        if (p1.originReflection().equals(p2)) {
                                System.out.print("\np1 and p2 are reflections through the origin");
                        }
                        if (p1.distance(origin) == p2.distance(origin)) {
                                System.out.print("\np1 and p2 are equidistant from the origin");
                        }
                        double pointsDistance = p1.distance(p2);
                        System.out.print("\nThe distance between " + p1 + " and " + p2 + " is " + pointsDistance);
                        System.out.print("\n\n");
                }
                scan.close();
        }
}
