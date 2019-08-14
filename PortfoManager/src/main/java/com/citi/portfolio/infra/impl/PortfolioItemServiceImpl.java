package com.citi.portfolio.infra.impl;

import com.citi.portfolio.common.Assert;
import com.citi.portfolio.common.Result;
import com.citi.portfolio.infra.services.PortfolioItemService;
import com.citi.portfolio.mapper.PortfolioItemMapper;
import com.citi.portfolio.model.PortfolioItem;
import com.citi.portfolio.model.Position;
import com.citi.portfolio.model.Price;
import com.citi.portfolio.util.GetDate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PortfolioItemServiceImpl implements PortfolioItemService {

    @Autowired
    PortfolioItemMapper portfolioItemMapper;

    @Override
    public Result addAPortfolioItem(String portfolioId, String securityId, String positionValue) {
        PortfolioItem item = new PortfolioItem();
        item.setPortfolioId(portfolioId);
        item.setSecurityId(securityId);
        item.setCreateDate(GetDate.getCurrentDate());

//        PortfolioItem temp = portfolioItemMapper.selectByPrimaryKey(item.setPortfolioId(),price.getValueDate());
//        if (Assert.isNotNULL(temp)){
//            return Result.failure(402,"price 历史已存在!");
//        }
//
//        Position position = new Position();
//        position.setPortfolioId(portfolioId);
//        position.setSecurityId(securityId);
//        position.setUpdateTime(GetDate.getCurrentDate());
//        position.setPositionValue(Float.parseFloat(positionValue));

        return Result.success(item,200,"success!");
    }

}
