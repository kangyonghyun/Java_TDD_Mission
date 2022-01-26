package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderController {

    private final LadderCreator ladderCreator;

    public LadderController(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public void start() {
        List<String> names = InputView.inputPlayerNames();
        Players players = new Players(names);
        List<String> items = InputView.inputItems();

        Ladder ladder = ladderCreator.createLadder(InputView.inputLadderHeight(), names.size());
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
