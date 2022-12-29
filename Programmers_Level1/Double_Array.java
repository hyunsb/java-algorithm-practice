package Level1;

import java.util.Scanner;

public class Double_Array {
    int[] solution(int[] numbers){
        int[] answer = new int[numbers.length];
        for(int i=0; i<numbers.length; i++)
            answer[i] = numbers[i] * 2;
        return answer;
    }

    public static void main(String[] args) {
        Double_Array main = new Double_Array();
        Scanner sc = new Scanner(System.in);

        int[] numbers = {1, 2, 3, 4, 5};

        for(int i : main.solution(numbers))
            System.out.print(i + " ");
    }
}
