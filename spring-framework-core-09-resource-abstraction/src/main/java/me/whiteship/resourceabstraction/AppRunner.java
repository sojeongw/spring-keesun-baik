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
        // 리소스 로더의 타입. 웹 애플리케이션 리소스로 나와야 한다.
        System.out.println(resourceLoader.getClass());

        // classpath를 뺐을 때는 리소스 로더가 웹 애플리케이션 컨텍스트이므로 서블릿으로 나와야 한다.
        Resource resource = resourceLoader.getResource("test.txt");
        System.out.println(resource.getClass());

        // 따라서 이 리소스를 웹 애플리케이션 루트부터 찾게 된다.
        // 하지만 스프링 부트에서 톰캣은 컨텍스트 패스가 기본적으로 지정되어있지 않다.
        // 결국 리소스를 찾을 수 없다.
        System.out.println(resource.exists());
        System.out.println(resource.getDescription());
        System.out.println(Files.readString(Path.of(resource.getURI())));
    }
}
