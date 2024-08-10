import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return parseInt(scanner.nextLine().trim());
    }

    public static Lotto inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new Lotto(
                Stream.of(scanner.nextLine().split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .map(LottoNumber::new)
                        .collect(Collectors.toList())
        );
    }

    public static LottoNumber inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new LottoNumber(parseInt(scanner.nextLine()));
    }
}
