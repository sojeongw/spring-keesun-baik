package me.whiteship.componentscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootApplication
public class DemoApplication {

    // 아래에서 추가한 빈을 이렇게 사용할 수도 있다.
    @Autowired
    MyService myService;

    public static void main(String[] args) {
        // java 10 부터 추가된 타입
        var app = new SpringApplication(DemoApplication.class);

        // 만약 중간에 작업을 추가하고 싶다면 아래 내용을 추가한다.
        // 이 Initializer는 내가 원하는 애플리케이션 컨텍스트를 주입받을 수 있다.
        app.addInitializers((ApplicationContextInitializer<GenericApplicationContext>) ctx -> {
            // 빈 주입 시 아래처럼 원하는 코드를 추가할 수 있는 장점이 있다.
            /*
            if(){

            }
            */

            // 이 GenericApplicationContext을 가지고 직접 원하는 빈을 등록한다.
            ctx.registerBean(MyService.class);
            ctx.registerBean(ApplicationRunner.class, () -> args1
                    -> System.out.println("Functional Bean Definition!!"));
        });

        // 애플리케이션 실행 코드
        app.run(args);
    }
}
