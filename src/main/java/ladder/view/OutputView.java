package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.joining;

public class OutputView {

    private static final String LADDER_MSG = "사다리 결과";
    private static final String FIVE_SIZE_FORMAT = "%5s";
    private static final String WHITE_SPACE = " ";
    private static final String ENTER = "\n";
    private static final String LADDER_SPACE = "     ";
    private static final String LADDER_LINE = "-----";
    private static final String LADDER_COLUMN = "|";
    private static final String RESULT_MSG = "실행 결과";
    private static final String DELIMITER = " : ";

    public static void printLadderView(List<String> players, Ladder ladder) {
        System.out.println(LADDER_MSG);
        System.out.println();
        System.out.println(printPlayerNames(players));
        System.out.println(printLadder(ladder.getLines()));
    }

    private static String printPlayerNames(List<String> players) {
        return players.stream()
                .map(player -> String.format(FIVE_SIZE_FORMAT, player))
                .collect(joining(WHITE_SPACE));
    }

    private static String printLadder(List<Line> ladder) {
        return ladder.stream()
                .map(OutputView::printLine)
                .collect(joining(ENTER));
    }

    private static String printLine(Line line) {
        String lineView = line.getCrosses().stream()
                .map(OutputView::printCross)
                .collect(joining(LADDER_COLUMN));
        return LADDER_SPACE + LADDER_COLUMN + lineView;
    }

    private static String printCross(Cross cross) {
        if (cross.isRight()) {
            return LADDER_LINE;
        }
        return LADDER_SPACE;
    }

    public static void printItems(List<String> items) {
        System.out.println(gameItems(items));
        System.out.println();
    }

    private static String gameItems(List<String> items) {
        return items.stream()
                .map(item -> String.format(FIVE_SIZE_FORMAT, item))
                .collect(joining(WHITE_SPACE));
    }

    public static void printAllResults(LadderResult results, Players players, List<String> items) {
        System.out.println();
        System.out.println(RESULT_MSG);
        System.out.println(gameResults(results.getResult(), players.getPlayers(), items));
    }

    private static String gameResults(Map<Integer, Integer> results, List<Player> players, List<String> items) {
        return results.entrySet().stream()
                .map(entry -> players.get(entry.getKey()).getPlayerName() + DELIMITER + items.get(entry.getValue()))
                .collect(joining(ENTER));
    }

    public static void printOneResult(Player findPlayer, String resultItem) {
        System.out.println();
        System.out.println(RESULT_MSG);
        System.out.println(findPlayer.getPlayerName() + DELIMITER + resultItem);
    }

}
