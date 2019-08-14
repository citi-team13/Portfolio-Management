package com.citi.portfolio.controller;


import com.citi.portfolio.common.Result;
import com.citi.portfolio.common.WebSecurityConfig;
import com.citi.portfolio.infra.services.UserService;
import com.citi.portfolio.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * 用户控制层
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     *
     * User Login
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Result getUserLogin(HttpSession session, @RequestParam(value = "phone") String phone, @RequestParam(value = "password") String password){
        User user = new User();
        user.setPhone(phone);
        user.setUserPwd(password);
        // 设置session
        session.setAttribute(WebSecurityConfig.SESSION_KEY, phone);
        return userService.userLogin(user,session);
    }

    /**
     * User Logout
     * @param session
     * @return
     */
    @GetMapping("/logout")
    @ResponseBody
    public Result logout(HttpSession session) {
        // 移除session
        session.invalidate();
        return Result.success("",200,"登出成功!");
    }

    /**
     * Get current user
     * @param session
     * @return
     */
    @GetMapping("/currentuser")
    @ResponseBody
    public Result getCurrentUser(HttpSession session){
        return userService.getCurrentUser(session);
    }



}

