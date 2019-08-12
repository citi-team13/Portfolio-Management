package com.citi.portfolio.infra.services;


import com.citi.portfolio.model.ExampleUser;

public interface ExampleService {

    /**
     * 示例：创建用户
     *
     * @param user 用户信息
     * @return 创建后用户对象
     */
    ExampleUser createUser(ExampleUser user);
}
