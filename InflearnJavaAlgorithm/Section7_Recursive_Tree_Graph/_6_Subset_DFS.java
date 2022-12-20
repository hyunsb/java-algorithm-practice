package InflearnJavaAlgorithm.Section7_Recursive_Tree_Graph;

public class _6_Subset_DFS {
    static int n;
    static int[] ch;

    public void DFS(int L){
        if(L == n+1){
            String temp = "";
            for(int i=1; i<=n; i++){
                if(ch[i] == 1)
                    temp += (i + " ");
            }

            if(temp.length() > 0)
                System.out.println(temp);
        }
        else {
            ch[L] = 1;
            DFS(L+1);

            ch[L] = 0;
            DFS(L+1);
        }
    }

    public static void main(String[] args) {
        _6_Subset_DFS T = new _6_Subset_DFS();
        n = 3;
        ch = new int[n+1];
        T.DFS(1);
    }
}
