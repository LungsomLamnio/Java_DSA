package Queue;
import java.util.*;

public class NearestPoints {
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distSqure;
        int indx;

        public Point(int x, int y, int distSqure, int indx) {
            this.x = x;
            this.y = y;
            this.distSqure = distSqure;
            this.indx = indx;
        }

        @Override
        public int compareTo(Point p2) {
            return Integer.compare(this.distSqure, p2.distSqure);
        }
    }
    public static void main(String[] args) {
        int points[][] = {{3,3}, {5,-1}, {-2,4}};
        int k=2;

        PriorityQueue<Point> p = new PriorityQueue<>();

        for(int i=0; i<points.length; i++) {
            int distSqure = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            p.add(new Point(points[i][0], points[i][1], distSqure, i));
        }

        for(int i=0; i<k; i++) {
            System.out.println("C" + p.remove().indx);
        }
    }
}
