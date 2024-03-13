import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {

    static int[] mx = {1, -1, 0, 0};
    static int[] my = {0, 0, 1, -1};

    static Map<Integer, Integer> oilGroup = new HashMap<>();
    static int groupSequence = 1;
    static int n, m;

//    public static void main(String[] args) {
//        Solution1 solution1 = new Solution1();
//        int solution = solution1.solution(
//            new int[][]{
//                {0, 0, 0, 1, 1, 1, 0, 0},
//                {0, 0, 0, 0, 1, 1, 0, 0},
//                {1, 1, 0, 0, 0, 1, 1, 0},
//                {1, 1, 1, 0, 0, 0, 0, 0},
//                {1, 1, 1, 0, 0, 0, 1, 1}
//            });
//        System.out.println(solution);
//    }

    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (land[y][x] == 1) {
                    findGroup(x, y, groupSequence += 1, land);
                }
            }
        }

        int answer = 0;
        for (int x = 0; x < m; x++) {
            int oil = 0;
            Set<Integer> getOilGroup = new HashSet<>();
            for (int y = 0; y < n; y++) {
                if (land[y][x] != 0) {
                    getOilGroup.add(land[y][x]);
                }
            }

            for (Integer group : getOilGroup) {
                oil += oilGroup.get(group);
            }

            if (oil > answer) {
                answer = oil;
            }
        }
        return answer;
    }

    private void findGroup(int x, int y, int groupNumber, int[][] land) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        land[y][x] = groupNumber;
        int oilCount = 0;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int cx = current.x;
            int cy = current.y;

            oilCount += 1;

            for (int i = 0; i < 4; i++) {
                int nx = cx + mx[i];
                int ny = cy + my[i];

                try {
                    if (land[ny][nx] == 1) {
                        land[ny][nx] = groupNumber;
                        queue.add(new Point(nx, ny));
                    }
                } catch (ArrayIndexOutOfBoundsException ignored) {}
            }
        }
        oilGroup.put(groupNumber, oilCount);
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}