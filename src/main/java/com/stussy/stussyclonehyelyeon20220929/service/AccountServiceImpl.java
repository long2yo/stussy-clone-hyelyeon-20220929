package com.stussy.stussyclonehyelyeon20220929.service;

import com.stussy.stussyclonehyelyeon20220929.domain.User;
import com.stussy.stussyclonehyelyeon20220929.dto.account.RegisterReqDto;
import com.stussy.stussyclonehyelyeon20220929.exception.CustomValidationException;
import com.stussy.stussyclonehyelyeon20220929.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl  implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public boolean checkDuplicateEmail(String email) {

        User user = accountRepository.findUserByEmail(email);
        if(user != null) {
            Map<String, String> errorMap = new HashMap<String, String>();
            errorMap.put("duplicateFlag", "이미 가입된 이메일입니다");
            throw new CustomValidationException("DuplicateEmail Error", errorMap);
        }

        return true;
    }

    @Override
    public boolean register(RegisterReqDto registerReqDto) throws Exception {
        User userEntity = registerReqDto.toUserEntity();
        int result = accountRepository.save(userEntity);

        return result != 0;
    }
}