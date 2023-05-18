package bridge;

import bridge.constants.GameCommand;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;

    public BridgeGameController(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void run() {
        start();
        makeBridge();
        playBridgeGame();
        printResult();
    }

    /**
     * 게임 시작 출력 메소드
     */
    private void start() {
        outputView.printStartBridgeGame();
        outputView.printBlank();
    }

    /**
     * 다리 길이를 입력받고, 다리를 만든느 메소드
     * @return List<String>
     */
    private void makeBridge() {
        outputView.printEnterBridgeSize();
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame = new BridgeGame(bridge);
        outputView.printBlank();
    }

    /**
     * 게임 시작 메서드
     */
    private void playBridgeGame() {
        while (!isSuccess()) {
            move();
            if (!isUserSafe()) {
                retry();
                break;
            }
        }
    }

    /** 비즈니스 로직 **/
    private boolean isSuccess() {
        return bridgeGame.isSuccess();
    }

    private void move() {
        outputView.printSelectMoving();
        String moving = inputView.readMoving();
        bridgeGame.move(moving);
        outputView.printMap(bridgeGame.getBridge(), bridgeGame.getUser());
    }

    private boolean isUserSafe() {
        return bridgeGame.isUserSafe();
    }

    private void retry() {
        outputView.printSelectGameCommand();
        String gameCommand = inputView.readGameCommand();
        if (gameCommand.equals(GameCommand.RETRY)) {
            bridgeGame.retry();
            playBridgeGame();
        }
    }

    private void printResult() {
        outputView.printResult(bridgeGame.getBridge(), bridgeGame.getUser(), bridgeGame.isSuccess(), bridgeGame.getTryCount());
    }

}
