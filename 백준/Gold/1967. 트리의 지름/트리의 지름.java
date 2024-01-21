import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Node>[] tree;
    static boolean[] isVisit;
    static int n, far, maxDistance = 0;

    private static void DFS(int start, int weight) {
        if (maxDistance < weight) {
            maxDistance = weight;
            far = start;
        }
        isVisit[start] = true;
        for (Node node : tree[start]) {
            if (isVisit[node.vertex]) continue;
            DFS(node.vertex, weight + node.weight);
        }
    }

    private static class Node {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());

        tree = new ArrayList[n+1];
        for (int i = 0; i < n + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer tokenizer;
        for (int i = 0; i < n-1; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int root = Integer.parseInt(tokenizer.nextToken());
            int vertex = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());

            tree[root].add(new Node(vertex, weight));
            tree[vertex].add(new Node(root, weight));
        }

        isVisit = new boolean[n+1];
        DFS(1, 0);

        isVisit = new boolean[n+1];
        DFS(far, 0);

        System.out.println(maxDistance);
    }
}