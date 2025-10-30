package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class PurchaseInput {
    public PurchaseInput() {
        System.out.println("구입 금액을 입력해 주세요.");
        String purchaseInput = Console.readLine();

        IsBlank(purchaseInput);
        IsUnitMoney(purchaseInput);

    }

    private void IsBlank(String purchaseInput) {
        if (purchaseInput == null || purchaseInput.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 구입 금액 값이 없어요.");
        }

    }

    private void IsUnitMoney(String purchaseInput) {
        int money = 0;
        try {
            money = Integer.parseInt(purchaseInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액을 정수로 입력해 주세요.");
        }

        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액을 1,000원 단위로 입력해 주세요.");
        }
    }
}