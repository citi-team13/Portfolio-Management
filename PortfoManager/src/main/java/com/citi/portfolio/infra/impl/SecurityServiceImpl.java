package com.citi.portfolio.infra.impl;

import com.citi.portfolio.common.Assert;
import com.citi.portfolio.common.Result;
import com.citi.portfolio.infra.services.SecurityService;
import com.citi.portfolio.mapper.SecurityMapper;
import com.citi.portfolio.model.Security;
import com.citi.portfolio.util.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private SecurityMapper securityMapper;

    @Override
    public Result createSecurity(Security security) {

        security.setSecurityId(UUIDUtil.generateShortUuid(Security.getID_length()));
        Security temp =securityMapper.selectBySecurityName(security.getSecurityName());
        // 如果没有这个SecurityInfo
        if (Assert.isNotNULL(temp)){
            return Result.failure(402,"Security name 已存在!");
        }

        if (securityMapper.insert(security)>0){
            return Result.success(security,200,"success!");
        }else {
            return Result.failure(401,"create securityInfo failure!");
        }
    }

    @Override
    public Result readSecurity(String securityId) {
        //todo 与price表结合查询
        return null;
    }

    @Override
    public Result readSecurityList(String search, String securityType, int page) {
        int pageSize = 10;
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("search",search);
        paramMap.put("securityType",securityType);
        if (Assert.isEmpty(page))
            page = 1;
        paramMap.put("page",(page-1)*pageSize);
        paramMap.put("pageSize", pageSize);

        List<Map<String,Object>> securityInfoList = securityMapper.readSecurityList(paramMap);
        //todo 补上security的当天价格
        return Result.success(securityInfoList,200,"success");
    }

    @Override
    public Result updateSecurity(Security Record){
        if (securityMapper.updateByPrimaryKey(Record) > 0){
            return Result.success(Record,200,"success!");
        }else {
            return Result.failure(401,"update security failure!");
        }
    }

    public Result deleteSecurity(String securityId){
        if (securityMapper.deleteByPrimaryKey(securityId)>0){
            return Result.success(securityId,200,"success!");
        }else {
            return Result.failure(401,"delete security failure!");
        }
    }
}
