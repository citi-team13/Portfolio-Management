package com.citi.portfolio.model;

import java.io.Serializable;

public class Security implements Serializable {
    private String securityId;

    private String securityName;

    private Integer typeId;

    private static final long serialVersionUID = 1L;

    private static int ID_length  = 10;

    public static int getID_length() {
        return ID_length;
    }

    public String getSecurityId() {
        return securityId;
    }

    public void setSecurityId(String securityId) {
        this.securityId = securityId == null ? null : securityId.trim();
    }

    public String getSecurityName() {
        return securityName;
    }

    public void setSecurityName(String securityName) {
        this.securityName = securityName == null ? null : securityName.trim();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}