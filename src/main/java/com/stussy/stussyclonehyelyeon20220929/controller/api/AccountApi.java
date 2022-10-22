package com.stussy.stussyclonehyelyeon20220929.controller.api;


import com.stussy.stussyclonehyelyeon20220929.aop.annotation.LogAspect;
import com.stussy.stussyclonehyelyeon20220929.aop.annotation.ValidAspect;
import com.stussy.stussyclonehyelyeon20220929.dto.account.RegisterReqDto;
import com.stussy.stussyclonehyelyeon20220929.dto.CMRespDto;
import com.stussy.stussyclonehyelyeon20220929.dto.validation.ValidationSequence;
import com.stussy.stussyclonehyelyeon20220929.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/api/account")
@RestController
@RequiredArgsConstructor
public class AccountApi {

    private final AccountService accountService;

    @LogAspect
    @ValidAspect
    @PostMapping("/register")
    public ResponseEntity<?> register(@Validated(ValidationSequence.class) @RequestBody RegisterReqDto registerReqDto, BindingResult bindingResult) throws Exception{

        accountService.checkDuplicateEmail(registerReqDto.getEmail());

        // @RequestBody : json으로 날릴려고
        // @Valid : 유효성 체크를 해준다
        // @Valid를 주고 Dto에 사용하면 BindingResult 객체가 따라온다


//[1번 유형 ]
//            bindingResult.getFieldErrors().forEach(error -> {
//                log.info("Error: 코드({}), 필드명({}) , 메세지({})", error.getCode(), error.getField(), error.getDefaultMessage());
//                if(!error.getCode().equals("NotBlank")){
//
//                    //error 메세지 날려주는 기능
//                    errorMap.put(error.getField(), error.getDefaultMessage());
//                }
//            });
//            bindingResult.getFieldErrors().forEach(error -> {
//                log.info("Error: 코드({}), 필드명({}) , 메세지({})", error.getCode(), error.getField(), error.getDefaultMessage());
//                if(error.getCode().equals("NotBlank")){
//
//                    //error 메세지 날려주는 기능
//                    errorMap.put(error.getField(), error.getDefaultMessage());
//                }
//            });



//        StopWatch stopWatch = new StopWatch();

//      [시작]
//        stopWatch.start();

//[ValidAspect를 달면 여기서 부터 없어져야 함]
//            bindingResult.getFieldErrors().forEach(error -> {
//                log.info("Error: 코드({}), 필드명({}) , 메세지({})", error.getCode(), error.getField(), error.getDefaultMessage());
//                if(!error.getCode().equals("NotBlank")){
//
//                    //error 메세지 날려주는 기능
//                    errorMap.put(error.getField(), error.getDefaultMessage());
//                }
//            });
//            bindingResult.getFieldErrors().forEach(error -> {
//                log.info("Error: 코드({}), 필드명({}) , 메세지({})", error.getCode(), error.getField(), error.getDefaultMessage());
//                if(error.getCode().equals("NotBlank")){
//
//                    //error 메세지 날려주는 기능
//                    errorMap.put(error.getField(), error.getDefaultMessage());
//                }
//            });

//            return ResponseEntity.badRequest().body(new CMRespDto<>(-1 , "유효성 검사 실패", errorMap));
//        }
//[여기까지 없어져야 함]

//        [멈춤]
//        stopWatch.stop();

//        log.info("메소드 실행시간 >>> {}", stopWathch.getTotalTimeSeconds());

//        log.info("{}", registerReqDto);

        return ResponseEntity.ok().body(new CMRespDto<>(1, "successfully registered", registerReqDto));
    }

}
