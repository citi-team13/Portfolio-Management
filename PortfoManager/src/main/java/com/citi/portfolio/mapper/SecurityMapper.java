package com.citi.portfolio.mapper;

import com.citi.portfolio.model.Security;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecurityMapper {
    int deleteByPrimaryKey(String securityId);

    int insert(Security record);

    Security selectByPrimaryKey(String securityId);

    List<Security> selectAll();

    int updateByPrimaryKey(Security record);
}