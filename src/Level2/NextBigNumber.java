package Level2;

public class NextBigNumber {
    public static void main(String[] args) {
        // 연습문제 - 다음 큰 숫자
        int n = 78;
        System.out.println(Integer.bitCount(n));

        }

    public static int solution(int n){
        // 효율성 테스트 실패 (시간초과)
        // 인자값의 문자열에서 0을 제거한 길이를 구하여 비교및 계산
        int answer = n;
        int count1 = Integer.toBinaryString(n).replaceAll("0","").length();

        while (true){
            answer++;
            if (Integer.toBinaryString(answer).replaceAll("0", "").length() == count1) {
                return answer;
            }
        }
    }

    public static int solution2(int n){
        // Integer.bitCount 사용
        int answer = n;
        int count = Integer.bitCount(n);

        while (true){
            answer++;
            if (Integer.bitCount(answer) == count) return answer;
        }

    }
}
