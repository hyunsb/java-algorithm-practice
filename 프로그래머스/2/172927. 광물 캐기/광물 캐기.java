import java.util.*;

class Solution {

    Map<String, int[]> cost = Map.of(
        "diamond", new int[]{1, 5, 25},
        "iron", new int[]{1, 1, 5},
        "stone", new int[]{1, 1, 1}
    );

    public int solution(int[] picks, String[] minerals) {
        int answer = 2500;

        int maxCountForGettingMinerals = 0;
        for (int pick : picks) maxCountForGettingMinerals += pick * 5;
        maxCountForGettingMinerals = Math.min(maxCountForGettingMinerals, minerals.length);

        List<MineralCost> mineralCosts = new ArrayList<>();
        for (int i = 0; i < maxCountForGettingMinerals; i += 5) {

            int next = i+5;
            if (i+5 > maxCountForGettingMinerals) {
                next = maxCountForGettingMinerals;
            }

            int dCost = 0;
            int iCost = 0;
            int sCost = 0;
            for (int j = i; j < next; j++) {
                dCost += cost.get(minerals[j])[0];
                iCost += cost.get(minerals[j])[1];
                sCost += cost.get(minerals[j])[2];
            }
            mineralCosts.add(new MineralCost(dCost, iCost, sCost));
        }

        mineralCosts.sort(MineralCost::compareTo);

        int cost = 0;
        for (MineralCost mineralCost : mineralCosts) {
            for (int i = 0; i < 3; i++) {
                if (picks[i] > 0) {
                    picks[i] -= 1;
                    cost += mineralCost.getCost(i);
                    break;
                }
            }
        }
        return Math.min(answer, cost);
    }

    private static class MineralCost implements Comparable<MineralCost> {
        int diamondCost, ironCost, stoneCost;

        public MineralCost(int diamondCost, int ironCost, int stoneCost) {
            this.diamondCost = diamondCost;
            this.ironCost = ironCost;
            this.stoneCost = stoneCost;
        }

        public int getCost(int index) {
            if (index == 0) return diamondCost;
            if (index == 1) return ironCost;
            if (index == 2) return stoneCost;
            return 0;
        }

        public int compareTo(MineralCost that) {
            return that.stoneCost - this.stoneCost;
        }

        @Override
        public String toString() {
            return "MineralCost{" +
                "diamondCost=" + diamondCost +
                ", ironCost=" + ironCost +
                ", stoneCost=" + stoneCost +
                '}';
        }
    }
}