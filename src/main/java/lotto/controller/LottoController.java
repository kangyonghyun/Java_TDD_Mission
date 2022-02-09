package lotto.controller;

import lotto.domain.*;
import lotto.domain.generator.DefaultLottoGenerator;
import lotto.domain.generator.LottoAutoGenerator;
import lotto.domain.generator.LottoGenerator;
import lotto.domain.generator.LottoManualGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {

    public void play() {

        // 구매금액
        Money orderMoney = new Money(InputView.inputOrderMoney());

        // 수동 갯수
        int countOfManual = InputView.inputOrderCountOfManual();
        Money autoMoney = orderMoney.buyManual(countOfManual);
        // 자동 갯수
        int countOfAuto = autoMoney.countOfBuyingLotto();
        // 수동 번호
        String manualLotteries = InputView.inputManualLottoNumbers(countOfManual);

        // LottoGenerator 생성 -> 전체(수동+자동) 로또 생성
        Map<String, LottoGenerator> map = new HashMap<>();
        map.put("auto", new LottoAutoGenerator());
        map.put("manual", new LottoManualGenerator(manualLotteries));
        LottoGenerator lottoGenerator = new DefaultLottoGenerator(map);
        List<Lotto> lotteries = lottoGenerator.generate(orderMoney);

        // 당첨번호, 보너스볼
        List<Integer> numbers = InputView.inputWinningNumbers();
        int bonusBall = InputView.inputBonusBall();
        WiningLotto winingLotto = new WiningLotto(Lotto.of(numbers), LottoNumber.of(bonusBall));

        // 로또게임에 구매로또와 당첨로또 매칭 -> result
        LottoGame lottoGame = new LottoGame(orderMoney, lottoGenerator);
        LottoResult result = lottoGame.match(winingLotto);

        // 주문 로또 번호 출력
        OutputView.printOrderLottoNumber(lotteries);
        // 수동 자동 카운트 출력
        OutputView.printOrderLottoCount(countOfManual, countOfAuto);
        // 결과값 출력
        OutputView.printResult(result, orderMoney);

    }

}
