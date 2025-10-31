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
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("입력이 null이면 예외가 발생한다.")
    @Test
    void 입력이_null이면_예외가_발생한다() {
        assertThatThrownBy(() -> {
            purchaseInput.IsBlank(null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("입력이 정수가 아니면 예외가 발생한다.")
    @Test
    void 입력이_정수가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> {
            purchaseInput.IsIntMoney("천원");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("입력 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> {
            purchaseInput.IsUnitMoney(1500);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}