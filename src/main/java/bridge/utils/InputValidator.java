package bridge.utils;

import bridge.consts.Command;
import bridge.consts.Key;

public class InputValidator {

    /**
     * 입력받은 다리 길이가 유효한지 판단하는 메소드
     * @param input
     */
    public void validateBridgeSize(String input) {
        validateNull(input);
        validateNumber(input);
        validateRange(input);
    }

    /**
     * 입력받은 이동할 칸이 유효한지 판단하는 메소드
     * @param input
     */
    public void validateMoving(String input) {
        validateNull(input);
        validateMovingKey(input);
    }

    /** 비즈니스 로직 ** /

    /**
     * 입력이 null 인지 판단하는 메소드
     * @param input
     */
    private void validateNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 입력이 숫자 인지 판단하는 메소드
     * @param input
     */
    private void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 입력이 3 이상 20 이하 인지 판단하는 메소드
     * @param input
     */
    private void validateRange(String input) {
        int number = Integer.parseInt(input);
        if (number < 3 || number > 20) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 입력이 U, D인지 판단하는 메소드
     * @param input
     */
    private void validateMovingKey(String input) {
        if (!Key.MOVING_KEYS.contains(input)) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 입력이 R, Q인지 판단하는 메소드
     * @param input
     */
    private void validateRetryCommand(String input) {
        if (!Command.COMMANDS.contains(input)) {
            throw new IllegalArgumentException();
        }
    }
}
