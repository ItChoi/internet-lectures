package com.example.inflearnspringcore;

import com.example.inflearnspringcore.trace.logtrace.FieldLogTrace;
import com.example.inflearnspringcore.trace.logtrace.LogTrace;
import com.example.inflearnspringcore.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        //return new FieldLogTrace();
        return new ThreadLocalLogTrace();
    }
}
