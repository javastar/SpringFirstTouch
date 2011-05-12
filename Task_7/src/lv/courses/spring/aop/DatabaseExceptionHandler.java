package lv.courses.spring.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class DatabaseExceptionHandler {

    private static Logger logger = Logger.getLogger(DatabaseExceptionHandler.class);


    @AfterThrowing("execution(* lv.courses.spring.database.Database.*(..))")
    public void doRecoveryActions() {
        logger.info("DatabaseExceptionHandler: EXCEPTION Happened!");
        logger.info("DatabaseExceptionHandler: RECOVERY PROCESS DONE!");
    }

}
