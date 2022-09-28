package Level1;

public class JadenCase {
    public static void main(String[] args) {
        // JadenCase 문자열 만들기

        String str1 = "3people unFollowed me ";
        String str2 = "for the last week";
        // return
        // str1 = "3people Unfollowed Me "

        // 마지막 문자열이 공백일 경우 error
        /*
         *         ["3people", "unFollowed", "me"]
         *         String[] strArr = str1.split(" ");
         *         for (int i = 0; i < strArr.length; i++){
         *             String[] tmp = strArr[i].toLowerCase().split("");
         *             tmp[0] = tmp[0].toUpperCase();
         *             strArr[i] = String.join("",tmp);
         *         }
         *         String answer = String.join(" ", strArr);
         *         System.out.println("'"+answer+"'");
         */

        String[] strArr = str1.toLowerCase().split("");
        for(int i = 0; i < strArr.length-1; i++){
            strArr[i+1] = (strArr[i].equals(" "))?
                    strArr[i+1].toUpperCase():strArr[i+1];
        }
        strArr[0] = strArr[0].toUpperCase();
        String answer = String.join("", strArr);

        System.out.println(answer);



        //=============== solution ===============//
        String sol = "";
        String[] tmp = str1.toLowerCase().split("");
        boolean flag = true;

        for (String s : tmp){
            sol += flag ? s.toUpperCase() : s;
            flag = s.equals(" ") ? true : false;
        }

        System.out.println(sol);


    }
}
