package bridge.controller;

import java.util.List;

public class BridgeGameController {

    /**
     * 게임 성공 여부를 판단하는 메소드
     * @param bridge
     * @param user
     * @return boolean
     */
    private boolean isSuccess(List<String> bridge, List<String> user) {
        int index = user.size() - 1;
        return bridge.get(index) == user.get(index);
    }
}
