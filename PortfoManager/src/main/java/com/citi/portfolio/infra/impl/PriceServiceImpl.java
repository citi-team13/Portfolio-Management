package com.citi.portfolio.infra.impl;

import com.citi.portfolio.common.Result;
import com.citi.portfolio.infra.services.PriceService;
import com.citi.portfolio.mapper.PriceMapper;
import com.citi.portfolio.model.Price;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
public class PriceServiceImpl implements PriceService {

    @Autowired
    PriceMapper priceMapper;

    @Override
    public Result createPrice(Price price){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        price.setValueDate(df.format(new Date()));
        if (priceMapper.insert(price) > 0){
            return Result.success(price,200,"Price insert success!");
        }else {
            return Result.failure(401,"create price failure!");
        }
    }

    @Override
    public Result updatePrice(Price price){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String priceDate = df.format(new Date());
        if (price.getPriceChangeRate().equals(priceDate)) {
            if (priceMapper.updateByPrimaryKeySelective(price)>0){
                return Result.success(price,200,"success!");
            }else {
                return Result.failure(402,"update fund manager failure!");
            }
        }else {
            return Result.failure(401,"Can not change the price of the past");
        }
    }

}
