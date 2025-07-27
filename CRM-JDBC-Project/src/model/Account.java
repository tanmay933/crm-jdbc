// Account.java
package model;

public class Account {
    private int accountId;
    private String name;
    private String contactEmail;
    private String contactPhone;

    public Account() {}

    public Account(int accountId, String name, String contactEmail, String contactPhone) {
        this.accountId = accountId;
        this.name = name;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
    }

    public int getAccountId() { return accountId; }
    public void setAccountId(int accountId) { this.accountId = accountId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getContactEmail() { return contactEmail; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }

    public String getContactPhone() { return contactPhone; }
    public void setContactPhone(String contactPhone) { this.contactPhone = contactPhone; }
}
