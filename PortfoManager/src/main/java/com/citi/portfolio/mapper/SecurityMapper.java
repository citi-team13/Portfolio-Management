package com.citi.portfolio.mapper;

import com.citi.portfolio.model.Security;
import com.citi.portfolio.model.SecurityExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SecurityMapper {
    int countByExample(SecurityExample example);

    int deleteByExample(SecurityExample example);

    int deleteByPrimaryKey(String securityId);

    int insert(Security record);

    int insertSelective(Security record);

    List<Security> selectByExample(SecurityExample example);

    Security selectByPrimaryKey(String securityId);

    int updateByExampleSelective(@Param("record") Security record, @Param("example") SecurityExample example);

    int updateByExample(@Param("record") Security record, @Param("example") SecurityExample example);

    int updateByPrimaryKeySelective(Security record);

    int updateByPrimaryKey(Security record);

    Security selectBySecurityName(String securityName);

    List<Map<String, Object>> readSecurityList(Map<String, Object> paramMap);
}