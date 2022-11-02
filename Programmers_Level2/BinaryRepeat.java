package Level2;

public class BinaryRepeat {
    public static void main(String[] args){
        // Programmers 월간 코드 챌린지 시즌1 이진 변환 반복하기
        String str = "110010101001";

        //------------------Solved-----------------//
        int[] answer = new int[2];
        String s = str;
        int count = 0;
        int remove = 0;
        boolean flag = true;

        while(flag){
            int sLen = s.replaceAll("0", "").length();
            remove += s.length() - sLen;
            s = (Integer.toBinaryString(sLen)).toString();
            count ++;

            flag = s.equals("1") ? false : true;
        }

        answer[0] = count;
        answer[1] = remove;

        System.out.println(answer[0] + " " + answer[1]);
    }
}
