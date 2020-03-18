package me.whiteship.resourceabstraction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class AppRunner implements ApplicationRunner {
    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 클래스 패스 기준으로 configLocation에 해당하는 문자열을 가지고 빈 설정 파일을 찾는다.
        var ctx1 = new ClassPathXmlApplicationContext("configtest.xml");
        // 파일 시스템 기준으로 configLocation에 해당하는 문자열을 가지고 빈 설정 파일을 찾는다.
        var ctx2 = new FileSystemXmlApplicationContext("configtest.xml");
        // 애플리케이션 루트 기준으로 configLocation에 해당하는 문자열을 가지고 빈 설정 파일을 찾는다.
        var ctx3 = new WebApplicationContext("config.xml");

    }
}
