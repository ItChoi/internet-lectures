package com.example.inflearnspringcore.trace;

import lombok.Getter;

import java.util.UUID;

@Getter
public class TraceId {
    private String id; // 트랜잭션 아이디
    private int level; // 로그 계층간 깊이 표현 숫자

    private TraceId(String id, int level) {
        this.id = id;
        this.level = level;
    }

    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    private String createId() {
        return UUID.randomUUID().toString().substring(0, 8); // 8자리면, 중복이될 수 있긴 하지만, 가능성이 적다.
    }

    public TraceId createNextId() {
        return new TraceId(id, level + 1);
    }

    public TraceId createPreviousId() {
        return new TraceId(id, level - 1);
    }

    public boolean isFirstLevel() {
        return level == 0;
    }
}
