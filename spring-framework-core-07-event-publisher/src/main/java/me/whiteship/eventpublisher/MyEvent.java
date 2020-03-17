package me.whiteship.eventpublisher;

public class MyEvent{
    private int data;

    // ApplicationEvent는 지웠지만 이벤트를 발생시킨 소스를 갖고 있고 싶다면 이렇게 한다.
    private Object source;

    public MyEvent(Object source, int data) {
        this.source = source;
        this.data = data;
    }

    public Object getSource() {
        return source;
    }

    public int getData() {
        return data;
    }
}