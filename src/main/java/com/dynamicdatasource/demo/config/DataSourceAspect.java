package com.dynamicdatasource.demo.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Order(-10)
public class DataSourceAspect {
    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Pointcut("@annotation(com.dynamicdatasource.demo.config.SwitchDataSource)")
    public void annotationPointCut() {
        //default function
    }


    @Before("annotationPointCut()")
    public void before(JoinPoint joinPoint){
        MethodSignature sign =  (MethodSignature)joinPoint.getSignature();
        Method method = sign.getMethod();
        SwitchDataSource annotation = method.getAnnotation(SwitchDataSource.class);
        if(annotation != null){
            AbstractRoutingDataSourceImpl.setDatabaseName(annotation.value());
            logger.info("Switch DataSource to [{}] in Method [{}]",
                annotation.value(), joinPoint.getSignature());
        }
    }

    @After("annotationPointCut()")
    public void after(JoinPoint point){
        if(null != AbstractRoutingDataSourceImpl.getDatabaseName()) {
            logger.info("Restore DataSource to [{}] in Method [{}]",
                AbstractRoutingDataSourceImpl.getDatabaseName(), point.getSignature());
            AbstractRoutingDataSourceImpl.removeDatabaseName();
        }
    }
}
