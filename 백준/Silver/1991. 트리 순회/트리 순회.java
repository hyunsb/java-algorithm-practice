import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

class Main {

    static Node root = new Node('A', null, null);

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer tokenizer;
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());

            char value = tokenizer.nextToken().charAt(0);
            char left = tokenizer.nextToken().charAt(0);
            char right = tokenizer.nextToken().charAt(0);

            insertNode(root, value, left, right);
        }

        StringBuilder result = new StringBuilder();
        preorder(root, result);
        System.out.println(result);

        result = new StringBuilder();
        inorder(root, result);
        System.out.println(result);

        result = new StringBuilder();
        postorder(root, result);
        System.out.println(result);
    }

    public static void preorder(Node node, StringBuilder result) {
        if (Objects.isNull(node)) return;

        result.append(node.value);
        preorder(node.left, result);
        preorder(node.right, result);
    }

    public static void inorder(Node node, StringBuilder result) {
        if (Objects.isNull(node)) return;

        inorder(node.left, result);
        result.append(node.value);
        inorder(node.right, result);
    }

    public static void postorder(Node node, StringBuilder result) {
        if (Objects.isNull(node)) return;

        postorder(node.left, result);
        postorder(node.right, result);
        result.append(node.value);
    }

    public static void insertNode(Node temp, char value, char left, char right) {
        if (temp.value == value) {
            temp.left = (left == '.') ? null : new Node(left, null, null);
            temp.right = (right == '.') ? null : new Node(right, null, null);
        } else {
            if (temp.left != null) insertNode(temp.left, value, left, right);
            if (temp.right != null) insertNode(temp.right, value, left, right);
        }
    }

    static class Node {
        char value;
        Node left;
        Node right;

        public Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
