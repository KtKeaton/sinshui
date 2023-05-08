package project.enums;

public enum ResponseCode {
    SUCCESS(200),
    SERVER_ERROR(500),
    POSITION_NOT_FOUND_ERROR(602),
    COMPANY_NOT_FOUND_ERROR(603),
    COMPANY_NAME_DUPLICATE_ERROR(604),
    POSITION_DUPLICATE_ERROR(605),
    CONSTRAINT_VIOLATION_ERROR(606),
    COMPANY_TYPE_NOT_FOUND_ERROR(607),
    ;

    private final int code;

    ResponseCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
