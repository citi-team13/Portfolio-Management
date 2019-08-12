package com.citi.portfolio.mapper;

import com.citi.portfolio.model.Transfer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferMapper {
    int deleteByPrimaryKey(String transferId);

    int insert(Transfer record);

    Transfer selectByPrimaryKey(String transferId);

    List<Transfer> selectAll();

    int updateByPrimaryKey(Transfer record);
}