package com.umeyudai.springbootuserregistration.repository;
import org.apache.ibatis.annotations.Mapper;
import com.umeyudai.springbootuserregistration.domain.user.model.MUser;

@Mapper
public interface UserMapper {
    public int insertOne(MUser user);
}
