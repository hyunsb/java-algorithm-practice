package InflearnJavaAlgorithm.Section6_Sorting_And_Searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _7_Coordinate_Alignment {
    public static void main(String[] args) {
        _7_Coordinate_Alignment T = new _7_Coordinate_Alignment();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Point> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.add(new Point(x, y));
        }
        Collections.sort(arr);
        for(Point o : arr) System.out.println(o.x + " " + o.y);
    }
}

class Point implements Comparable<Point> {
    public int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if(this.x == o.x)
            return this.y - o.y;
        else return this.x - o.x;
    }
}
