package com.example.inflearnspringcore.app.v4;

import com.example.inflearnspringcore.trace.TraceStatus;
import com.example.inflearnspringcore.trace.logtrace.LogTrace;
import com.example.inflearnspringcore.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {
    private final LogTrace trace;

    public void save(String itemId) {
        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
            @Override
            protected Void call() {
                if (itemId.equals("ex")) {
                    throw new IllegalStateException("예외 발생!");
                }

                sleep(1000);
                return null;
            }
        };

        template.execute("OrderRepositoryV5.save()");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
