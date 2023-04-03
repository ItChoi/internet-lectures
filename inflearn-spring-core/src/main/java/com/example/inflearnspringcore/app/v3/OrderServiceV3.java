package com.example.inflearnspringcore.app.v3;

import com.example.inflearnspringcore.trace.TraceId;
import com.example.inflearnspringcore.trace.TraceStatus;
import com.example.inflearnspringcore.trace.hellotrace.HelloTraceV2;
import com.example.inflearnspringcore.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {
    private final OrderRepositoryV3 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId) {

        TraceStatus status = null;
        try {
            status = trace.begin("OrderServiceV5.orderItem()");
            orderRepository.save(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
