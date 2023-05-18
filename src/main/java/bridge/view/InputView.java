package bridge.view;

import bridge.constants.ErrorMessage;
import bridge.utils.InputResolver;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final InputResolver inputResolver;

    public InputView(InputResolver inputResolver) {
        this.inputResolver = inputResolver;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            String input = Console.readLine();
            try {
                return inputResolver.resolveBridgeSize(input);
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_BRIDGE_SIZE);
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            String input = Console.readLine();
            try {
                return inputResolver.resolveMoving(input);
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_MOVING);
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while (true) {
            String input = Console.readLine();
            try {
                return inputResolver.resolveGameCommand(input);
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_GAME_COMMAND);
            }
        }
    }
}
