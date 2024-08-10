public class LottoGame {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();
        int purchaseCount = purchaseAmount / 1000;

        Lottos lottos = new Lottos(purchaseCount);

        ResultView.printPurchaseInfo(purchaseCount, lottos);

        Lotto winningNumbers = InputView.inputWinningNumbers();
        LottoNumber bonusNumber = InputView.inputBonusNumber();

        int[] matchCounts = calculateMatchCounts(lottos, winningNumbers, bonusNumber);
        double profitRate = calculateProfitRate(matchCounts, purchaseAmount);

        ResultView.printStatistics(matchCounts, profitRate);
    }

    private static int[] calculateMatchCounts(Lottos lottos, Lotto winningNumbers, LottoNumber bonusNumber) {
        int[] matchCounts = new int[8];

        lottos.forEach(lotto -> {
            long matchCount = lotto.stream()
                    .filter(winningNumbers::contains)
                    .count();

            boolean bonusMatch = lotto.contains(bonusNumber);

            if (matchCount == 5 && bonusMatch) {
                matchCounts[6]++;
            } else if (matchCount >= 3) {
                matchCounts[(int) matchCount]++;
            }
        });
        return matchCounts;
    }

    private static double calculateProfitRate(int[] matchCounts, int purchaseAmount) {
        int totalProfit = matchCounts[3] * 5000 +
                matchCounts[4] * 50000 +
                matchCounts[5] * 1500000 +
                matchCounts[6] * 30000000 +
                matchCounts[7] * 2000000000;

        return (double) totalProfit / purchaseAmount;
    }
}
