package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusLottoTest {

    @DisplayName("보너스 번호가 1에서 45 사이가 아니면 예외가 발생한다.")
    @Test
    void 보너스_번호의_범위가_1에서_45_사이가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusLotto(60))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 정수가 아니면 예외가 발생한다.")
    @Test
    void 보너스_번호가_정수가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> {
            BonusLotto.ParseToInt("24.5");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호의 입력이 비어 있으면 예외가 발생한다.")
    @Test
    void 보너스_번호의_입력이_비어_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> {
            BonusLotto.ValidateBlank(" ");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 null이면 예외가 발생한다.")
    @Test
    void 보너스_번호가_null이면_예외가_발생한다() {
        assertThatThrownBy(() -> {
            BonusLotto.ValidateNull(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
