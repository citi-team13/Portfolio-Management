package com.citi.portfolio.mapper;

import com.citi.portfolio.model.ExampleUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ExampleUserMapper {

    int insert(ExampleUser user);

    List<Map> selectTest();

}