package com.liys.singleclick;

import android.view.View;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class SingleClickAspect {

    //拦截方法
    @Around("execution(@com.liys.singleclick.SingleClick  * *(..)) && @annotation(singleClick)")
    public void singleClick(ProceedingJoinPoint joinPoint, SingleClick singleClick) throws Throwable {

        //1. 获取view
        View view = null;
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof View) {
                view = (View) arg;
                break;
            }
        }
        if (view == null) {
            return;
        }
        //2. 判断是否是快速点击事件
        if(!XClickUtil.isFastDoubleClick(view, singleClick.value())){
            joinPoint.proceed(); // 继续执行原来的方法
        }
    }
}
