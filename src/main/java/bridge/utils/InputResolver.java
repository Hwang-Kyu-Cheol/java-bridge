package bridge.utils;

public class InputResolver {

    private final InputValidator inputValidator;

    public InputResolver(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    /**
     * 입력받은 다리 길이를 int로 변환하는 메소드
     * @param input
     * @return int
     */
    public int resolveBridgeLength(String input) {
        inputValidator.validateBridgeLength(input);
        return Integer.parseInt(input);
    }
}
