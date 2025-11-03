package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class PurchaseInput {
    private static final int UNIT_PRICE = 1000;

    public int PurchaseRequest() {
        System.out.println("구입 금액을 입력해 주세요.");
        String purchaseInput = Console.readLine();

        int purchaseCount = Process(purchaseInput);
        RandomNumber.Generate(purchaseCount);

        return purchaseCount;
    }

    public int Process(String purchaseInput) {
        IsBlank(purchaseInput);
        IsNull(purchaseInput);
        int purchaseInt = IsIntMoney(purchaseInput);
        IsUnitMoney(purchaseInt);
        return purchaseInt / UNIT_PRICE;
    }

    void IsBlank(String purchaseInput) {
        if (purchaseInput.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 구입 금액 값이 없어요.");
        }
    }

    void IsNull(String purchaseInput) {
        if (purchaseInput == null) {
            throw new IllegalArgumentException("[ERROR] 구입 금액 값이 null이에요.");
        }
    }

    int IsIntMoney(String purchaseInput) {
        try {
            return Integer.parseInt(purchaseInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액을 정수로 입력해 주세요.");
        }
    }

    void IsUnitMoney(int purchaseInt) {
        if (purchaseInt % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액을 1,000원 단위로 입력해 주세요.");
        }
    }
}