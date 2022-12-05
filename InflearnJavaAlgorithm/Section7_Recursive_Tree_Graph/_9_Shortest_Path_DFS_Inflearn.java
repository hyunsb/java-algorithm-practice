package InflearnJavaAlgorithm.Section7_Recursive_Tree_Graph;


// BFS를 사용하여
// Tree 말단 노드까지의 가장 짧은 경로를 출력한다.

public class _9_Shortest_Path_DFS_Inflearn {
    Node_9 root;
    public int DFS(int L, Node_9 root){
        if(root.lt == null && root.rt == null) return L;
        else return Math.min(DFS(L+1, root.lt), DFS(L+1, root.rt));
    }

    public static void main(String[] args) {
        _9_Shortest_Path_DFS_Inflearn tree = new _9_Shortest_Path_DFS_Inflearn();
        tree.root = new Node_9(1);
        tree.root.lt = new Node_9(2);
        tree.root.rt = new Node_9(3);
        tree.root.lt.lt = new Node_9(4);
        tree.root.lt.rt = new Node_9(5);
        System.out.println(tree.DFS(0, tree.root));
    }
}
