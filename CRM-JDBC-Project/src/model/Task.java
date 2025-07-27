// Task.java
package model;

import java.util.Date;

public class Task {
    private int taskId;
    private int assignedTo;
    private Integer accountId;
    private String description;
    private Date dueDate;
    private boolean completed;

    public Task() {}

    public Task(int taskId, int assignedTo, Integer accountId, String description, Date dueDate, boolean completed) {
        this.taskId = taskId;
        this.assignedTo = assignedTo;
        this.accountId = accountId;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    public int getTaskId() { return taskId; }
    public void setTaskId(int taskId) { this.taskId = taskId; }

    public int getAssignedTo() { return assignedTo; }
    public void setAssignedTo(int assignedTo) { this.assignedTo = assignedTo; }

    public Integer getAccountId() { return accountId; }
    public void setAccountId(Integer accountId) { this.accountId = accountId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Date getDueDate() { return dueDate; }
    public void setDueDate(Date dueDate) { this.dueDate = dueDate; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}
