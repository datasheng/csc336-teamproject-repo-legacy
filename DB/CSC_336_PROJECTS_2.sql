-- Table for user internship applications
CREATE TABLE user_internship_applications (
    applicationID INT AUTO_INCREMENT PRIMARY KEY,
    userID INT,
    internshipID INT,
    application_status ENUM('Pending', 'Accepted', 'Rejected'),
    feedback TEXT,
    status_change_timestamp DATETIME,
    applied_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (userID) REFERENCES users(userID),
    FOREIGN KEY (internshipID) REFERENCES internships(internshipID)
);

-- Table for job/project listings
CREATE TABLE listings (
    listingID INT AUTO_INCREMENT PRIMARY KEY,
    companyID INT,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    required_skills TEXT,
    category VARCHAR(50),
    location VARCHAR(100),
    listing_type ENUM('Job', 'Project', 'Internship', 'Contract'),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (companyID) REFERENCES companies(companyID)
);

-- Table for user applications to listings
CREATE TABLE user_applications (
    applicationID INT AUTO_INCREMENT PRIMARY KEY,
    userID INT,
    listingID INT,
    application_status ENUM('Pending', 'Accepted', 'Rejected'),
    feedback TEXT,
    status_change_timestamp DATETIME,
    applied_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (userID) REFERENCES users(userID),
    FOREIGN KEY (listingID) REFERENCES listings(listingID)
);

-- Table for employer tasks
CREATE TABLE employer_tasks (
    taskID INT AUTO_INCREMENT PRIMARY KEY,
    listingID INT,
    task_description TEXT,
    task_type ENUM('Course', 'Project', 'Problem-Solving') NOT NULL,
    points INT DEFAULT 0,
    deadline DATETIME,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (listingID) REFERENCES listings(listingID)
);

-- Table for user task progress
CREATE TABLE user_task_progress (
    user_taskID INT AUTO_INCREMENT PRIMARY KEY,
    userID INT,
    taskID INT,
    progress ENUM('Not Started', 'In Progress', 'Completed') DEFAULT 'Not Started',
    score INT DEFAULT 0,
    feedback TEXT,
    completed_at DATETIME,
    FOREIGN KEY (userID) REFERENCES users(userID),
    FOREIGN KEY (taskID) REFERENCES employer_tasks(taskID)
);

-- Table for connections
CREATE TABLE connections (
    connectionID INT AUTO_INCREMENT PRIMARY KEY,
    userID INT,
    followerID INT,
    FOREIGN KEY (userID) REFERENCES users(userID),
    FOREIGN KEY (followerID) REFERENCES users(userID)
);

-- Table for activity logs
CREATE TABLE activity_logs (
    logID INT AUTO_INCREMENT PRIMARY KEY,
    userID INT,
    action VARCHAR(100),
    details TEXT,
    timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (userID) REFERENCES users(userID)
);

-- Table for subscriptions
CREATE TABLE subscriptions (
    subscriptionID INT AUTO_INCREMENT PRIMARY KEY,
    userID INT,
    subscription_type ENUM('Basic', 'Premium', 'Enterprise') NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    start_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    end_date DATETIME,
    status ENUM('Active', 'Expired', 'Cancelled') DEFAULT 'Active',
    FOREIGN KEY (userID) REFERENCES users(userID)
);

-- Table for ads revenue
CREATE TABLE ads_revenue (
    adID INT AUTO_INCREMENT PRIMARY KEY,
    companyID INT,
    ad_title VARCHAR(255),
    ad_description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    start_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    end_date DATETIME,
    FOREIGN KEY (companyID) REFERENCES companies(companyID)
);

-- Table for transaction fees
CREATE TABLE transaction_fees (
    transactionID INT AUTO_INCREMENT PRIMARY KEY,
    userID INT,
    fee_type ENUM('Application Fee', 'Task Completion Fee', 'Job Listing Fee') NOT NULL,
    fee_amount DECIMAL(10, 2) NOT NULL,
    date_charged DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (userID) REFERENCES users(userID)
);

-- Indexes
CREATE INDEX idx_categoryID ON skills(categoryID);
CREATE INDEX idx_userID ON user_courses(userID);
CREATE INDEX idx_taskID ON user_task_progress(taskID);
CREATE INDEX idx_userID_task ON user_task_progress(userID);
CREATE INDEX idx_listingID ON listings(listingID);
CREATE INDEX idx_email ON users(email);
CREATE INDEX idx_userID_applications ON user_applications(userID);
CREATE INDEX idx_userID_internship_apps ON user_internship_applications(userID);
CREATE INDEX idx_userID_career_goals ON user_career_goals(userID);
CREATE INDEX idx_userID_skills ON user_skills(userID);
CREATE INDEX idx_skillID_skills ON user_skills(skillID);

-- Full-text indexes
CREATE FULLTEXT INDEX idx_fulltext_course_description ON courses(description);
CREATE FULLTEXT INDEX idx_fulltext_listing_description ON listings(description);
CREATE FULLTEXT INDEX idx_fulltext_user_resume ON users(resume);
