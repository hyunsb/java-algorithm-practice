package Section9_Greedy_Algorithm;

import java.util.*;

/**
 * 씨름 선수
 * 현수는 씨름 감독입니다. 현수는 씨름 선수를 선발공고를 냈고, N명의 지원자가 지원을 했습니다.
 * 현수는 각 지원자의 키와 몸무게 정보를 알고 있습니다.현수는 씨름 선수 선발 원칙을 다음과 같이 정했습니다.
 * “A라는 지원자를 다른 모든 지원자와 일대일 비교해서 키와 몸무게 모두 A지원자 보다 높은
 * (크고, 무겁다) 지원자가 존재하면 A지원자는 탈락하고, 그렇지 않으면 선발된다.”
 * N명의 지원자가 주어지면 위의 선발원칙으로 최대 몇 명의 선수를 선발할 수 있는지 알아내는 프로그램을 작성하세요.
 *
 * ▣ 입력설명
 * 첫째 줄에 지원자의 수 N(5<=N<=100,000)이 주어집니다.
 * 두 번째 줄부터 N명의 키와 몸무게 정보가 차례로 주어집니다. 각 선수의 키와 몸무게는 모두
 * 다릅니다.
 *
 * ▣ 출력설명
 * 첫째 줄에 씨름 선수로 뽑히는 최대 인원을 출력하세요.
 * */

class PhysicalInfo implements Comparable<PhysicalInfo>{
    public int height, weight;

    PhysicalInfo(int height, int weight){
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(PhysicalInfo o) {
        return o.height - this.height;
    }
}

public class _1_A_Sumo_Wrestler {
    public static void main(String[] args) {
        _1_A_Sumo_Wrestler main = new _1_A_Sumo_Wrestler();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<PhysicalInfo> sumoWrestlerList = new ArrayList<>();
        for(int i=0; i<n; i++)
            sumoWrestlerList.add(new PhysicalInfo(sc.nextInt(), sc.nextInt()));

        Collections.sort(sumoWrestlerList);

//        for(PhysicalInfo x : sumoWrestlerList){
//            System.out.println(x.height +" " + x.weight);
//        }

        int answer = 0;
        int tempWeight = Integer.MIN_VALUE;

        for(PhysicalInfo x : sumoWrestlerList){
            if(x.weight > tempWeight){
                answer++;
                tempWeight = x.weight;
            }
        }

        System.out.println(answer);
    }
}
