package com.umeyudai.springbootuserregistration.rest;

import com.umeyudai.springbootuserregistration.domain.user.service.UserService;
import com.umeyudai.springbootuserregistration.form.UserDetailForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRestController {
    @Autowired
    private UserService userService;

    @PutMapping("/update")
    public int updateUser(UserDetailForm form) {
        userService.updateUserOne(form.getUserId(), form.getPassword(), form.getUserName());

        return 0;
    }

    @DeleteMapping("/delete")
    public int deleteUser(UserDetailForm form) {
        userService.deleteUserOne(form.getUserId());

        return 0;
    }
}