package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    @DisplayName("주어진 사이즈의 U와 D로 구성된 다리를 만듭니다.")
    @Test
    void makeBridge() {
        //given
        int size = 10;

        //when
        List<String> bridge = bridgeMaker.makeBridge(10);

        //then
        assertThat(bridge.size()).isEqualTo(10);
        assertThat(bridge).containsOnly("U", "D");
    }
}