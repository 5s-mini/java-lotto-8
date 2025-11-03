package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        List<Integer> numbers = RandomNumber.GenerateLottoNumbers();
        assertThat(numbers.size()).isEqualTo(6);
    }

    @DisplayName("로또 번호의 범위가 1에서 45 사이가 아니면 예외가 발생한다.")
    @Test
    void 로또_번호의_범위가_1에서_45_사이가_아니면_예외가_발생한다() {
        List<Integer> numbers = RandomNumber.GenerateLottoNumbers();
        for (int num : numbers) {
            assertThat(num).isBetween(1, 45);
        }
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        List<Integer> numbers = RandomNumber.GenerateLottoNumbers();
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        assertThat(uniqueNumbers.size()).isEqualTo(numbers.size());
    }

    @DisplayName("로또 번호가 오름차순으로 정렬되지 않으면 예외가 발생한다.")
    @Test
    void 로또_번호가_오름차순으로_정렬되지_않으면_예외가_발생한다() {
        List<Integer> numbers = RandomNumber.GenerateLottoNumbers();
        for (int i = 0; i < numbers.size() - 1; i++) {
            assertThat(numbers.get(i)).isLessThanOrEqualTo(numbers.get(i + 1));
        }
    }
}