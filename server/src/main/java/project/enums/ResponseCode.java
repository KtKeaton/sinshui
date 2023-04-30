package project.enums;

public enum ResponseCode {
    SUCCESS(200),
    CLIENT_ERROR(400),
    SERVER_ERROR(500),
    POSITION_LEVEL_NOT_FOUND_ERROR(601),
    POSITION_TYPE_NOT_FOUND_ERROR(602),
    ;

    private final int code;

    ResponseCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
