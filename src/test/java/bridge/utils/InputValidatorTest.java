package bridge.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    InputValidator inputValidator = new InputValidator();

    @DisplayName("유효한 다리 길이일 경우, 예외가 발생하지 않습니다.")
    @Test
    void isValidBridgeSize() {
        //given
        String input = "15";

        //when & then
        assertDoesNotThrow(() -> inputValidator.validateBridgeSize(input));
    }

    @DisplayName("다리 길이가 null 일 경우, 예외가 발생합니다.")
    @Test
    void isNullBridgeSize() {
        //given
        String input = null;

        //when & then
        assertThatThrownBy(() -> inputValidator.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이가 숫자가 아닐 경우, 예외가 발생합니다.")
    @Test
    void isNotNumberBridgeSize() {
        //given
        String input = "1a";

        //when & then
        assertThatThrownBy(() -> inputValidator.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이가 3 이상 20 이하가 아닐 경우, 예외가 발생합니다.")
    @Test
    void isNotInRangeBridgeSize() {
        //given
        String input1 = "2";
        String input2 = "21";

        //when & then
        assertThatThrownBy(() -> inputValidator.validateBridgeSize(input1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputValidator.validateBridgeSize(input2))
                .isInstanceOf(IllegalArgumentException.class);
    }

}