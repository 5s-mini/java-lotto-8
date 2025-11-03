package lotto;

import java.util.List;
import lotto.view.LottoResultOutput;
import lotto.view.PurchaseInput;
import lotto.view.RandomNumber;

public class Application {
    public static void main(String[] args) {
        PurchaseInput purchaseInput = new PurchaseInput();
        purchaseInput.PurchaseRequest();

        RandomNumber randomNumber = new RandomNumber();
        List<Lotto> purchasedLotto = randomNumber.GetLotto();

        Lotto lotto = Lotto.InputLottoNumbers();
        BonusLotto bonusLotto = BonusLotto.InputBonusLottoNumbers();

        LottoResultOutput.LottoResult(purchasedLotto, lotto, bonusLotto);
    }
}