package lotto;

import lotto.view.PurchaseInput;
import lotto.view.RandomNumber;

public class Application {
    public static void main(String[] args) {
        PurchaseInput purchaseInput = new PurchaseInput();
        purchaseInput.PurchaseRequest();
        RandomNumber randomNumber = new RandomNumber();
        Lotto lotto = Lotto.InputLottoNumbers();
        BonusLotto bonusLotto = BonusLotto.InputBonusLottoNumbers();
    }
}