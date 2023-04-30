package project.exception;

import lombok.Getter;
import project.enums.ResponseCode;

@Getter
public class GlobalRuntimeException extends RuntimeException {
    private final ResponseCode responseCode;

    public GlobalRuntimeException(ResponseCode responseCode) {
        super(responseCode.name());
        this.responseCode = responseCode;
    }
}
