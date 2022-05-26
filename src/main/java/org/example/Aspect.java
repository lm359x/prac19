package org.example;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {

    private long date;

    @Before("allServiceMethods()")
    public void startTime(JoinPoint joinPoint) {
        date = System.currentTimeMillis();
    }

    @After("allServiceMethods()")
    public void logTime(JoinPoint joinPoint){
        log.info("{} executed in {}", joinPoint.toString(),(double) (System.currentTimeMillis()-date));
    }
    @Pointcut("within(org.example.services.*)")
    public void allServiceMethods() {}
}
