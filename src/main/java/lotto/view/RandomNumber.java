package lotto.view;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class RandomNumber {

    private static final int LOTTO_NUM = 6;
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final List<Lotto> finalLotto = new ArrayList<>();

    public static void Generate(int purchaseCount) {
        finalLotto.clear();
        System.out.println("\n" + purchaseCount + "개를 구매했습니다.");

        for (int i = 0; i < purchaseCount; i++) {
            List<Integer> lottoNumbers = GenerateLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            finalLotto.add(lotto);
            System.out.println(lottoNumbers);
        }
    }

    private static List<Integer> GenerateLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN, MAX, LOTTO_NUM);
        lottoNumbers.sort(Integer::compareTo);
        return lottoNumbers;
    }

    public static List<Lotto> GetLotto() {
        return new ArrayList<>(finalLotto);
    }
}