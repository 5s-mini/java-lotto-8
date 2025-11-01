package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_NUM = 6;
    private static final int MIN = 1;
    private static final int MAX = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto InputLottoNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String lottoInput = Console.readLine();
        return parseLottoInput(lottoInput);
    }

    private static Lotto parseLottoInput(String lottoInput) {
        ValidateBlank(lottoInput);
        ValidateNull(lottoInput);
        List<Integer> parsedLottoNum = ParseToInt(lottoInput);
        return new Lotto(parsedLottoNum);
    }

    private static List<Integer> ParseToInt(String lottoInput) {
        try {
            return Arrays.stream(lottoInput.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 정수로 입력하세요.");
        }
    }

    private static void ValidateBlank(String lottoInput) {
        if (lottoInput.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호를 입력해 주세요.");
        }
    }
    
    private static void ValidateNull(Object lottoInput) {
        if (lottoInput == null) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 값이 null이에요.");
        }
    }

    private void Validate(List<Integer> numbers) {
        ValidateSize(numbers);
        ValidateDuplicate(numbers);
        ValidateRange(numbers);
    }

    private void ValidateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUM) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개를 입력해 주세요.");
        }
    }

    private void ValidateDuplicate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있어요.");
        }
    }

    private void ValidateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(num -> num < MIN || num > MAX)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 값으로 지정해 주세요.");
        }
    }
}