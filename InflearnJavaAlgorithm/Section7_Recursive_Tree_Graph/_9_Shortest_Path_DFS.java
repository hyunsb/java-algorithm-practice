package InflearnJavaAlgorithm.Section7_Recursive_Tree_Graph;

import java.util.LinkedList;
import java.util.Queue;


// BFS를 사용하여
// Tree 말단 노드까지의 가장 짧은 경로를 출력한다.

class Node_9{
    int data;
    Node_9 lt, rt;

    public Node_9(int value){
        data = value;
        lt = null;
        rt = null;
    }
}
public class _9_Shortest_Path_DFS {
    Node_9 root;

    int count = Integer.MAX_VALUE;
    Queue<Node_9> nodeQueue = new LinkedList<>();

    public void DFS(Node_9 root){
        System.out.print(root.data);
        if(isTerminalNode(root)) {
            count = Math.min(count, root.data);
            System.out.println(": 말단 노드입니다.");
        }
        else {
            System.out.println();
            DFS(root.lt);
            DFS(root.rt);
        }
    }

    public boolean isTerminalNode(Node_9 node){
        return node.lt == null && node.rt == null;
    }

    public static void main(String[] args) {
        _9_Shortest_Path_DFS tree = new _9_Shortest_Path_DFS();
        tree.root = new Node_9(1);
        tree.root.lt = new Node_9(2);
        tree.root.rt = new Node_9(3);
        tree.root.lt.lt = new Node_9(4);
        tree.root.lt.rt = new Node_9(5);
        tree.DFS(tree.root);
        System.out.println(tree.count);
    }
}
