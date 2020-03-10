package org.springframework.samples.petclinic.owner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

// 빈으로 등록되어야 하므로 컴포넌트 애너테이션을 붙인다.
@Component
// Aspect 라는 것을 알려준다.
@Aspect
public class LogAspect {
    Logger logger = LoggerFactory.getLogger(LogAspect.class);

    // Around 애너테이션을 사용하면 joinPoint를 사용할 수 있다.
    // joinPoint란 우리가 커스텀해서 만든 애너테이션을 적용할 타겟을 의미한다.
    // 즉, OwnerController에서 @LogExecutionTime을 붙인 메서드들이다.
    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // 타겟인 메서드가 JoinPoint 타입의 인터페이스로 들어오면 실행한다.
        Object proceed = joinPoint.proceed();

        // 메서드 앞 뒤로 스탑워치를 실행한다.
        stopWatch.stop();
        logger.info(stopWatch.prettyPrint());

        return proceed;
    }
}
