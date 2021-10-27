package com.umeyudai.springbootuserregistration.form;
import java.util.Date;

import com.umeyudai.springbootuserregistration.domain.user.model.Department;
import lombok.Data;

@Data
public class UserDetailForm {
    private String userId;
    private String password;
    private String userName;
    private Date birthday;
    private Integer age;
    private Integer gender;

    private Department department;
}
