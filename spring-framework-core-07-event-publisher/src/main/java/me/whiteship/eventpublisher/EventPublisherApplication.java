package me.whiteship.eventpublisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
// Async로 하려면 아래 애너테이션이 필요하다.
@EnableAsync
public class EventPublisherApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventPublisherApplication.class, args);
    }

}
