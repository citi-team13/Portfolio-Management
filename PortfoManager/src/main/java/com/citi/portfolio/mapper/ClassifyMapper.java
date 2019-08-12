package com.citi.portfolio.mapper;

import com.citi.portfolio.model.Classify;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassifyMapper {
    int deleteByPrimaryKey(Integer typeId);

    int insert(Classify record);

    Classify selectByPrimaryKey(Integer typeId);

    List<Classify> selectAll();

    int updateByPrimaryKey(Classify record);
}