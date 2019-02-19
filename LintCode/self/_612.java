package self;

import java.util.Comparator;
import java.util.PriorityQueue;

// Given some points and an origin point in two-dimensional space, 
// find k points which are nearest to the origin.
// Return these points sorted by distance, if they are same in distance, 
// sorted by the x-axis, and if they are same in the x-axis, sorted by y-axis.

public class _612 {
	public Point[] kClosest(Point[] points, Point origin, int k) {
		// check input
		if (k <= 0) {
			return new Point[0];
		}
		Point[] arrPoint = new Point[k];
		if (points == null || points.length == 0 || origin == null) {
			return arrPoint;
		}
/*		if (points.length <= k) {
			return points; // 返回结果无序
		}*/
		
		// init
		PriorityQueue<Point> pQueue = new PriorityQueue<>(k, new Comparator<Point>() {
			public int compare(Point a, Point b) {
				int disA = (a.x - origin.x)*(a.x - origin.x) + (a.y - origin.y)*(a.y - origin.y);
				int disB = (b.x - origin.x)*(b.x - origin.x) + (b.y - origin.y)*(b.y - origin.y);
				int sub = disB - disA;
				if (sub == 0) {
					sub = b.x - a.x;
					if (sub == 0) {
						sub = b.y - a.y;
					}
				}
				return sub;
			}
		});
		
		// loop
		for (Point point : points) {
			pQueue.offer(point);
			if (pQueue.size() > k) {
				pQueue.poll();
			}
		}
				
		// array
		while(!pQueue.isEmpty()) {
			arrPoint[--k] = pQueue.poll();
		}
		
		return arrPoint;
	}
}

class Point {
	 int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}