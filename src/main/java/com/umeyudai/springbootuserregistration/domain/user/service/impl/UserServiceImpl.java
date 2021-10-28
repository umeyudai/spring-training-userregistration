package com.umeyudai.springbootuserregistration.domain.user.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.umeyudai.springbootuserregistration.domain.user.model.MUser;
import com.umeyudai.springbootuserregistration.domain.user.service.UserService;
import com.umeyudai.springbootuserregistration.repository.UserMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper mapper;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void signup(MUser user){
        user.setDepartmentId(1);
        user.setRole("ROLE_GENERAL");

        String rawPassword = user.getPassword();
        user.setPassword(encoder.encode(rawPassword));

        mapper.insertOne(user);
    }

    @Override
    public List<MUser> getUsers(MUser user){
        return mapper.findMany(user);
    }

    @Override
    public MUser getUserOne(String userId){
        return mapper.findOne(userId);
    }

    @Transactional
    @Override
    public void updateUserOne(String userId,String password,String userName){
        mapper.updateOne(userId,password,userName);

        String encryptPassword = encoder.encode(password);
        mapper.updateOne(userId,encryptPassword,userName);

        int i=1/0;
    }

    @Override
    public void deleteUserOne(String userId){
        mapper.deleteOne(userId);
    }

    @Override
    public MUser getLoginUser(String userId){
        return mapper.findLoginUser(userId);
    }
}
