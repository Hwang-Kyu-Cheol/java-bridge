package bridge;

import bridge.utils.InputResolver;
import bridge.utils.InputValidator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class AppConfig {
    public static BridgeGameController bridgeGameController() {
        InputView inputView = new InputView(new InputResolver(new InputValidator()));
        OutputView outputView = new OutputView();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return new BridgeGameController(inputView, outputView, bridgeMaker);
    }
}
