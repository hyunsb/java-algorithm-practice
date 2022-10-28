package wooFirstWeek;

public class test {
    public static void main(String[] args) {
        String str = "제이엠";
        String strchk = "제이제잉에엠";

        for(int i=0; i < str.length()-1; i++){
            System.out.println(strchk.contains(str.substring(i,i+2)));
        }

    }
}
