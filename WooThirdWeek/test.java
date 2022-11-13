package WooThirdWeek;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<String> winningNumbers = List.of("1", "2", "3", "4", "5", "6");
        List<Rank> prizeList = new ArrayList<>();
        int bonusNumber = 7;

        List<List<Integer>> lottoTicket = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 8),
                List.of(1, 2, 3, 4, 9, 10),
                List.of(1, 2, 3, 13, 11, 12)
        );

        for(List<Integer> numbers : lottoTicket) {
            int hitCount = 0;
            boolean hitBonus = false;
            System.out.println(numbers);

            for (int number : numbers) {
                if (winningNumbers.contains(Integer.toString(number))) hitCount++;
                if (bonusNumber == number) hitBonus = true;
            }

            prizeList.add(Rank.valueOf(hitCount, hitBonus));
        }

        System.out.println(prizeList);
    }
}
