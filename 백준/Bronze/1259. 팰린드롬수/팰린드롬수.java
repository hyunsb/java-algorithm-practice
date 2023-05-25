import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            String num;
            boolean res;
            
            while(true) {
                num = br.readLine();
                res = true;
                if(num.equals("0")) {
                    break;
                }
 
                for(int i = 0;i<num.length()/2;i++) {
                    if(num.charAt(i)!=num.charAt(num.length() - 1 - i)) {
                        res = false;
                        break;
                    }
                }
                
                if(res) {
                    System.out.println("yes");
                }
                else {
                    System.out.println("no");
                }
            }
        }catch(Exception e) {
            System.out.println(e.toString());
        }
    }
}