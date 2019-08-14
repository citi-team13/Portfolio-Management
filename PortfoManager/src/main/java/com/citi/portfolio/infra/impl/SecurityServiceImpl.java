package com.citi.portfolio.infra.impl;

import com.citi.portfolio.common.Assert;
import com.citi.portfolio.common.Result;
import com.citi.portfolio.infra.services.SecurityService;
import com.citi.portfolio.mapper.PriceMapper;
import com.citi.portfolio.mapper.SecurityMapper;
import com.citi.portfolio.model.Price;
import com.citi.portfolio.model.Security;
import com.citi.portfolio.util.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Slf4j
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private SecurityMapper securityMapper;

    @Autowired
    private PriceMapper priceMapper;

    @Override
    public Result createSecurity(Security security) {

        security.setSecurityId(UUIDUtil.generateShortUuid(Security.getID_length()));
        Security temp =securityMapper.selectBySecurityName(security.getSecurityName());
        // 如果没有这个SecurityInfo
        if (Assert.isNotNULL(temp)){
            return Result.failure(402,"Security name exists!");
        }

        if (securityMapper.insert(security)>0){
            return Result.success(security,200,"success!");
        }else {
            return Result.failure(401,"create securityInfo failure!");
        }
    }

    @Override
    public Result readSecurity(String securityId) {
        Security security = securityMapper.selectByPrimaryKey(securityId);
        if(Assert.isNotNULL(security)){
            List<Price> priceList = priceMapper.selectBySecurityId(securityId);
            if(Assert.isNULL(priceList)){
                return Result.success(priceList,200,"Price read successfully!");
            }
            else{
                return Result.failure(402,"Price read failure");
            }
        }
        else{
            return Result.failure(402,"There is no security with this ID.");
        }

    }

    @Override
    public Result readSecurityList(String search, String securityType, int page, int pageSize) {
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("search",search);
        if (Assert.isEmpty(pageSize))
            pageSize = 10;
        paramMap.put("securityType",securityType);
        if (Assert.isEmpty(page))
            page = 1;
        paramMap.put("page",(page-1) * pageSize);
        paramMap.put("pageSize", pageSize);
        Calendar cal= Calendar.getInstance();
        Date today = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        cal.add(Calendar.DATE,-1);
        Date yesterday = cal.getTime();

        List<Map> securityInfoList = securityMapper.readSecurityList(paramMap);
        //补上security的当天及昨天价格
        for (Map map:securityInfoList){
            Price priceToday = new Price();
            priceToday.setSecurityId((String) map.get("securityId"));
            priceToday.setValueDate(df.format(today));
            priceToday = priceMapper.selectByPrimaryKey(priceToday.getSecurityId(), priceToday.getValueDate());
            map.put("today",df.format(today));
            if (Assert.isNotNULL(priceToday)){
                map.put("todayPrice",priceToday.getValue());
            }else {
                map.put("todayPrice",null);
            }

            Price priceYesterday = new Price();
            priceYesterday.setSecurityId((String) map.get("securityId"));
            priceYesterday.setValueDate(df.format(yesterday));
            priceYesterday = priceMapper.selectByPrimaryKey(priceYesterday.getSecurityId(),priceYesterday.getValueDate());
            map.put("lastDay",df.format(yesterday));
            if (Assert.isNotNULL(priceYesterday)){
                map.put("lastPrice",priceYesterday.getValue());
            }else {
                map.put("lastPrice",null);
            }
        }
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
