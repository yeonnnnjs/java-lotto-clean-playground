public class ResultView {

    public static void printPurchaseInfo(final int purchaseCount, final Lottos lottos) {
        System.out.println(purchaseCount + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println("[" + lotto.toString() + "]"));
    }

    public static void printStatistics(int[] matchCounts, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원) - " + matchCounts[3] + "개");
        System.out.println("4개 일치 (50000원) - " + matchCounts[4] + "개");
        System.out.println("5개 일치 (1500000원) - " + matchCounts[5] + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원) - " + matchCounts[6] + "개");
        System.out.println("6개 일치 (2000000000원) - " + matchCounts[7] + "개");
        System.out.println("총 수익률은 " + profitRate + "입니다.");
    }
}
