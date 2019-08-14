package com.citi.portfolio.model;

import java.math.BigDecimal;

public class PortfolioPriceDetail {
    private String portfolioId;
    private String portfolioName;
    private String date;
    private BigDecimal price;

    public String getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(String portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PortfolioPriceDetail{" +
                "portfolioId='" + portfolioId + '\'' +
                ", portfolioName='" + portfolioName + '\'' +
                ", date='" + date + '\'' +
                ", price=" + price +
                '}';
    }
}
