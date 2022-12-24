package InflearnJavaAlgorithm.Section8_DFS_BFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Position{
    int x, y;
    Position(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class _15_Pizza_Delivery_Distance {
    static int[][] map;
    static int m;
    static List<Position> houseAxis = new ArrayList<>();
    static List<Position> pizzaAxis = new ArrayList<>();

    static int minDist = Integer.MAX_VALUE;

    void DFS(int level, List<Position> permutation){
        if(level == pizzaAxis.size()-1)
            return;

        if(permutation.size() == m) {
            int totalDeliveryDist = 0;
            for(Position house : houseAxis){
                int deliveryDist = Integer.MAX_VALUE;
                for(Position pizza : permutation){
                    int dist = Math.abs(house.x - pizza.x) + Math.abs(house.y - pizza.y);
                    deliveryDist = Math.min(deliveryDist, dist);
                }
                totalDeliveryDist += deliveryDist;
            }
            minDist = Math.min(minDist, totalDeliveryDist);
        } else {
            DFS(level+1, permutation);
            permutation.add(pizzaAxis.get(level));
            DFS(level+1, permutation);
        }
    }

    public static void main(String[] args) {
        _15_Pizza_Delivery_Distance main = new _15_Pizza_Delivery_Distance();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1) houseAxis.add(new Position(i, j));
                if(map[i][j] == 2) pizzaAxis.add(new Position(i, j));
            }

        List<Position> permutation = new ArrayList<>();
        main.DFS(0, permutation);
        System.out.println(minDist);
    }
}

class _15_Pizza_Delivery_Distance_Inflearn{}
