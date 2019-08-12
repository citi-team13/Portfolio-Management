package com.citi.portfolio.mapper;

import com.citi.portfolio.model.Pos;
import com.citi.portfolio.model.PosExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PosMapper {
    int countByExample(PosExample example);

    int deleteByExample(PosExample example);

    int deleteByPrimaryKey(@Param("portfolioId") String portfolioId, @Param("securityId") String securityId, @Param("updateTime") String updateTime);

    int insert(Pos record);

    int insertSelective(Pos record);

    List<Pos> selectByExample(PosExample example);

    Pos selectByPrimaryKey(@Param("portfolioId") String portfolioId, @Param("securityId") String securityId, @Param("updateTime") String updateTime);

    int updateByExampleSelective(@Param("record") Pos record, @Param("example") PosExample example);

    int updateByExample(@Param("record") Pos record, @Param("example") PosExample example);

    int updateByPrimaryKeySelective(Pos record);

    int updateByPrimaryKey(Pos record);
}