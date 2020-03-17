package me.whiteship.eventpublisher;

import org.springframework.context.ApplicationEvent;

// 이벤트는 빈으로 등록되지 않는다. 원하는 데이터를 전달하는 역할이다.
public class MyEvent extends ApplicationEvent{
    private int data;

    public MyEvent(Object source) {
        super(source);
    }

    public MyEvent(Object source, int data) {
        super(source);
        this.data = data;
    }

    public int getData() {
        return data;
    }
}