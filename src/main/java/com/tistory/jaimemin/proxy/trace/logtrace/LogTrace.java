package com.tistory.jaimemin.proxy.trace.logtrace;

import com.tistory.jaimemin.proxy.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);
}
