package com.citi.portfolio.infra.impl;

import com.citi.portfolio.infra.services.ExampleService;
import com.citi.portfolio.mapper.ExampleUserMapper;
import com.citi.portfolio.model.ExampleUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ExampleServiceImpl implements ExampleService {

    @Autowired
    private ExampleUserMapper exampleUserMapper;

    @Override
    public ExampleUser createUser(ExampleUser user) {
            // 数据库层面不做真实例子
            exampleUserMapper.insert(user);
        return user;
    }
}
