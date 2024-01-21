import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Node>[] tree;
    static boolean[] isVisit;
    static int n, maxDistance = 0, far;

    private static void DFS(int start, int weight) {
        if (maxDistance < weight) {
            maxDistance = weight;
            far = start;
        }
        isVisit[start] = true;
        for (Node node : tree[start]) {
            if (isVisit[node.root]) continue;
            DFS(node.root, weight + node.weight);
        }
    }

    private static class Node {
        int root;
        int weight;

        public Node(int root, int weight) {
            this.root = root;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer tokenizer;
        tree = new ArrayList[n+1];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int root = Integer.parseInt(tokenizer.nextToken());
            tree[root] = new ArrayList<>();
            while (true) {
                String read;
                if ((read = tokenizer.nextToken()).equals("-1")) break;

                int node = Integer.parseInt(read);
                int weight = Integer.parseInt(tokenizer.nextToken());
                tree[root].add(new Node(node, weight));
            }
        }

        isVisit = new boolean[n+1];
        DFS(1, 0);

        isVisit = new boolean[n+1];
        DFS(far, 0);

        System.out.println(maxDistance);
    }
}