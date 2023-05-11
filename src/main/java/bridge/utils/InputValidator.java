package bridge.utils;

public class InputValidator {

    /**
     * 입력이 null 인지 판단하는 메소드
     * @param input
     * @return boolean
     */
    private boolean isNull(String input) {
        if (input == null) {
            return true;
        }
        return false;
    }

    /**
     * 입력이 숫자 인지 판단하는 메소드
     * @param input
     * @return boolean
     */
    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
