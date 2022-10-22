package com.stussy.stussyclonehyelyeon20220929.aop;

import com.stussy.stussyclonehyelyeon20220929.exception.CustomValidationException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Aspect
@Component
public class ValidationAop {

    @Pointcut("@annotation(com.stussy.stussyclonehyelyeon20220929.aop.annotation.ValidAspect)")
    private void pointCut(){

    }

//    @Around("pointCut()")
//    private Object arround(ProceedingJoinPoint joinPoint) throws Throwable{
//        Object[] args = joinPoint.getArgs();
//
//        BeanPropertyBindingResult bindingResult = null;
//
//        for(Object arg : args){
//            if(arg.getClass() == BeanPropertyBindingResult.class){
//                bindingResult = (BeanPropertyBindingResult) arg;    //BeanPropertyBindingResult 객체 찾앗다!
//                break;
//            }
//        }
    
//    before에는  return 이 없다
        @Around("pointCut()")
        private void before(JoinPoint joinPoint) throws Throwable{

        Object[] args = joinPoint.getArgs();

        BeanPropertyBindingResult bindingResult = null;

            for(Object arg : args){
                if(arg.getClass() == BeanPropertyBindingResult.class){
                    bindingResult = (BeanPropertyBindingResult) arg;    //BeanPropertyBindingResult 객체 찾앗다!
                    break;
                }
            }
//        arround 일때만 쓴다
//        if(bindingResult == null){
//            return joinPoint.proceed();
//        }

//      AccountApi에 있는 것을 복사해서 수정
        if(bindingResult.hasErrors()){
//            log.error("유효성 검사 오류가 발생");

            Map<String, String> errorMap = new HashMap<String, String>();

            bindingResult.getFieldErrors().forEach(error -> {
                errorMap.put(error.getField(), error.getDefaultMessage());
            });


              throw new CustomValidationException("Validation failed", errorMap);

            //            return ResponseEntity.badRequest().body(new CMRespDto<>(-1,"유효성 검사 실패",errorMap));
        }

//        return null; 해도 되고
//        return joinPoint.proceed(); 이것을 기준으로 전 후 나뉜다 후는 거의 쓰지 않는다

    }
    @AfterReturning(value =  "pointCut()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        log.info("Validation success: {}", returnObj);
    }

}