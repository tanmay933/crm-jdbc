-- SQL Schema
CREATE TABLE Users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE Accounts (
    account_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    contact_email VARCHAR(100),
    contact_phone VARCHAR(20)
);

CREATE TABLE Leads (
    lead_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    phone VARCHAR(20),
    created_at DATE NOT NULL,
    converted BOOLEAN DEFAULT FALSE,
    account_id INT,
    FOREIGN KEY (account_id) REFERENCES Accounts(account_id)
);

CREATE TABLE Opportunities (
    opportunity_id INT PRIMARY KEY AUTO_INCREMENT,
    account_id INT NOT NULL,
    stage VARCHAR(50),
    value DECIMAL(12, 2),
    expected_close_date DATE,
    created_at DATE NOT NULL,
    closed BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (account_id) REFERENCES Accounts(account_id)
);

CREATE TABLE Interactions (
    interaction_id INT PRIMARY KEY AUTO_INCREMENT,
    account_id INT NOT NULL,
    type ENUM('Call', 'Email', 'Meeting', 'Note') NOT NULL,
    details TEXT,
    interaction_date DATETIME NOT NULL,
    FOREIGN KEY (account_id) REFERENCES Accounts(account_id)
);

CREATE TABLE Tasks (
    task_id INT PRIMARY KEY AUTO_INCREMENT,
    assigned_to INT NOT NULL,
    account_id INT,
    description TEXT,
    due_date DATE,
    completed BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (assigned_to) REFERENCES Users(user_id),
    FOREIGN KEY (account_id) REFERENCES Accounts(account_id)
);
