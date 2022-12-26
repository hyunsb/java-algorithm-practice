package Section8_DFS_BFS;

import java.util.*;

/**
 * 중복순열 구하기
 * </br>
 * 1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열
 * 하는 방법을 모두 출력합니다.
 * */

public class _4_Permutation_With_Repetition_DFS {
	static int n, m;
	static int[] permutation;

	void DFS(int level){
		if(level == m){
			for (int num : permutation)
				System.out.print(num + " ");
			System.out.println();
			return;
		}

		for(int i=1; i<=n; i++){
			permutation[level] = i;
			DFS(level+1);
		}
	}

	public static void main(String[] args){
		_4_Permutation_With_Repetition_DFS T = new _4_Permutation_With_Repetition_DFS();
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		permutation = new int[m];

		T.DFS(0);
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