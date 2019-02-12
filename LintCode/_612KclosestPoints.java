import java.util.PriorityQueue;
import java.util.Comparator;

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

 class Point {
	 int x;
     int y;
     Point() { x = 0; y = 0; }
     Point(int a, int b) { x = a; y = b; }
 }
public class _612KclosestPoints {
    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        if(points.length <= k) return points;
        PriorityQueue<Point> queue = new PriorityQueue<>(k, new Comparator<Point>(){
            public int compare(Point a, Point b){
                int tempA = (a.x - origin.x)*(a.x - origin.x) + (a.y - origin.y)*(a.y - origin.y);
                int tempB = (b.x - origin.x)*(b.x - origin.x) + (b.y - origin.y)*(b.y - origin.y);
                int sub = tempB - tempA;
                if(sub == 0){
                    sub = b.x - a.x;
                    if(sub == 0){
                        sub = b.y - a.y;
                    }
                }
                return sub;
                
            }
        });
        
        for(int i = 0; i < points.length; i++){
            queue.offer(points[i]);
            if(queue.size() > k) queue.poll();
        }
        
        Point[] result = new Point[k];
        int i = k - 1;
        for(; i >= 0; i--){
            result[i] = queue.poll();
        }
        return result;
    }
}
