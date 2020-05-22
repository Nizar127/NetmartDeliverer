package com.test.netmartdeliverer;

import java.sql.Timestamp;

public class profile_model {
    private int profileId;
    private String Name;
    private int moneyTotal;
    private int JobDone;
    private String Ranking;
    private String Account;
    private String Inbox;
    private String BankAcc;
    private Timestamp Updated;  //check timestamp. This one is for android not using firebase one

    public profile_model(int profileId, String name, int moneyTotal, int jobDone, String ranking, String account, String inbox, String bankAcc, Timestamp updated) {
        this.profileId = profileId;
        Name = name;
        this.moneyTotal = moneyTotal;
        JobDone = jobDone;
        Ranking = ranking;
        Account = account;
        Inbox = inbox;
        BankAcc = bankAcc;
        Updated = updated;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getMoneyTotal() {
        return moneyTotal;
    }

    public void setMoneyTotal(int moneyTotal) {
        this.moneyTotal = moneyTotal;
    }

    public int getJobDone() {
        return JobDone;
    }

    public void setJobDone(int jobDone) {
        JobDone = jobDone;
    }

    public String getRanking() {
        return Ranking;
    }

    public void setRanking(String ranking) {
        Ranking = ranking;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public String getInbox() {
        return Inbox;
    }

    public void setInbox(String inbox) {
        Inbox = inbox;
    }

    public String getBankAcc() {
        return BankAcc;
    }

    public void setBankAcc(String bankAcc) {
        BankAcc = bankAcc;
    }

    public Timestamp getUpdated() {
        return Updated;
    }

    public void setUpdated(Timestamp updated) {
        Updated = updated;
    }
}
