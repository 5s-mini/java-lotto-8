package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseInputTest {
    PurchaseInput purchaseInput = new PurchaseInput();

    @DisplayName("입력이 비어 있으면 예외가 발생한다.")
    @Test
    void 입력이_비어_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> {
            purchaseInput.IsBlank("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액 값이 없어요.");
    }

    @DisplayName("입력이 null이면 예외가 발생한다.")
    @Test
    void 입력이_null이면_예외가_발생한다() {
        assertThatThrownBy(() -> {
            purchaseInput.IsNull(null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액 값이 null 값이에요.");
    }

    @DisplayName("입력이 정수가 아니면 예외가 발생한다.")
    @Test
    void 입력이_정수가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> {
            purchaseInput.IsIntMoney("천 원");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액을 정수로 입력해 주세요.");
    }

    @DisplayName("입력 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> {
            purchaseInput.IsUnitMoney(1500);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액을 1,000원 단위로 입력해 주세요.");
    }
}