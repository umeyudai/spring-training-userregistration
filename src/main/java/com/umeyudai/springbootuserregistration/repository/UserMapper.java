package com.umeyudai.springbootuserregistration.repository;
import org.apache.ibatis.annotations.Mapper;
import com.umeyudai.springbootuserregistration.domain.user.model.MUser;

import java.util.List;

@Mapper
public interface UserMapper {
    public int insertOne(MUser user);

    public List<MUser> findMany();
}
