import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(bufferedReader.readLine()));

        String input;
        while ((input = bufferedReader.readLine()) != null) {
            root.insert(Integer.parseInt(input));
        }

        preOrder(root);
    }

    static void preOrder(Node node) {
        if (node == null) return;
        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.num);
    }

    private static class Node {
        int num;
        Node left, right;

        Node(int num) {
            this.num = num;
        }

        void insert(int num){
            if (num < this.num) {
                if (this.left == null) {
                    this.left = new Node(num);
                } else {
                    this.left.insert(num);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(num);
                }else {
                    this.right.insert(num);
                }
            }
        }
    }
}