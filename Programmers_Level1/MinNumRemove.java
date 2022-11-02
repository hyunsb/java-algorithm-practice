package Level1;

public class MinNumRemove {
    public int[] solution(int[] arr) {
        int[] answer = {-1};

        if(arr.length != 1){
            int min = 999999;
            for(int i=0; i<arr.length; i++){
                if (arr[i] < min) min = arr[i];
            }

            int count=0;
            int[] removeArr = new int[arr.length-1];
            for (int i=0; i<arr.length; i++){
                if(arr[i] != min){
                    removeArr[count] = arr[i];
                    count++;
                }
            }
            answer = removeArr;
        }

        return answer;
    }
}
