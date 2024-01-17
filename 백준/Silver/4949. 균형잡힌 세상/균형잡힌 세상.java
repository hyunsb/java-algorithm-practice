import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String endCharacter = ".";
        while (true) {
            String sentence = bufferedReader.readLine();
            if (endCharacter.equals(sentence)) break;

            if (!sentence.endsWith(endCharacter) ||
                    sentence.length() > 100 ||
                    !isCorrectBrackets(sentence)) {
                System.out.println("no");
            } else System.out.println("yes");
        }
    }

    private static boolean isCorrectBrackets(String sentence) {
        Stack<Character> brackets = new Stack<>();
        for (char c : sentence.toCharArray()) {
            if (c == '(' || c == '[') brackets.add(c);
            if (c == ')') {
                if (brackets.isEmpty() || brackets.peek() != '(') return false;
                brackets.pop();
            }
            if (c == ']') {
                if (brackets.isEmpty() || brackets.peek() != '[') return false;
                brackets.pop();
            }
        }
        return brackets.isEmpty();
    }
}