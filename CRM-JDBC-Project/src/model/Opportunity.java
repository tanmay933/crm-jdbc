// Opportunity.java
package model;

import java.util.Date;

public class Opportunity {
    private int opportunityId;
    private int accountId;
    private String stage;
    private double value;
    private Date expectedCloseDate;
    private Date createdAt;
    private boolean closed;

    public Opportunity() {}

    public Opportunity(int opportunityId, int accountId, String stage, double value, Date expectedCloseDate, Date createdAt, boolean closed) {
        this.opportunityId = opportunityId;
        this.accountId = accountId;
        this.stage = stage;
        this.value = value;
        this.expectedCloseDate = expectedCloseDate;
        this.createdAt = createdAt;
        this.closed = closed;
    }

    public int getOpportunityId() { return opportunityId; }
    public void setOpportunityId(int opportunityId) { this.opportunityId = opportunityId; }

    public int getAccountId() { return accountId; }
    public void setAccountId(int accountId) { this.accountId = accountId; }

    public String getStage() { return stage; }
    public void setStage(String stage) { this.stage = stage; }

    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }

    public Date getExpectedCloseDate() { return expectedCloseDate; }
    public void setExpectedCloseDate(Date expectedCloseDate) { this.expectedCloseDate = expectedCloseDate; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public boolean isClosed() { return closed; }
    public void setClosed(boolean closed) { this.closed = closed; }
}
