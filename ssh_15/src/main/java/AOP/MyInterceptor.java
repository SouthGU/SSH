package AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/23/23:01
 * @Description:
 */
//定义切面
@Aspect
@Component
public class MyInterceptor {
    //定义切入点，定义切入点表达式及声明切入点
    @Pointcut("execution(* AOP.*.*(..))")
    private void anMethod(){}


    //定义环绕通知
    @Around("anMethod()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
        Object[] args=pjp.getArgs();
        if(args[0] == "sise") {

            Object result = pjp.proceed();//必须调用该方法，实现执行权限在切面链中的传递，直到最后传给业务方法
            System.out.println(args[0]+",您已经成功登陆，欢迎您！");
            return result;
        }else {
            System.out.println("用户名不正确，您没有权限登陆！");
            return  null;
        }


    }



}
