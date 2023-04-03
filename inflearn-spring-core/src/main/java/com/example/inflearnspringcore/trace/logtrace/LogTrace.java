package com.example.inflearnspringcore.trace.logtrace;

import com.example.inflearnspringcore.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status,
                   Exception e);
}
