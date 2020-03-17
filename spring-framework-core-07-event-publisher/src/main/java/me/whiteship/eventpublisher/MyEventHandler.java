package me.whiteship.eventpublisher;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventHandler{
    // 이벤트를 처리하는 메서드 위에 에너테이션을 추가해준다.
    // 이제 메서드 이름을 마음대로 바꿔도 된다.
    @EventListener
    public void handle(MyEvent myEvent) {
        System.out.println("이벤트 받았다. 데이터는 " + myEvent.getData());
    }
}
