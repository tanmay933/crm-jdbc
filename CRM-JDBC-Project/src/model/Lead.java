// Lead.java
package model;

import java.util.Date;

public class Lead {
    private int leadId;
    private String name;
    private String email;
    private String phone;
    private Date createdAt;
    private boolean converted;
    private Integer accountId;

    public Lead() {}

    public Lead(int leadId, String name, String email, String phone, Date createdAt, boolean converted, Integer accountId) {
        this.leadId = leadId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.createdAt = createdAt;
        this.converted = converted;
        this.accountId = accountId;
    }

    public int getLeadId() { return leadId; }
    public void setLeadId(int leadId) { this.leadId = leadId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public boolean isConverted() { return converted; }
    public void setConverted(boolean converted) { this.converted = converted; }

    public Integer getAccountId() { return accountId; }
    public void setAccountId(Integer accountId) { this.accountId = accountId; }
}
