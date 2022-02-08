package lotto.view;

import lotto.domain.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class OutputView {

    private static final String RATE_PATTERN = "0.##";

    public static void printOrderLottoNumber(List<Lotto> lotteries) {
        lotteries.stream()
                .map(Lotto::getLottoNumbers)
                .map(ArrayList::new)
                .forEach(list -> {
                    list.sort(Comparator.comparingInt(LottoNumber::getNumber));
                    System.out.println(list);
        });
    }

    public static void printOrderLottoCount(int manualCount, int autoCount) {
        System.out.println("수동으로 " + manualCount + "장, 자동으로 " + autoCount + "개를 구매했습니다.");
    }

    public static void printResult(LottoResult result, Money orderMoney) {
        StringBuilder builder = new StringBuilder();
        builder.append("당첨 통계");
        builder.append("\n");
        builder.append("----------");
        builder.append("\n");
        List<Rank> ranks = Arrays.asList(Rank.values());
        ranks.sort(Collections.reverseOrder());
        for (int i = 1; i < ranks.size(); i++) {
            builder.append(ranks.get(i).getCountOfMatch());
            builder.append("개 일치");
            isSecondPrize(builder, ranks.get(i));
            builder.append("(");
            builder.append(ranks.get(i).getWinningMoney());
            builder.append("원) - ");
            isRanker(builder, result.getResults(), ranks.get(i));
            builder.append("개");
            builder.append("\n");
        }
        System.out.print(builder);
        Money prize = result.getPrize();
        double rate = orderMoney.profitRate(prize);
        System.out.println("총 수익률은 " + format(rate)  + "입니다.");
    }

    private static void isSecondPrize(StringBuilder builder, Rank rank) {
        if (rank == Rank.SECOND) {
            builder.append(", 보너스볼 일치 ");
        }
    }

    private static void isRanker(StringBuilder builder, Map<Rank, Integer> lottoStatistics, Rank rank) {
        if (lottoStatistics == null || lottoStatistics.get(rank) == null) {
            builder.append(0);
            return;
        }
        builder.append(lottoStatistics.get(rank));
    }

    private static double format(double total) {
        DecimalFormat format = new DecimalFormat(RATE_PATTERN);
        format.setRoundingMode(RoundingMode.DOWN);
        return Double.parseDouble(format.format(total));
    }

}
