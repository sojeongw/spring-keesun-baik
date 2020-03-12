package me.whiteship.springapplicationcontext;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();

        // [bookService, bookRepository]
        System.out.println(Arrays.toString(beanDefinitionNames));

        // 출력된 빈 이름으로 불러온다.
        BookService bookService = (BookService)context.getBean("bookService");
        // true
        System.out.println(bookService.bookRepository != null);
    }
}
