package com.citi.portfolio.mapper;

import com.citi.portfolio.model.Price;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceMapper {
    int deleteByPrimaryKey(@Param("securityId") String securityId, @Param("date") String date);

    int insert(Price record);

    Price selectByPrimaryKey(@Param("securityId") String securityId, @Param("date") String date);

    List<Price> selectAll();

    int updateByPrimaryKey(Price record);
}