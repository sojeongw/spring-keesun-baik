package me.whiteship.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class AppRunner implements ApplicationRunner {
    @Autowired
    ApplicationContext ctx;

    @Autowired
    BookRepository bookRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // EnvironmentCapable 인터페이스에서 가져온 getEnvironment 메서드
        Environment environment = ctx.getEnvironment();
        // 설정한 VM 옵션을 출력한다.
        System.out.println(environment.getProperty("app.name"));
        // properties 파일르 설정한 값을 출력한다.
        System.out.println(environment.getProperty("app.about"));
    }
}