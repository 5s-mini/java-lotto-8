package lotto;

import camp.nextstep.edu.missionutils.Console;

public class BonusLotto {
    private static final int BONUS_LOTTO_NUM = 1;
    private static final int MIN = 1;
    private static final int MAX = 45;

    private final int bonusNumber;

    public BonusLotto(int bonusNumber) {
        ValidateRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static BonusLotto InputBonusLottoNumbers() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusLottoInput = Console.readLine();
        try {
            return ParseBonusLottoInput(bonusLottoInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private static BonusLotto ParseBonusLottoInput(String bonusLottoInput) {
        ValidateBlank(bonusLottoInput);
        ValidateNull(bonusLottoInput);
        int parsedBonusLottoNum = ParseToInt(bonusLottoInput);
        return new BonusLotto(parsedBonusLottoNum);
    }

    public static int ParseToInt(String bonusLottoInput) {
        try {
            return Integer.parseInt(bonusLottoInput.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수로 입력하세요.");
        }
    }

    public static void ValidateBlank(String bonusLottoInput) {
        if (bonusLottoInput.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 입력해 주세요.");
        }
    }

    public static void ValidateNull(String bonusLottoInput) {
        if (bonusLottoInput == null) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호 값이 null이에요.");
        }
    }

    public void ValidateRange(int bonusNumber) {
        if (bonusNumber < MIN || bonusNumber > MAX) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 값으로 지정해 주세요.");
        }
    }
}