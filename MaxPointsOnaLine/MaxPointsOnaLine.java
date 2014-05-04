//============================================================================
// Max Points on a Line
//
// Given n points on a 2D plane, find the maximum number of points that lie
// on the same straight line.
//
//
// Complexity:
// O(n^2) time, O(n^2) space
//============================================================================

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a point.
 */
class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}

public class Solution {
    public int maxPoints(Point[] points) {
        int N = points.length;
        if (N < 3)
            return N;
        int res = 0;
        Map<Integer, Integer> tb = new HashMap<Integer, Integer>();
        for (int i = 0; i < N; i++) {
            tb.clear();
            int o = 0, u = 0, v = 0;
            for (int j = i; j < N; j++) {
                int x = points[j].x - points[i].x, y = points[j].y
                        - points[i].y;
                if (x == 0 && y == 0)
                    o++;
                else if (x == 0)
                    v++;
                else {
                    int k = (int) (1e6 * y / x);
                    tb.put(k, (tb.containsKey(k) ? tb.get(k) : 0) + 1);
                    u = Math.max(u, tb.get(k));
                }
            }
            res = Math.max(res, o + Math.max(u, v));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Point[] points;

        points = new Point[] { new Point(0, 0), new Point(-1, -1),
                new Point(2, 2) };
        System.out.println(sol.maxPoints(points) + "," + 3);

        points = new Point[] { new Point(0, 0), new Point(1, 1),
                new Point(1, -1) };
        System.out.println(sol.maxPoints(points) + "," + 2);

        points = new Point[] { new Point(0, 0), new Point(1, 1),
                new Point(0, 0) };
        System.out.println(sol.maxPoints(points) + "," + 3);

        points = new Point[] { new Point(0, -12), new Point(5, 2),
                new Point(2, 5), new Point(0, -5), new Point(1, 5),
                new Point(2, -2), new Point(5, -4), new Point(3, 4),
                new Point(-2, 4), new Point(-1, 4), new Point(0, -5),
                new Point(0, -8), new Point(-2, -1), new Point(0, -11),
                new Point(0, -9) };
        System.out.println(sol.maxPoints(points) + "," + 6);

        points = new Point[] { new Point(0, 9), new Point(138, 429),
                new Point(115, 359), new Point(115, 359), new Point(-30, -102),
                new Point(230, 709), new Point(-150, -686),
                new Point(-135, -613), new Point(-60, -248),
                new Point(-161, -481), new Point(207, 639), new Point(23, 79),
                new Point(-230, -691), new Point(-115, -341),
                new Point(92, 289), new Point(60, 336), new Point(-105, -467),
                new Point(135, 701), new Point(-90, -394),
                new Point(-184, -551), new Point(150, 774) };
        System.out.println(sol.maxPoints(points) + "," + 12);

        points = new Point[] { new Point(560, 248), new Point(0, 16),
                new Point(30, 250), new Point(950, 187), new Point(630, 277),
                new Point(950, 187), new Point(-212, -268),
                new Point(-287, -222), new Point(53, 37),
                new Point(-280, -100), new Point(-1, -14), new Point(-5, 4),
                new Point(-35, -387), new Point(-95, 11), new Point(-70, -13),
                new Point(-700, -274), new Point(-95, 11), new Point(-2, -33),
                new Point(3, 62), new Point(-4, -47), new Point(106, 98),
                new Point(-7, -65), new Point(-8, -71), new Point(-8, -147),
                new Point(5, 5), new Point(-5, -90), new Point(-420, -158),
                new Point(-420, -158), new Point(-350, -129),
                new Point(-475, -53), new Point(-4, -47), new Point(-380, -37),
                new Point(0, -24), new Point(35, 299), new Point(-8, -71),
                new Point(-2, -6), new Point(8, 25), new Point(6, 13),
                new Point(-106, -146), new Point(53, 37), new Point(-7, -128),
                new Point(-5, -1), new Point(-318, -390), new Point(-15, -191),
                new Point(-665, -85), new Point(318, 342), new Point(7, 138),
                new Point(-570, -69), new Point(-9, -4), new Point(0, -9),
                new Point(1, -7), new Point(-51, 23), new Point(4, 1),
                new Point(-7, 5), new Point(-280, -100), new Point(700, 306),
                new Point(0, -23), new Point(-7, -4), new Point(-246, -184),
                new Point(350, 161), new Point(-424, -512), new Point(35, 299),
                new Point(0, -24), new Point(-140, -42), new Point(-760, -101),
                new Point(-9, -9), new Point(140, 74), new Point(-285, -21),
                new Point(-350, -129), new Point(-6, 9), new Point(-630, -245),
                new Point(700, 306), new Point(1, -17), new Point(0, 16),
                new Point(-70, -13), new Point(1, 24), new Point(-328, -260),
                new Point(-34, 26), new Point(7, -5), new Point(-371, -451),
                new Point(-570, -69), new Point(0, 27), new Point(-7, -65),
                new Point(-9, -166), new Point(-475, -53), new Point(-68, 20),
                new Point(210, 103), new Point(700, 306), new Point(7, -6),
                new Point(-3, -52), new Point(-106, -146), new Point(560, 248),
                new Point(10, 6), new Point(6, 119), new Point(0, 2),
                new Point(-41, 6), new Point(7, 19), new Point(30, 250) };
        System.out.println(sol.maxPoints(points) + "," + 22);
    }
}