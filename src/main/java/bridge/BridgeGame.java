package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private final List<String> user;
    private int tryCount;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.user = new ArrayList<>();
        this.tryCount = 1;
    }

    public List<String> getBridge() {
        return List.copyOf(bridge);
    }

    public List<String> getUser() {
        return List.copyOf(user);
    }

    public int getTryCount() {
        return tryCount;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        user.add(moving);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        tryCount++;
        user.clear();
    }

    /**
     * 사용자가 다리에서 떨어지지 않고 안전한지 판단하는 메서드
     * @return boolean
     */
    public boolean isUserSafe() {
        int index = user.size() - 1;
        return bridge.get(index).equals(user.get(index));
    }

    /**
     * 게임을 성공했는지 판단하는 메서드
     * @return boolean
     */
    public boolean isSuccess() {
        if (isEqualSize(bridge, user) && isEqualContents(bridge, user)) {
            return true;
        }
        return false;
    }

    /** 비즈니스 로직 **/
    private boolean isEqualSize(List<String> bridge, List<String> user) {
        return bridge.size() == user.size();
    }

    private boolean isEqualContents(List<String> bridge, List<String> user) {
        for (int i = 0; i < bridge.size(); i++) {
            if (!bridge.get(i).equals(user.get(i))) {
                return false;
            }
        }
        return true;
    }
}
