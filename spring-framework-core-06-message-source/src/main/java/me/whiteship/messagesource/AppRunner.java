package me.whiteship.messagesource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class AppRunner implements ApplicationRunner {
    @Autowired
    MessageSource messageSource;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // message_ko_KR.properties
        System.out.println(messageSource.getMessage("greeting", new String[]{"keesun"}, Locale.KOREA));
        // messages.properties
        // OS 기본 언어 설정에 기반하기 때문에 나는 한국어로 출력된다.
        System.out.println(messageSource.getMessage("greeting", new String[]{"keesun"}, Locale.getDefault()));
    }
}
