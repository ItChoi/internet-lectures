package com.example.inflearnspringcore.app.v4;

import com.example.inflearnspringcore.trace.TraceStatus;
import com.example.inflearnspringcore.trace.logtrace.LogTrace;
import com.example.inflearnspringcore.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {
    private final OrderRepositoryV4 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId) {

        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
            @Override
            protected Void call() {
                orderRepository.save(itemId);
                return null;
            }
        };

        template.execute("OrderServiceV5.orderItem()");
    }
}
