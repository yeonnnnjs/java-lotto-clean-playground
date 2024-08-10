import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumber {

    private final Integer value;

    public LottoNumber(Integer value) {
        validate(value);
        this.value = value;
    }

    private void validate(Integer value) {
        if(value < 1 || value > 45) {
            throw new IllegalArgumentException("입력 숫자는 1과 45 사이의 숫자여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public String toString() {
        return value.toString();
    }
}
