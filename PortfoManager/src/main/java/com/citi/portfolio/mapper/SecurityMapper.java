package com.citi.portfolio.mapper;

import com.citi.portfolio.model.Security;

import java.util.List;
import java.util.Map;

public interface SecurityMapper {

    int deleteByPrimaryKey(String securityId);

    int insert(Security record);

    int insertSelective(Security record);

    Security selectByPrimaryKey(String securityId);

    int updateByPrimaryKeySelective(Security record);

    int updateByPrimaryKey(Security record);

    Security selectBySecurityName(String securityName);

    List<Map> readSecurityList(Map<String, Object> paramMap);
}