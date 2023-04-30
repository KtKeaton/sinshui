package project.filter;

import project.util.TraceIdUtil;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

@Component
@Slf4j
@Aspect
public class RequestLogFilter extends AbstractRequestLoggingFilter {

    @Override
    protected void beforeRequest(@NonNull HttpServletRequest request, @NonNull String message) {
        final String traceId = request.getHeader(TraceIdUtil.TRACE_ID);
        if (StringUtils.isBlank(traceId)) {
            TraceIdUtil.generateAndSetTraceId();
        } else {
            TraceIdUtil.setTraceId(traceId);
        }
        log.info(message);
    }

    @Override
    protected void afterRequest(@NonNull HttpServletRequest request, @NonNull String message) {
        log.info(message);
        TraceIdUtil.clearTraceId();
    }


}
