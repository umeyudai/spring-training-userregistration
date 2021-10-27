package com.umeyudai.springbootuserregistration.domain.user.service;
import java.util.List;

import com.umeyudai.springbootuserregistration.domain.user.model.MUser;


public interface UserService {
    public void signup(MUser user);

    public List<MUser> getUsers();
}
