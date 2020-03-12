package me.whiteship.springapplicationcontext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// basePackages는 일일이 패키지 이름을 써줘야 하므로 오타로 에러가 날 확률이 있다.
// 하지만 basePackageClasses를 쓰면 조금 더 type-safe 하다.
// 써놓은 클래스가 위치한 곳부터 컴포넌트 스캐닝을 하기 때문이다.
@ComponentScan(basePackageClasses = DemoApplication.class)
public class ApplicationConfig {
}
