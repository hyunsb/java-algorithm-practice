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
