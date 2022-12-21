package InflearnJavaAlgorithm.Section8_DFS_BFS;

import java.util.*;

public class _4_Permutation_With_Repetition_DFS {


	public static void main(String[] args){
		_4_Permutation_With_Repetition_DFS T = new _4_Permutation_With_Repetition_DFS();
		Scanner sc = new Scanner(System.in);
	}
}

class _4_Permutation_With_Repetition_DFS_Inflearn {
	static int[] pm;
	static int n, m;

	public void DFS(int level){
		if(level == m){
			for(int n : pm)
				System.out.print(n + " ");
			System.out.println();
		}else {
			for(int i=1; i<=n; i++){
				pm[level] = i;
				DFS(level+1);
			}
		}
	}

	public static void main(String[] args){
		_4_Permutation_With_Repetition_DFS_Inflearn T = new _4_Permutation_With_Repetition_DFS_Inflearn();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		pm = new int[m];
		T.DFS(0);
	}
}