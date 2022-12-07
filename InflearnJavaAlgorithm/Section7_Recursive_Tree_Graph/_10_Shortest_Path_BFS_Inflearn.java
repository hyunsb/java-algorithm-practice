package InflearnJavaAlgorithm.Section7_Recursive_Tree_Graph;

import java.util.LinkedList;
import java.util.Queue;

public class _10_Shortest_Path_BFS_Inflearn {
    Node_10 root;
    public static void main(String[] args) {
        _10_Shortest_Path_BFS_Inflearn tree = new _10_Shortest_Path_BFS_Inflearn();
        tree.root = new Node_10(1);
        tree.root.lt = new Node_10(2);
        tree.root.rt = new Node_10(3);
        tree.root.lt.lt = new Node_10(4);
        tree.root.lt.rt = new Node_10(5);
        System.out.println(tree.BFS(tree.root));
    }

    public int BFS(Node_10 root){
        Queue<Node_10> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()){
            int length = queue.size();
            for(int i=0; i<length; i++){
                System.out.print("queue: ");
                for(Node_10 q : queue)
                    System.out.print(q.data + " ");

                System.out.println();
                Node_10 currentNode = queue.poll();
                if(currentNode.lt == null && currentNode.rt == null)
                    return level;
                if(currentNode.lt != null)
                    queue.offer(currentNode.lt);
                if(currentNode.rt != null)
                    queue.offer(currentNode.rt);
            }
            level++;

        }
        return 0;
    }
}
