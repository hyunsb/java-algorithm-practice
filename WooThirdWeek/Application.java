package WooThirdWeek;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int tmp = IOValue.inputLottoAmount()/1000;
        System.out.println();

        List<Lotto> lottoList = new ArrayList<>();
        while(lottoList.size() < tmp)
            lottoList.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));

        for(Lotto ticket : lottoList)
            System.out.println(ticket.getNumbers());
    }
}
