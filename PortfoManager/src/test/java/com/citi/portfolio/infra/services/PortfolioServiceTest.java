package com.citi.portfolio.infra.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PortfolioServiceTest {

    @Autowired
    PortfolioService portfolioService;

    @Test
    public void addAPortfolio() {
    }

    @Test
    public void getAPortfolio() {
    }

    @Test
    public void getPortfolioList() {
    }

    @Test
    public void getAllPrice() {
    }

    @Test
    public void getRecentPrice() {
        System.out.println(portfolioService.getAllPrice("14").toString());
    }
}