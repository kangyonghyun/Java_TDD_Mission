package ladder.controller;

import ladder.domain.*;
import ladder.domain.generator.LadderCreator;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.result.LadderResult;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderController {

    private final LadderCreator ladderCreator;

    public LadderController(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public void start() {
        // 선수이름
        List<String> names = InputView.inputPlayerNames();
        Players players = new Players(names);
        // 결과항목
        List<String> items = InputView.inputItems();

        Ladder ladder = ladderCreator.createLadder(names.size(), InputView.inputLadderHeight());
        LadderResult result = ladder.play();

        OutputView.printLadderView(names, ladder);
        OutputView.printItems(items);

        while (true) {
            String input = InputView.inputPlayerForResult();

            if (input.equals("all")) {
                OutputView.printAllResults(result, players, items);
                break;
            }

            Player findPlayer = new Player(input);

            int resultIndex = result.getOneResult(players.findIndexByName(findPlayer));
            String resultItem = items.get(resultIndex);

            OutputView.printOneResult(findPlayer, resultItem);
        }
    }

}
