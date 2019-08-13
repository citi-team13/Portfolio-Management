package com.citi.portfolio.model;

public class Portfolio {
    private String portfolioId;

    private String portfolioName;

    private String managerId;

    private String createDate;

    private Double portfolioChangeRate;

    public String getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(String portfolioId) {
        this.portfolioId = portfolioId == null ? null : portfolioId.trim();
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName == null ? null : portfolioName.trim();
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId == null ? null : managerId.trim();
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
    }

    public Double getPortfolioChangeRate() {
        return portfolioChangeRate;
    }

    public void setPortfolioChangeRate(Double portfolioChangeRate) {
        this.portfolioChangeRate = portfolioChangeRate;
    }
}