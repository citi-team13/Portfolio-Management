package com.citi.portfolio.infra.impl;

import com.citi.portfolio.common.Assert;
import com.citi.portfolio.common.Result;
import com.citi.portfolio.infra.services.PortfolioItemService;
import com.citi.portfolio.mapper.PortfolioItemMapper;
import com.citi.portfolio.mapper.PositionMapper;
import com.citi.portfolio.model.PortfolioItem;
import com.citi.portfolio.model.Position;
import com.citi.portfolio.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PortfolioItemServiceImpl implements PortfolioItemService {

    @Autowired
    PortfolioItemMapper portfolioItemMapper;

    @Autowired
    PositionMapper positionMapper;

    @Override
    public Result addAPortfolioItem(String portfolioId, String securityId, String positionValue) {
        // 判断security是否重复
        PortfolioItem item = portfolioItemMapper.selectByPrimaryKey(portfolioId, securityId);
        if (Assert.isNotNULL(item)){
            return Result.failure(402,"Security is exist!");
        }
        String currentDate = DateUtil.getToday();
        item.setPortfolioId(portfolioId);
        item.setSecurityId(securityId);
        item.setCreateDate(currentDate);

        Position position = new Position();
        position.setPortfolioId(portfolioId);
        position.setSecurityId(securityId);
        position.setUpdateTime(currentDate);
        position.setPositionValue(Float.parseFloat(positionValue));

        if (portfolioItemMapper.insert(item) > 0 && positionMapper.insertSelective(position) > 0){
            return Result.success(item,200,"success!");
        }else {
            return Result.failure(401,"Create fund manager failure!");
        }
    }

}
