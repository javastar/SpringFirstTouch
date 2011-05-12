package lv.courses.spring.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class DatabaseOperationLogger {

    private static Logger logger = Logger.getLogger(DatabaseOperationLogger.class);


    @Around("execution(* lv.courses.spring.database.Database.*(..))")
    public Object doProfiling(ProceedingJoinPoint pjp) throws Throwable {
        return doTimeProfiling(pjp);
    }


    public Object doTimeProfiling(ProceedingJoinPoint pjp) throws Throwable {
        String measurementName = getMeasurementName(pjp);
        long startTime = logStartTime(measurementName);

        try {
            return pjp.proceed();
        }
        finally {
            logExecutionTime(measurementName, startTime);
        }
    }

    private String getMeasurementName(ProceedingJoinPoint pjp) {
        String className = pjp.getTarget().getClass().getName();
        String methodName = pjp.getSignature().getName();
        String measurementName = className + "." + methodName + "()";
        return measurementName;
    }

    private long logStartTime(String measurementName) {
        long startTime = System.currentTimeMillis();
        logger.info("Start of invocation: " + measurementName);
        return startTime;
    }

    private void logExecutionTime(String measurementName, long startTime) {
        long executionTime = System.currentTimeMillis() - startTime;
        logger.info("End of invocation: " + measurementName + " time = " + executionTime);
    }

}
