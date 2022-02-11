package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.strategy.MovingStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final MovingStrategy strategy;

    public RacingController(MovingStrategy strategy) {
        this.strategy = strategy;
    }

    public void play() {
        // 자동차 이름 입력
        Cars cars = Cars.of(InputView.inputCarName());
        // 시도 횟수 입력
        int tryNo = InputView.inputTryCount();

        RacingGame racingGame = new RacingGame(cars, tryNo);

        // 겜 시작
        OutputView.printResultMessage();
        while (!racingGame.isEndGame()) {
            racingGame = racingGame.race(strategy);
            OutputView.printResult(racingGame.getCars());
        }

        // 우승자 출력
        OutputView.printWinners(racingGame.findWinners());
    }

}
