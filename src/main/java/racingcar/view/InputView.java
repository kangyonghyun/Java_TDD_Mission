package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);
    private static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요";
    public static final String TRY_INPUT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    public static final String COMMA = ",";

    public static List<String> inputCarName() {
        System.out.println(NAME_INPUT_MESSAGE);
        return Arrays.asList(sc.nextLine().split(COMMA));
    }

    public static int inputTryCount() {
        System.out.println(TRY_INPUT_MESSAGE);
        return Integer.parseInt(sc.next());
    }

}
