package com.citi.portfolio.infra.impl;

import com.citi.portfolio.infra.services.AdministratorService;
import com.citi.portfolio.infra.services.PortfolioService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdministratorServiceImplTest {

    @Autowired
    AdministratorService administratorService;

    @Test
    public void createAFundManager() {
    }

    @Test
    public void getFundManager() {
    }

    @Test
    public void getFundManagerDetail() {
        System.out.println(administratorService.getFundManagerDetail("24"));
    }

    @Test
    public void getFundManagerList() {
    }

    @Test
    public void updateFundManager() {
    }

    @Test
    public void deleteFundManager() {
    }

    @Test
    public void transferPortfolio() {
    }
}