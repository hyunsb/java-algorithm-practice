import java.io.*;
import java.util.*;


class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int maxDeadLine = -1;
        Queue<Subject> queue = new PriorityQueue<>();
        
        StringTokenizer tokenizer;
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            
            int deadLine = Integer.parseInt(tokenizer.nextToken());
            int score = Integer.parseInt(tokenizer.nextToken());
            queue.offer(new Subject(deadLine, score));
            
            maxDeadLine = Math.max(maxDeadLine, deadLine);
        }
        
        int answer = 0;
        for (int i = maxDeadLine; i > 0; i--) {
            List<Subject> temp = new ArrayList<>();
            while(!queue.isEmpty()) {
                Subject current = queue.poll();
                
                if (current.deadLine >= i) {
                    answer += current.score;
                    break;
                } else {
                    temp.add(current);
                }
            }
            
            for (Subject s : temp) {
                queue.offer(s);
            }
        }
        
        System.out.println(answer);
    }
    
    private static class Subject implements Comparable<Subject> {
        int deadLine, score;
        
        public Subject(int deadLine, int score) {
            this.deadLine = deadLine;
            this.score = score;
        }
        
        public int compareTo(Subject that) {
            return that.score - this.score;
        }
    }
}