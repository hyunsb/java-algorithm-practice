package InflearnJavaAlgorithm.Section7_Recursive_Tree_Graph;

import java.util.LinkedList;
import java.util.Queue;

class Node_7{
    int data;
    Node_7 lt, rt;
    public Node_7(int val){
        data = val;
        lt = rt = null;
    }
}

public class _7_Binary_Tree_Level_Traversal {
    private Node_7 root;

    public void BFS(Node_7 root){
        Queue<Node_7> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;

        while (!Q.isEmpty()){
            int len = Q.size();
            System.out.print(L + " : ");
            for(int i=0; i<len; i++){
                Node_7 current = Q.poll();
                System.out.print(current.data + " ");

                if(current.lt != null)
                    Q.offer(current.lt);
                if(current.rt != null)
                    Q.offer(current.rt);
            }
            L++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        _7_Binary_Tree_Level_Traversal tree = new _7_Binary_Tree_Level_Traversal();
        tree.root = new Node_7(1);
        tree.root.lt = new Node_7(2);
        tree.root.rt = new Node_7(3);
        tree.root.lt.lt = new Node_7(4);
        tree.root.lt.rt = new Node_7(5);
        tree.root.rt.lt = new Node_7(6);
        tree.root.rt.rt = new Node_7(7);
        tree.BFS(tree.root);
    }

}
