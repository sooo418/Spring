package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class TimeCheckAdvice {
	Logger LOGGER = LoggerFactory.getLogger("root");
	
	@Pointcut("execution(* spring.biz.*.service.*Service.*(..))")
	public void pointcut_a() {	}
	
	@Around("pointcut_a()")
	public Object aroundTimeCheck(ProceedingJoinPoint pp) throws Throwable {
		String methodName = pp.getSignature().getName();
		String msg = null;
		StopWatch sw = new StopWatch();
		System.out.println("시간측정 시작");
		sw.start();
		
		Object obj = pp.proceed();
		
		sw.stop();
		System.out.println("시간측정 종료");
		Long time = sw.getTotalTimeMillis();
		System.out.println(methodName+"함수 수행시간 : " + time +"(ms)");
		
		return obj;
	}
	
}
