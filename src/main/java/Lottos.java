import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Lottos {

    List<Lotto> lottos;

    public Lottos(int count) {
        this.lottos = makeLottoByAmount(count);
    }

    private List<Lotto> makeLottoByAmount(int count) {
        List<Lotto> tempLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tempLottos.add(new Lotto());
        }
        return tempLottos;
    }

    public int lengthOfLotto() {
        return lottos.size();
    }

    public void forEach(Consumer<? super Lotto> action) {
        lottos.forEach(action);
    }
}
