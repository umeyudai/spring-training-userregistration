package com.umeyudai.springbootuserregistration.domain.user.service;

import java.util.List;

import com.umeyudai.springbootuserregistration.domain.user.model.MUser;


public interface UserService {
    public void signup(MUser user);

    public List<MUser> getUsers(MUser user);

    public MUser getUserOne(String userId);

    public void updateUserOne(String userId, String password, String userName);

    public void deleteUserOne(String userId);

    public  MUser getLoginUser(String userId);
}
