package me.whiteship.eventpublisher;

import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class MyEventHandler{
    // 이벤트를 처리하는 메서드 위에 에너테이션을 추가해준다.
    // 이제 메서드 이름을 마음대로 바꿔도 된다.
    @EventListener
    // 실행 순서 지정
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public void handle(MyEvent myEvent) {
        // 스레드 확인용
        System.out.println(Thread.currentThread().toString());
        System.out.println("이벤트 받았다. 데이터는 " + myEvent.getData());
    }
}