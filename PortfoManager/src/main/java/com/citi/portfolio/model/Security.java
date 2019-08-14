package com.citi.portfolio.model;

import java.io.Serializable;

public class Security implements Serializable {
    private String securityId;

    private String securityName;

    private Integer securityTypeId;

    private static final long serialVersionUID = 1L;

    private static int ID_length  = 20;

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

    public Integer getSecurityTypeId() {
        return securityTypeId;
    }

    public void setSecurityTypeId(Integer securityTypeId) {
        this.securityTypeId = securityTypeId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static int getID_length() {
        return ID_length;
    }
}