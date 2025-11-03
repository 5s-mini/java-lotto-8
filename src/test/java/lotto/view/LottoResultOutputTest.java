package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.BonusLotto;
import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultOutputTest {

    private String runLottoResult(List<Lotto> purchased, Lotto winning, BonusLotto bonus) {
        int purchaseCount = purchased.size();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        LottoResultOutput.LottoResult(purchased, winning, bonus, purchaseCount);
        System.setOut(originalOut);
        return outContent.toString();
    }

    @DisplayName("3개 일치 시 3개 일치(5,000원) 결과가 1개로 출력된다.")
    @Test
    void 세_개_일치_시_세_개_일치_결과가_1개로_출력된다() {
        Lotto winning = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusLotto bonus = new BonusLotto(7);
        List<Lotto> purchased = List.of(
                new Lotto(List.of(1, 2, 3, 10, 11, 12))
        );

        String output = runLottoResult(purchased, winning, bonus);

        assertThat(output).contains("3개 일치 (5,000원) - 1개");
    }

    @DisplayName("4개 일치 시 4개 일치(50,000원) 결과가 1개로 출력된다.")
    @Test
    void 네_개_일치_시_네_개_일치_결과가_1개로_출력된다() {
        Lotto winning = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusLotto bonus = new BonusLotto(7);
        List<Lotto> purchased = List.of(
                new Lotto(List.of(1, 2, 3, 4, 10, 11))
        );

        String output = runLottoResult(purchased, winning, bonus);

        assertThat(output).contains("4개 일치 (50,000원) - 1개");
    }

    @DisplayName("5개 일치 시 5개 일치(1,500,000원) 결과가 1개로 출력된다.")
    @Test
    void 다섯_개_일치_시_다섯_개_일치_결과가_1개로_출력된다() {
        Lotto winning = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusLotto bonus = new BonusLotto(7);
        List<Lotto> purchased = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 9))
        );

        String output = runLottoResult(purchased, winning, bonus);

        assertThat(output).contains("5개 일치 (1,500,000원) - 1개");
    }

    @DisplayName("5개 + 보너스 번호 일치 시 5개 일치, 보너스 볼 일치(30,000,000원) 결과가 1개로 출력된다.")
    @Test
    void 다섯_개와_보너스_번호_일치_시_다섯_개와_보너스_번호_일치_결과가_1개로_출력된다() {
        Lotto winning = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusLotto bonus = new BonusLotto(7);
        List<Lotto> purchased = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 7))
        );

        String output = runLottoResult(purchased, winning, bonus);

        assertThat(output).contains("5개 일치, 보너스 볼 일치 (30,000,000원) - 1개");
    }

    @DisplayName("6개 모두 일치 시 6개 일치(2,000,000,000원) 결과가 1개로 출력된다.")
    @Test
    void 여섯_개_일치_시_여섯_개_일치_결과가_1개로_출력된다() {
        Lotto winning = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusLotto bonus = new BonusLotto(7);
        List<Lotto> purchased = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        );

        String output = runLottoResult(purchased, winning, bonus);

        assertThat(output).contains("6개 일치 (2,000,000,000원) - 1개");
    }
}
