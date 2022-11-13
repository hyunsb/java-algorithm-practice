package WooThirdWeek;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    FIRST(2000000000, 6, false),
    SECOND(30000000, 5, true),
    THIRD(1500000, 5, false),
    FOURTH(50000, 4, false),
    FIFTH(5000, 3, false),
    NO_PRIZE(0, 0, false);

    private final int prizeMoney;
    private final int hitCount;
    private final boolean hitBonus;

    private Rank(int prizeMoney, int hitCount, boolean hitBonus){
        this.prizeMoney = prizeMoney;
        this.hitCount = hitCount;
        this.hitBonus = hitBonus;
    }

    // 리팩토링 필요
    // TODO: hitCount 와 hitBonus 를 비교하여 RANK를 반환한다.
    public static Rank valueOf(int hitCount, boolean hitBonus){
        if (FIFTH.hitCount > hitCount)
            return NO_PRIZE;
        if (SECOND.matchCount(hitCount) && hitBonus)
            return SECOND;
        if (THIRD.matchCount(hitCount) && !hitBonus)
            return THIRD;

        for (Rank rank : values()){
            if (rank.matchCount(hitCount)) {
                return rank;
            }
        }
        throw new IllegalArgumentException();
    }


    private boolean matchCount(int hitCount){
        return this.hitCount == hitCount;
    }



}
