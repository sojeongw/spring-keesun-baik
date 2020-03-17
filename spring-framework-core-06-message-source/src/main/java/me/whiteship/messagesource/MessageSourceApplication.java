package me.whiteship.messagesource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringBootApplication
public class MessageSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageSourceApplication.class, args);
    }

    // message를 직접 정의하는 방법
    @Bean
    // 빈 이름은 항상 messageSource가 되어야 한다.
    public MessageSource messageSource() {
        var messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/messages");

        // 한글이 깨지므로 인코딩 해준다.
        messageSource.setDefaultEncoding("UTF-8");

        // 리소스를 캐시하는 시간을 3초로 설정한다.
        messageSource.setCacheSeconds(3);

        return messageSource;
    }
}
