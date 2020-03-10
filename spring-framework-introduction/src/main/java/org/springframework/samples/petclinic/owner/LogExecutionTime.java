package org.springframework.samples.petclinic.owner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 어디에 쓸 수 있는지 설정한다. 여기서는 메서드에서 쓸 수 있도록 설정했다.
@Target(ElementType.METHOD)
// 애너테이션 정보를 런타임까지 유지한다고 설정한다.
@Retention(RetentionPolicy.RUNTIME)
public @interface LogExecutionTime {
}
