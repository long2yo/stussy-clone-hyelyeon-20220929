package com.stussy.stussyclonehyelyeon20220929.repository;

import com.stussy.stussyclonehyelyeon20220929.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountRepository {
    public int save(User user);

    //User 찾기
    public User findUserByEmail(String Email);
}