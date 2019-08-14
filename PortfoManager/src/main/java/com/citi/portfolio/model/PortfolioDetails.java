package com.citi.portfolio.model;

import java.math.BigDecimal;

public class PortfolioDetails {
    private String createDate;
    private String securityId;
    private String securityName;
    private float position;
    private BigDecimal price;

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getSecurityId() {
        return securityId;
    }

    public void setSecurityId(String securityId) {
        this.securityId = securityId;
    }

    public String getSecurityName() {
        return securityName;
    }

    public void setSecurityName(String securityName) {
        this.securityName = securityName;
    }

    public float getPosition() {
        return position;
    }

    public void setPosition(float position) {
        this.position = position;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PortfolioDetails{" +
                "createDate='" + createDate + '\'' +
                ", securityId='" + securityId + '\'' +
                ", securityName='" + securityName + '\'' +
                ", position=" + position +
                ", price=" + price +
                '}';
    }
}