package InflearnJavaAlgorithm.Section6_Sorting_And_Searching;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _4_Least_Recnetly_Used {
    public static void main(String[] args) {
        _4_Least_Recnetly_Used T = new _4_Least_Recnetly_Used();
        Scanner sc = new Scanner(System.in);

        int cacheSize = sc.nextInt();
        int n = sc.nextInt();
        int[] taskNum = new int[n];
        for(int i=0; i<n; i++) taskNum[i] = sc.nextInt();
        for(int i : T.solution(cacheSize, taskNum)) System.out.print(i + " ");
        System.out.println();
        for(int i : T.solution2(cacheSize, taskNum)) System.out.print(i + " ");
    }

    public int[] solution2(int cacheSize, int[] taskNum){
        int[] cache = new int[cacheSize];

        for(int task : taskNum){
            int pos = -1;
            for(int i=0; i<cacheSize; i++) if( task == cache[i]) pos = i; // cache hit

            if(pos == -1) {
                for(int i=cacheSize-1; i>=1; i--)
                    cache[i] = cache[i-1];
                cache[0] = task;
            }else {
                for(int i=pos; i>=1; i--)
                    cache[i] = cache[i-1];
                cache[0] = task;
            }
        }

        return cache;
    }

    public Queue<Integer> solution(int cacheSize, int[] taskNum){
        Deque<Integer> cache = new LinkedList<>();
        Queue<Integer> task = new LinkedList<>();

        for(int i : taskNum)
            task.offer(i);

        for(int i=0; i<cacheSize; i++)
            cache.offerFirst(task.poll());

        while (!task.isEmpty()){

            if(cache.contains(task.peek())) {
                cache.remove(task.peek());
                cache.offerFirst(task.poll());
            }else {
                cache.offerFirst(task.poll());
                cache.removeLast();
            }
        }

        return cache;
    }
}
