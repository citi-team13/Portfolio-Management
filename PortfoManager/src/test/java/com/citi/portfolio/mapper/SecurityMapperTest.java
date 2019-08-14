package com.citi.portfolio.mapper;

import com.citi.portfolio.common.Assert;
import com.citi.portfolio.model.Security;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityMapperTest {

    @Autowired
    SecurityMapper securityMapper;

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void selectBySecurityName() {
    }

    @Test
    public void readSecurityList() {
        Map<String,Object> paramMap = new HashMap<>();
        int pageSize = 10;
        int page = 1;
        paramMap.put("page",(page-1) * pageSize);
        paramMap.put("pageSize", pageSize);
        Calendar cal= Calendar.getInstance();

        List<Map> securityInfoList = securityMapper.readSecurityList(paramMap);
        System.out.println(securityInfoList);
    }
}