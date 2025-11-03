package lotto;

import java.util.List;
import lotto.view.LottoResultOutput;
import lotto.view.PurchaseInput;
import lotto.view.RandomNumber;

public class Application {
    public static void main(String[] args) {
        try {
            PurchaseInput purchaseInput = new PurchaseInput();
            int purchaseCount = purchaseInput.PurchaseRequest();

            RandomNumber.Generate(purchaseCount);
            List<Lotto> purchasedLotto = RandomNumber.GetLotto();

            Lotto lotto = Lotto.InputLottoNumbers();
            BonusLotto bonusLotto = BonusLotto.InputBonusLottoNumbers();

            LottoResultOutput.LottoResult(purchasedLotto, lotto, bonusLotto, purchaseCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}