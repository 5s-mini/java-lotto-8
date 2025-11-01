package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberTest {

    @DisplayName("로또 번호는 6개여야 한다.")
    @Test
    void 로또_번호는_6개여야_한다() {
        List<Integer> numbers = RandomNumber.generateLottoNumbers();
        assertThat(numbers.size()).isEqualTo(6);
    }

    @DisplayName("로또 번호는 1에서 45 사이여야 한다.")
    @Test
    void 로또_번호는_1에서_45_사이여야_한다() {
        List<Integer> numbers = RandomNumber.generateLottoNumbers();
        for (int num : numbers) {
            assertThat(num).isBetween(1, 45);
        }
    }

    @DisplayName("로또 번호는 중복되지 않아야 한다.")
    @Test
    void 로또_번호는_중복되지_않아야_한다() {
        List<Integer> numbers = RandomNumber.generateLottoNumbers();
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        assertThat(uniqueNumbers.size()).isEqualTo(numbers.size());
    }

    @DisplayName("로또 번호는 오름차순으로 정렬되어 있어야 한다.")
    @Test
    void 로또_번호는_오름차순으로_정렬되어_있어야_한다() {
        List<Integer> numbers = RandomNumber.generateLottoNumbers();
        for (int i = 0; i < numbers.size() - 1; i++) {
            assertThat(numbers.get(i)).isLessThanOrEqualTo(numbers.get(i + 1));
        }
    }
}