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
    static int m;
    static List<Position> houseAxis = new ArrayList<>();
    static List<Position> pizzaAxis = new ArrayList<>();
    static int[] pizzaCombi;

    static int minDist = Integer.MAX_VALUE;

    void DFS(int level, int idx){
        if(level == m) {
//            for(int x : pizzaCombi){
//                System.out.print(pizzaAxis.get(x).x + ", " + pizzaAxis.get(x).y + " | ");
//            }
//            System.out.println();

            int totalDeliveryDist = 0;
            for(Position house : houseAxis){
                int minDist = Integer.MAX_VALUE;
                for(int pizza : pizzaCombi){
                    int dist = Math.abs(house.x - pizzaAxis.get(pizza).x)
                            + Math.abs(house.y - pizzaAxis.get(pizza).y);
                    minDist = Math.min(minDist, dist);
                }
                totalDeliveryDist += minDist;
            }
//            System.out.println("minDist : " + totalDeliveryDist);
            minDist = Math.min(minDist, totalDeliveryDist);
        } else {
            for(int i=idx; i<pizzaAxis.size(); i++){
                pizzaCombi[level] = i;
                DFS(level + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        _15_Pizza_Delivery_Distance main = new _15_Pizza_Delivery_Distance();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        m = sc.nextInt();
        pizzaCombi = new int[m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int value = sc.nextInt();
                if(value == 1) houseAxis.add(new Position(i, j));
                if(value == 2) pizzaAxis.add(new Position(i, j));
            }
        }

        main.DFS(0, 0);
        System.out.println(minDist);
    }
}

class _15_Pizza_Delivery_Distance_Inflearn {
    static int n, m, len, answer = Integer.MAX_VALUE;
    static int[] combi;
    static ArrayList<Point> hs, pz;

    public void DFS(int L, int s) {
        if (L == m) {
            int sum = 0;
            for (Point h : hs) {
                int dis = Integer.MAX_VALUE;
                for (int i : combi) {
                    dis = Math.min(dis, Math.abs(h.x - pz.get(i).x) + Math.abs(h.y - pz.get(i).y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i = s; i < len; i++) {
                combi[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        _15_Pizza_Delivery_Distance_Inflearn T = new _15_Pizza_Delivery_Distance_Inflearn();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        pz = new ArrayList<>();
        hs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = kb.nextInt();
                if (tmp == 1) hs.add(new Point(i, j));
                else if (tmp == 2) pz.add(new Point(i, j));
            }
        }
        len = pz.size();
        combi = new int[m];
        T.DFS(0, 0);
        System.out.println(answer);
    }
}


/**
 * pizzaCoordinate, houseCoordinate 에 각각 피자, 집의 좌표를 저장한다.
 * */
class _15_Pizza_Delivery_Distance_Practice{
    static List<Position> pizzaCoordinate, houseCoordinate;
    static int[] pizzaCombination;  // 피자집의 조합을 저장 (피자집 리스트의 인덱스를 저장)
    static int m, pizzaNumber, minDist = Integer.MAX_VALUE;

    void DFS(int level, int startPoint){
        if(level == m){
            int totalPizzaDist = 0;
            for(Position house : houseCoordinate){
                int minPizzaDist = Integer.MAX_VALUE;
                for(int index : pizzaCombination){
                    int dist = Math.abs(house.x - pizzaCoordinate.get(index).x)
                            + Math.abs(house.y - pizzaCoordinate.get(index).y);
                    minPizzaDist = Math.min(minPizzaDist, dist);
                }
                totalPizzaDist += minPizzaDist;

            }
            minDist = Math.min(minDist, totalPizzaDist);
        }else {
            for(int i=startPoint; i<pizzaNumber; i++){
                pizzaCombination[level] = i;
                DFS(level+1, i+1);
            }
        }
    }

    public static void main(String[] args) {
        _15_Pizza_Delivery_Distance_Practice main = new _15_Pizza_Delivery_Distance_Practice();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        m = sc.nextInt();

        // 피자 가게, 집의 위치 좌표를 저장할 리스트
        pizzaCoordinate = new ArrayList<>();
        houseCoordinate = new ArrayList<>();
        pizzaCombination = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int categori = sc.nextInt();
                if (categori == 1) houseCoordinate.add(new Position(i, j));
                if (categori == 2) pizzaCoordinate.add(new Position(i, j));
            }
        }

        pizzaNumber = pizzaCoordinate.size();
        main.DFS(0, 0);
        System.out.println(minDist);
    }
}
