package bridge.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputResolverTest {

    InputValidator inputValidator = new InputValidator();
    InputResolver inputResolver = new InputResolver(inputValidator);

    @DisplayName("유효한 다리 길이일 경우, 다리 길이를 int로 반환합니다.")
    @Test
    void isValidBridgeSize() {
        //given
        String input = "10";

        //when
        int bridgeLength = inputResolver.resolveBridgeSize(input);

        //then
        assertThat(bridgeLength).isEqualTo(10);
    }

    @DisplayName("유효하지 않은 다리 길이일 경우, 예외가 발생합니다.")
    @Test
    void isInvalidBridgeSize() {
        //given
        String input = "1j";

        //when & then
        assertThatThrownBy(() -> inputResolver.resolveBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);

    }
}