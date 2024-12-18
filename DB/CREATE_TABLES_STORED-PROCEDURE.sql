DELIMITER $$

CREATE DEFINER=`root`@`%` PROCEDURE `create_tables`()
BEGIN
    -- Create user roles table
    CREATE TABLE IF NOT EXISTS user_roles (
        roleID INT AUTO_INCREMENT PRIMARY KEY,
        role_name ENUM('Job Seeker', 'Employer', 'Admin') NOT NULL UNIQUE
    );

    -- Create career paths table
    CREATE TABLE IF NOT EXISTS career_paths (
        career_pathID INT AUTO_INCREMENT PRIMARY KEY,
        career_name VARCHAR(50) UNIQUE NOT NULL,
        description TEXT
    );

    -- Create users table
    CREATE TABLE IF NOT EXISTS users (
        userID INT AUTO_INCREMENT PRIMARY KEY,
        username VARCHAR(50) NOT NULL,
        email VARCHAR(100) NOT NULL UNIQUE,
        password VARCHAR(100) NOT NULL,
        profile_picture VARCHAR(512),
        location VARCHAR(100),
        profession VARCHAR(50),
        career_goal VARCHAR(100),
        resume TEXT,
        achievements_count INT DEFAULT 0,
        leaderboard_points INT DEFAULT 0,
        created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
        updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
        roleID INT,
        career_pathID INT,
        FOREIGN KEY (roleID) REFERENCES user_roles(roleID),
        FOREIGN KEY (career_pathID) REFERENCES career_paths(career_pathID)
    );

    -- Create skill categories table
    CREATE TABLE IF NOT EXISTS skill_categories (
        categoryID INT AUTO_INCREMENT PRIMARY KEY,
        category_name VARCHAR(50) UNIQUE NOT NULL,
        description TEXT
    );

    -- Create skills table
    CREATE TABLE IF NOT EXISTS skills (
        skillID INT AUTO_INCREMENT PRIMARY KEY,
        skill_name VARCHAR(50) UNIQUE NOT NULL,
        categoryID INT,
        FOREIGN KEY (categoryID) REFERENCES skill_categories(categoryID)
    );

    -- Create courses table
    CREATE TABLE IF NOT EXISTS courses (
        courseID INT AUTO_INCREMENT PRIMARY KEY,
        course_name VARCHAR(100) NOT NULL,
        description TEXT,
        required_skills TEXT,
        points INT DEFAULT 10,
        created_at DATETIME DEFAULT CURRENT_TIMESTAMP
    );

    -- Create user courses table
    CREATE TABLE IF NOT EXISTS user_courses (
        user_courseID INT AUTO_INCREMENT PRIMARY KEY,
        userID INT,
        courseID INT,
        completion_status ENUM('Not Started', 'In Progress', 'Completed') DEFAULT 'Not Started',
        proof_of_completion TEXT,
        completion_date DATETIME,
        FOREIGN KEY (userID) REFERENCES users(userID),
        FOREIGN KEY (courseID) REFERENCES courses(courseID)
    );

    -- Create internships table
    CREATE TABLE IF NOT EXISTS internships (
        internshipID INT AUTO_INCREMENT PRIMARY KEY,
        companyID INT,
        title VARCHAR(100) NOT NULL,
        description TEXT,
        required_skills TEXT,
        points_rewarded INT,
        location VARCHAR(100),
        created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
        updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
        FOREIGN KEY (companyID) REFERENCES companies(companyID)
    );

    -- Create user internship applications table
    CREATE TABLE IF NOT EXISTS user_internship_applications (
        applicationID INT AUTO_INCREMENT PRIMARY KEY,
        userID INT,
        internshipID INT,
        application_status ENUM('Pending', 'Accepted', 'Rejected'),
        applied_at DATETIME DEFAULT CURRENT_TIMESTAMP,
        FOREIGN KEY (userID) REFERENCES users(userID),
        FOREIGN KEY (internshipID) REFERENCES internships(internshipID)
    );

    -- Create companies table
    CREATE TABLE IF NOT EXISTS companies (
        companyID INT AUTO_INCREMENT PRIMARY KEY,
        company_name VARCHAR(100) NOT NULL,
        description TEXT,
        industry VARCHAR(50),
        location VARCHAR(100),
        website VARCHAR(255),
        logo VARCHAR(512),
        created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
        updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    );

    -- Create listings table
    CREATE TABLE IF NOT EXISTS listings (
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

    -- Create user applications table
    CREATE TABLE IF NOT EXISTS user_applications (
        applicationID INT AUTO_INCREMENT PRIMARY KEY,
        userID INT,
        listingID INT,
        application_status ENUM('Pending', 'Accepted', 'Rejected'),
        applied_at DATETIME DEFAULT CURRENT_TIMESTAMP,
        FOREIGN KEY (userID) REFERENCES users(userID),
        FOREIGN KEY (listingID) REFERENCES listings(listingID)
    );

    -- Other tables and indexes can be created similarly...
END$$

DELIMITER ;
