package project.data.base;

import project.enums.ResponseCode;
import project.util.TraceIdUtil;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ResponseData<T> {
    private String traceId;
    private Integer code;
    private String message;
    private LocalDateTime dateTime;
    private T data;

    public static <T> ResponseData<T> response(ResponseCode responseCode, T response) {
        return ResponseData.<T>builder()
                .traceId(TraceIdUtil.getTraceId())
                .code(responseCode.getCode())
                .message(responseCode.name())
                .dateTime(LocalDateTime.now())
                .data(response)
                .build();
    }


}
