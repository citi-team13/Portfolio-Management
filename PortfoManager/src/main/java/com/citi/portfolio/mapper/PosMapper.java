package com.citi.portfolio.mapper;

import com.citi.portfolio.model.Pos;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PosMapper {
    int deleteByPrimaryKey(@Param("portfolioId") String portfolioId, @Param("securityId") String securityId, @Param("updateTime") String updateTime);

    int insert(Pos record);

    Pos selectByPrimaryKey(@Param("portfolioId") String portfolioId, @Param("securityId") String securityId, @Param("updateTime") String updateTime);

    List<Pos> selectAll();

    int updateByPrimaryKey(Pos record);
}