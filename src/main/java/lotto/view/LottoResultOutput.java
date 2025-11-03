package lotto.view;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.BonusLotto;
import lotto.Lotto;

public class LottoResultOutput {

    private static final Map<String, Integer> lottoResultOutputs = new LinkedHashMap<>();

    static {
        lottoResultOutputs.put("3개 일치 (5,000원)", 0);
        lottoResultOutputs.put("4개 일치 (50,000원)", 0);
        lottoResultOutputs.put("5개 일치 (1,500,000원)", 0);
        lottoResultOutputs.put("5개 일치, 보너스 볼 일치 (30,000,000원)", 0);
        lottoResultOutputs.put("6개 일치 (2,000,000,000원)", 0);
    }

    public static void LottoResult(List<Lotto> purchasedLotto, Lotto lotto, BonusLotto bonusLotto) {
        List<Integer> lottoNumbers = GetNumbers(lotto);
        int bonusNumber = GetBonusNumber(bonusLotto);

        for (Lotto myLotto : purchasedLotto) {
            List<Integer> myNumbers = GetNumbers(myLotto);

            int matchNumber = (int) myNumbers.stream()
                    .filter(lottoNumbers::contains)
                    .count();
            boolean matchBonus = myNumbers.contains(bonusNumber);
            UpdateResult(matchNumber, matchBonus);
        }

        PrintResults();
    }

    private static void UpdateResult(int matchNumber, boolean matchBonus) {
        if (matchNumber == 3) {
            Increment("3개 일치 (5,000원)");
        }
        if (matchNumber == 4) {
            Increment("4개 일치 (50,000원)");
        }
        if (matchNumber == 5 && !matchBonus) {
            Increment("5개 일치 (1,500,000원)");
        }
        if (matchNumber == 5 && matchBonus) {
            Increment("5개 일치, 보너스 볼 일치 (30,000,000원)");
        }
        if (matchNumber == 6) {
            Increment("6개 일치 (2,000,000,000원)");
        }
    }

    private static void PrintResults() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        lottoResultOutputs.forEach((key, value) -> System.out.println(key + " - " + value + "개"));
    }

    private static void Increment(String string) {
        lottoResultOutputs.put(string, lottoResultOutputs.get(string) + 1);
    }

    private static List<Integer> GetNumbers(Lotto lotto) {
        try {
            var field = Lotto.class.getDeclaredField("numbers");
            field.setAccessible(true);
            return (List<Integer>) field.get(lotto);
        } catch (Exception e) {
            throw new RuntimeException("[ERROR] 로또 번호 접근 중 오류 발생");
        }
    }

    private static int GetBonusNumber(BonusLotto bonusLotto) {
        try {
            var field = BonusLotto.class.getDeclaredField("bonusNumber");
            field.setAccessible(true);
            return (int) field.get(bonusLotto);
        } catch (Exception e) {
            throw new RuntimeException("[ERROR] 보너스 번호 접근 중 오류 발생");
        }
    }
}