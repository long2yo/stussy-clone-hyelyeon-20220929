package com.stussy.stussyclonehyelyeon20220929.service;

import com.stussy.stussyclonehyelyeon20220929.dto.account.RegisterReqDto;

public interface AccountService {
    public boolean checkDuplicateEmail(String email);

    public boolean register(RegisterReqDto registerReqDto) throws Exception;
}
