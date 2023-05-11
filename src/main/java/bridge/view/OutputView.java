package bridge.view;

import bridge.consts.Key;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 게임 시작 문구 출력
     */
    public void printStartBridgeGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    /**
     * 다리 길이 입력 문구 출력
     */
    public void printEnterBridgeLength() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    /**
     * 이동할 칸 선택 문구 출력
     */
    public void printSelectMoving() {
        System.out.println();
        System.out.printf("이동할 칸을 선택해주세요. (위: %s, 아래: %s)\n", Key.MOVING_UP, Key.MOVING_DOWN);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, List<String> user) {
        printMap(bridge, user, "U");
        printMap(bridge, user, "D");
    }

    /**
     * key 방향의 현재까지 이동한 다리 출력
     * @param bridge
     * @param user
     * @param key
     */
    private void printMap(List<String> bridge, List<String> user, String key) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        for (int i = 0; i < user.size(); i++) {
            String block = generateBlock(bridge.get(i), user.get(i), key);
            stringBuilder.append(block);
            if (i < user.size() - 1) {
                stringBuilder.append(" | ");
            }
        }
        stringBuilder.append(" ]");
        System.out.println(stringBuilder);
    }

    /**
     * key 방향의 현재 위치에서, 다리와 사용자 움직임을 비교해서 문자열을 반환하는 메소드
     * @param answer
     * @param moving
     * @param key
     * @return String
     */
    private String generateBlock(String answer, String moving, String key) {
        if (key.equals(moving)) {
            if (moving.equals(answer)) {
                return "O";
            }
            return "X";
        }
        return " ";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
