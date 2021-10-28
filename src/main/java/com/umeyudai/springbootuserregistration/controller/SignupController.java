package com.umeyudai.springbootuserregistration.controller;

import java.util.Locale;
import java.util.Map;

import com.umeyudai.springbootuserregistration.domain.user.model.MUser;
import com.umeyudai.springbootuserregistration.domain.user.service.UserService;
import com.umeyudai.springbootuserregistration.form.GroupOrder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.umeyudai.springbootuserregistration.application.service.UserApplicationService;
import com.umeyudai.springbootuserregistration.form.SignupForm;
import lombok.extern.slf4j.Slf4j;


@Controller
@RequestMapping("/user")
@Slf4j
public class SignupController {
    @Autowired
    private UserApplicationService userApplicationService;

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping("/signup")
    public String getSignup(Model model, Locale locale, @ModelAttribute SignupForm form) {
        Map<String, Integer> genderMap = userApplicationService.getGenderMap(locale);
        model.addAttribute("genderMap", genderMap);

        return "user/signup";
    }

    @PostMapping("/signup")
    public String postSignup(Model model, Locale locale, @ModelAttribute @Validated(GroupOrder.class) SignupForm form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()){
            return getSignup(model, locale, form);
        }
        log.info(form.toString());

        MUser user = modelMapper.map(form, MUser.class);
        userService.signup(user);

        return "redirect:/login";
    }

    @ExceptionHandler(DataAccessException.class)
    public String dataAccessExceptionHandler(DataAccessException e, Model model){
        model.addAttribute("error", "");

        model.addAttribute("message","SignupControllerで例外が発生！");

        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);

        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e, Model model){
        model.addAttribute("error", "");

        model.addAttribute("message","SignupControllerで例外が発生！！");

        model.addAttribute("status",HttpStatus.INTERNAL_SERVER_ERROR);

        return  "error";
    }
}
