package com.citi.portfolio.util;

import com.citi.portfolio.common.Assert;
import com.citi.portfolio.common.Result;
import com.citi.portfolio.mapper.PortfolioItemMapper;
import com.citi.portfolio.mapper.UserMapper;
import com.citi.portfolio.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class GetDate {
    @Autowired
    private static UserMapper userMapper;

    // 获取当前日期：yyyy-MM-dd
    public static String getCurrentDate(){
        String pattern="yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format( new Date());
    }



}