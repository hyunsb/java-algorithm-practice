class Solution {
    public String[] solution(int n, int[] arr, int[] arr2){
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String binaryString = Integer.toBinaryString(arr[i] | arr2[i]);

            binaryString = String.format("%" + n + "s", binaryString);

            binaryString = binaryString.replace("1", "#");
            binaryString = binaryString.replace("0", " ");
            answer[i] = binaryString;
        }
        
        return answer;
    }
}