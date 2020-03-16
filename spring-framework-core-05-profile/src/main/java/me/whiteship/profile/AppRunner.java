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
        // 현재 등록된 프로파일을 불러온다.
        System.out.println(Arrays.toString(environment.getActiveProfiles()));
        // 현재 기본으로 등록된 프로파일을 볼러온다.
        System.out.println(Arrays.toString(environment.getDefaultProfiles()));
    }
}