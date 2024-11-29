import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int l = Integer.parseInt(tokenizer.nextToken());
        StringBuilder answer = new StringBuilder();
        
        tokenizer = new StringTokenizer(bufferedReader.readLine());
        Deque<Node> myDeque = new LinkedList<>();

        
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(tokenizer.nextToken());
            
            while (!myDeque.isEmpty() && myDeque.getLast().value > now) {
                myDeque.removeLast();
            }
            myDeque.addLast(new Node(now, i));
            
            if (myDeque.getFirst().index <= i - l) {
                myDeque.removeFirst();
            }
            
            answer.append(myDeque.getFirst().value).append(" ");
        }
        System.out.println(answer);
    }
    
    static class Node {
        
        public int value, index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}