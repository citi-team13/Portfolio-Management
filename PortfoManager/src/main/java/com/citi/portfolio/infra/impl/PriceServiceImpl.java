package com.citi.portfolio.infra.impl;

import com.citi.portfolio.common.Assert;
import com.citi.portfolio.common.Result;
import com.citi.portfolio.infra.services.PriceService;
import com.citi.portfolio.mapper.PriceMapper;
import com.citi.portfolio.mapper.SecurityMapper;
import com.citi.portfolio.model.Price;
import com.citi.portfolio.model.Security;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class PriceServiceImpl implements PriceService {

    @Autowired
    PriceMapper priceMapper;

    @Override
    public Result createPrice(Price price){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        price.setValueDate(df.format(today));
        Price temp = priceMapper.selectByPrimaryKey(price.getSecurityId(),price.getValueDate());
        if (Assert.isNotNULL(temp)){
            return Result.failure(402,"price 历史已存在!");
        }

        if (priceMapper.insert(price) > 0){
            return Result.success(price,200,"Price insert success!");
        }else {
            return Result.failure(401,"create price failure!");
        }
    }

    @Override
    public Result updatePrice(Price price){
        if (priceMapper.updateByPrimaryKey(price)>0){
            return Result.success(price,200,"success!");
        }else {
            return Result.failure(402,"update fund manager failure!");
        }
    }

    @Override
    public Result readHistoryPrice(String securityId){
        List<Price> priceList = priceMapper.selectBySecurityId(securityId);
        if(Assert.isNULL(priceList)){
            return Result.success(priceList,200,"success!");
        }
        else{
            return Result.failure(402,"update fund manager failure!");
        }

    }


}
