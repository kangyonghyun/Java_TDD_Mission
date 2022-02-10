package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winners;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class OutputView {

    public static final String EXECUTE_RESULT_MESSAGE = "실행결과";
    public static final String WINNERS_RESULT_MESSAGE = "(이)가 최종 우승했습니다.";
    public static final String POSITION_SIGN = "-";
    public static final String NAME_DELIMITER = " : ";
    public static final String WINNER_DELIMITER = ", ";
    public static final char ENTER = '\n';

    public static void printResultMessage() {
        System.out.println(EXECUTE_RESULT_MESSAGE);
    }

    public static void printResult(Cars cars) {
        StringBuilder builder = new StringBuilder();
        cars.getCars()
                .forEach(car -> appendSign(builder, car));
        System.out.println(builder);
    }

    private static void appendSign(StringBuilder builder, Car car) {
        builder.append(car.getCarName().getName())
                .append(IntStream.range(0, car.getPosition().getPosition())
                        .mapToObj(i -> POSITION_SIGN)
                        .collect(joining("", NAME_DELIMITER, String.valueOf(ENTER)))
                );
    }

    public static void printWinners(Winners winners) {
        System.out.println(getWinners(winners));
    }

    private static String getWinners(Winners winners) {
        return winners.getWinners().stream()
                .map(car -> car.getCarName().getName())
                .collect(joining(WINNER_DELIMITER))
                + WINNERS_RESULT_MESSAGE;
    }

}
