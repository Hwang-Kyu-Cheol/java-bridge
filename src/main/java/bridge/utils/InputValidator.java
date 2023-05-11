package bridge.utils;

public class InputValidator {

    private boolean isNull(String input) {
        if (input == null) {
            return true;
        }
        return false;
    }

    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
