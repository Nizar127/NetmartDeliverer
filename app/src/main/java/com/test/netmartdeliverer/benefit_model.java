package com.test.netmartdeliverer;

import java.sql.Timestamp;

public class benefit_model {

    private int benefitId;
    private String benefitName;
    private int Point;
    private int Rebate;
    private int Remain;
    private Timestamp updated;

    public benefit_model(int benefitId, String benefitName, int point, int rebate, int remain, Timestamp updated) {
        this.benefitId = benefitId;
        this.benefitName = benefitName;
        Point = point;
        Rebate = rebate;
        Remain = remain;
        this.updated = updated;
    }

    public int getBenefitId() {
        return benefitId;
    }

    public void setBenefitId(int benefitId) {
        this.benefitId = benefitId;
    }

    public String getBenefitName() {
        return benefitName;
    }

    public void setBenefitName(String benefitName) {
        this.benefitName = benefitName;
    }

    public int getPoint() {
        return Point;
    }

    public void setPoint(int point) {
        Point = point;
    }

    public int getRebate() {
        return Rebate;
    }

    public void setRebate(int rebate) {
        Rebate = rebate;
    }

    public int getRemain() {
        return Remain;
    }

    public void setRemain(int remain) {
        Remain = remain;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }
}
