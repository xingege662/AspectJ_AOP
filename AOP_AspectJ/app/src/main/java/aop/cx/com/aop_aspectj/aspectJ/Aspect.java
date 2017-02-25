package aop.cx.com.aop_aspectj.aspectJ;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import aop.cx.com.aop_aspectj.AopAnnotion;

/**
 * Created by cx on 2017/2/25.
 */

@org.aspectj.lang.annotation.Aspect
public class Aspect {

    @Pointcut("execution(@aop.cx.com.aop_aspectj.AopAnnotion * *(..))")
    public void pointCut(){

    }
    @Around("pointCut()")
    public Object weaveJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        //joinPoint 切点,面由点构成
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        //这个切点是哪个类的哪个方法
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        AopAnnotion annotation = methodSignature.getMethod().getAnnotation(AopAnnotion.class);

        String funcName = annotation.value();
        long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long duration = System.currentTimeMillis() - begin;
        Log.d("tag", String.format("功能：%s，%s 的  %s 方法执行，耗时：%d ms",funcName,className,methodName,duration));
        return result;
    }
}
