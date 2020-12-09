package com.cuixb.annotationWithAOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName TokenAspect
 * @Description token校验自定义注解
 */
@Aspect
@Component
@SuppressWarnings({"unused"})
public class TokenAspect {

    public static final Logger logger = LoggerFactory.getLogger(TokenAspect.class);

    public static final String TOKEN_KEY = "token";


    @Pointcut("@annotation(com.cuixb.annotationWithAOP.Token)")
    public void annotationPointcut() {

    }

    @Before("annotationPointcut()")
    public void beforePointcut(JoinPoint joinPoint) {
    	// 此处进入到方法前  可以实现一些业务逻辑
    }

    @Around("annotationPointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String[] params = methodSignature.getParameterNames();// 获取参数名称
        Object[] args = joinPoint.getArgs();// 获取参数值
        if (null == params || params.length == 0){
            String mes = "Using Token annotation, the token parameter is not passed, and the parameter is not valid.";
            logger.info(mes);
            throw new Exception(mes);
        }
        boolean hasToken = false;
        int index = 0;
        for (int i = 0; i < params.length; i++) {
            if (TOKEN_KEY.equals(params[i])) {
                hasToken = true;
                index = i;
                break;
            }
        }
        if (!hasToken){
            String mes = "The token parameter is not included in the requested parameter, the parameter is not valid.";
            System.out.println(mes);
        }
        this.checkToken(String.valueOf(args[index]));
        return joinPoint.proceed();
    }

    /**
     * 在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理）
     * @param joinPoint
     */
    @AfterReturning("annotationPointcut()")
    public void doAfterReturning(JoinPoint joinPoint) {
    }

    private void checkToken(String token) {

        try {
            System.out.println("checkToken 代码处理");
        } catch (Exception e) {
            logger.info(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

}