package bridge.constants;

public class ErrorMessage {
    private static final String PREFIX = "[ERROR] ";

    public static final String INVALID_BRIDGE_SIZE = PREFIX + "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String INVALID_MOVING = PREFIX + "이동할 칸은 U 또는 D 여야 합니다.";
    public static final String INVALID_GAME_COMMAND = PREFIX + "게임 명령어는 R 또는 Q 여야 합니다.";
}
