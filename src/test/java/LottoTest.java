import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoTest {

    @Test
    @DisplayName("로또 컬렉션 n개를 만든다.")
    public void makeLottosTest() {
        final int amount = 14000;
        final int expected = amount / 1000;

        Lottos lottos = new Lottos(expected);

        final int actual = lottos.lengthOfLotto();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("1부터 45 사이 숫자의 당첨번호/보너스볼을 입력받는다.")
    public void inputWinningNumberRangeTest() {
        final int value = 46;

        final Executable actual = () -> new LottoNumber(value);

        assertThrows(IllegalArgumentException.class, actual);
    }

    @Test
    @DisplayName("6개의 당첨번호를 입력받는다.")
    public void inputWinningNumberCountTest() {
        final List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(39));
        lottoNumbers.add(new LottoNumber(13));
        lottoNumbers.add(new LottoNumber(28));
        lottoNumbers.add(new LottoNumber(23));
        lottoNumbers.add(new LottoNumber(43));
        lottoNumbers.add(new LottoNumber(8));

        final Executable actual = () -> new Lotto(lottoNumbers);

        assertThrows(IllegalArgumentException.class, actual);
    }

    @Test
    @DisplayName("중복되지 않은 당첨번호를 입력받는다.")
    public void inputWinningNumberDuplicateTest() {
        final List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(1));

        final Executable actual = () -> new Lotto(lottoNumbers);

        assertThrows(IllegalArgumentException.class, actual);
    }
}
