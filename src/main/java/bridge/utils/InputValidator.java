package bridge.utils;

public class InputValidator {

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

}
