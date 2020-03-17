package me.whiteship.eventpublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {
    // ApplicationContext가 Publisher를 상속하고 있으므로 이것을 써도 되지만 Publisher를 직접 써도 된다.
    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        applicationEventPublisher.publishEvent(new MyEvent(this, 100));
    }
}
