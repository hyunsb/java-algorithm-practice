package InflearnJavaAlgorithm.Section7_Recursive_Tree_Graph;

import java.util.Scanner;
class Node{
    int data;
    Node lt, rt;

    public Node(int value){
        data = value;
        lt = rt = null;
    }
}

public class _5_Binary_Tree_Traversal {
    Node root;

    public static void main(String[] args) {
        _5_Binary_Tree_Traversal tree = new _5_Binary_Tree_Traversal();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        tree.postorder(tree.root);
    }

    // 전위순회(preorder)
    public void preorder(Node root){
        if(root == null) return;
        else {
            System.out.print(root.data + " ");
            preorder(root.lt);
            preorder(root.rt);
        }
    }

    // 중위순회(inorder)
    public void inorder(Node root){
        if(root == null) return;
        else {
            inorder(root.lt);
            System.out.print(root.data + " ");
            inorder(root.rt);
        }
    }

    // 후위순회(postorder)
    public void postorder(Node root){
        if(root == null) return;
        else {
            postorder(root.lt);
            postorder(root.rt);
            System.out.print(root.data + " ");
        }
    }
}
