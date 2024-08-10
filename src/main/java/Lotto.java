import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {

    private final List<LottoNumber> lottoNumbers;

    public Lotto() {
        this.lottoNumbers = makeLottoNumbers();
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private List<LottoNumber> makeLottoNumbers() {
        List<LottoNumber> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(new LottoNumber(i));
        }

        Collections.shuffle(numbers);
        numbers = numbers.subList(0, 6);
        sort(numbers);
        return numbers;
    }

    private void sort(List<LottoNumber> numbers) {

    }

    public Stream<LottoNumber> stream() {
        return lottoNumbers.stream();
    }

    public boolean contains(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        Set<LottoNumber> uniqueNumbers = new HashSet<>(lottoNumbers);
        if (uniqueNumbers.size() < lottoNumbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않아야 합니다.");
        }
    }

    public String toString() {
        return lottoNumbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(", "));
    }
}
