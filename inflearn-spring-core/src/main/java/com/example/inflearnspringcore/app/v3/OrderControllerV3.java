package com.example.inflearnspringcore.app.v3;

import com.example.inflearnspringcore.LogTraceConfig;
import com.example.inflearnspringcore.trace.TraceStatus;
import com.example.inflearnspringcore.trace.hellotrace.HelloTraceV2;
import com.example.inflearnspringcore.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {
    private final OrderServiceV3 orderService;
    private final LogTrace trace;

    @GetMapping("/v3/request")
    public String request(String itemId) {

        TraceStatus status = null;
        try {
            status = trace.begin("OrderController.request()");
            orderService.orderItem(itemId);
            trace.end(status);
            return "ok";
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
