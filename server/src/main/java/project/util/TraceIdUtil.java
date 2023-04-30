package project.util;

import org.slf4j.MDC;

import java.util.Map;
import java.util.UUID;

public class TraceIdUtil {

    public static final String TRACE_ID = "TRACE_ID";

    public static String generateTraceId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void setTraceId(final String traceId) {
        MDC.put(TRACE_ID, traceId);
    }

    public static void generateAndSetTraceId() {
        MDC.put(TRACE_ID, generateTraceId());
    }

    public static String getTraceId() {
        return MDC.get(TRACE_ID);
    }

    public static void clearTraceId() {
        MDC.clear();
    }

    public static Runnable IncludeTraceId(final Runnable runnable) {
        final Map<String, String> contestMap = MDC.getCopyOfContextMap();
        return () -> {
            MDC.setContextMap(contestMap);
            runnable.run();
        };
    }
}
