package lotto.view;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumber {
    private static final int LOTTO_NUM = 6;
    private static final int MIN = 1;
    private static final int MAX = 45;

    public static void Generate(int purchaseCount) {
        System.out.println("\n" + purchaseCount + "개를 구매했습니다.");
        printLottoTickets(purchaseCount);
    }

    private static void printLottoTickets(int purchaseCount) {
        for (int i = 0; i < purchaseCount; i++) {
            printLottoNumbers();
        }
    }

    private static void printLottoNumbers() {
        List<Integer> lottoNumbers = generateLottoNumbers();
        System.out.println(lottoNumbers);
    }

    public static List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN, MAX, LOTTO_NUM);
        lottoNumbers.sort(Integer::compareTo);
        return lottoNumbers;
    }
}