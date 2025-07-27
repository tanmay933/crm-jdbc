// Interaction.java
package model;

import java.util.Date;

public class Interaction {
    private int interactionId;
    private int accountId;
    private String type;
    private String details;
    private Date interactionDate;

    public Interaction() {}

    public Interaction(int interactionId, int accountId, String type, String details, Date interactionDate) {
        this.interactionId = interactionId;
        this.accountId = accountId;
        this.type = type;
        this.details = details;
        this.interactionDate = interactionDate;
    }

    public int getInteractionId() { return interactionId; }
    public void setInteractionId(int interactionId) { this.interactionId = interactionId; }

    public int getAccountId() { return accountId; }
    public void setAccountId(int accountId) { this.accountId = accountId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }

    public Date getInteractionDate() { return interactionDate; }
    public void setInteractionDate(Date interactionDate) { this.interactionDate = interactionDate; }
}
