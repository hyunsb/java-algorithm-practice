package Level2;

import java.util.Stack;

public class ProperBracket {
    public static void main(String[] args) {
        String s = "(()(";
    }

    // Use String Array - for each
    public Boolean Solution(String s){

        String[] tmp = s.split("");
        int count = 0;
        for (String str : tmp) {
            count += str.equals("(") ? 1 : -1;
            if (count < 0) return false;
        }
        return count==0 ? true:false;
    }

    // Use CharAt()
    public Boolean Solution2(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            count += (s.charAt(i) == '(') ? 1 : -1;
            if (count < 0) return false;
        }
        return count == 0? true : false;
    }

    // Use Stack
    public Boolean Solution3(String s){
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(') stack.push('(');
            else {
                if (stack.isEmpty()) return false;
                else {
                    stack.pop();
                }
            }
        }
        return (stack.isEmpty()) ? true : false;
    }
}
