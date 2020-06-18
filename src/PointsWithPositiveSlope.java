import java.util.*;

class Point {
    public int x;
    public int y;
    public Point(int x, int y) {
    this.x = x;
    this.y = y;
   }
 }
public class PointsWithPositiveSlope {
    public int largest(Point[] points) {
        // Write your solution here.
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                return p1.x != p2.x ? p1.x - p2.x : p2.y - p1.y;
            }
        });
        int res = 0;
        int[] M = new int[points.length];
        for (int i = 0; i < M.length; i++) {
            M[i] = 1;
            for (int j = 0; j < i; j++) {
                if (points[j].y < points[i].y) {
                    M[i] = Math.max(M[i], M[j] + 1);
                }
            }
            res = Math.max(res, M[i]);
        }
        return res == 1 ? 0 : res;
        // return 0;
    }
    public static void main(String[] args) {
        PointsWithPositiveSlope solution = new PointsWithPositiveSlope();
        Point[] points = new Point[2];
        points[0] = new Point(1, 2);
        points[1] = new Point(1, 3);

//        points[2] = new Point(2, 5);
        System.out.println(solution.largest(points));
    }
}
