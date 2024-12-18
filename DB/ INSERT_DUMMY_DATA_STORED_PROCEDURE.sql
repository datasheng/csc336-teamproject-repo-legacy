DELIMITER $$

CREATE DEFINER=`root`@`%` PROCEDURE `insert_dummy_data`()
BEGIN
    -- Insert sample user roles first
    INSERT INTO user_roles (role_name, role_description)
    VALUES 
    ('Job Seeker', 'Looking for job opportunities in the tech industry.'),
    ('Employer', 'Looking to hire candidates for various roles.'),
    ('Admin', 'Admin with full privileges to manage the platform.');

    -- Insert sample career paths
    INSERT INTO career_paths (career_name, description) 
    VALUES 
    ('Software Engineer', 'A software engineer is responsible for the design and development of software applications.'),
    ('Data Scientist', 'Data scientists analyze and interpret complex data to help organizations make data-driven decisions.');

    -- Insert sample users after user roles are created
    INSERT INTO users (username, email, password, roleID, career_pathID) 
    VALUES 
    ('john_doe', 'john.doe@example.com', 'password123', 1, 1),
    ('jane_smith', 'jane.smith@example.com', 'password456', 2, 2);

    -- Insert sample skill categories
    INSERT INTO skill_categories (category_name) 
    VALUES 
    ('Programming'),
    ('Data Science');

    -- Insert sample skills
    INSERT INTO skills (skill_name, categoryID) 
    VALUES 
    ('Python', 1),
    ('SQL', 2);

    -- Insert sample courses
    INSERT INTO courses (course_name, description) 
    VALUES 
    ('Intro to Python', 'Learn the basics of Python programming.'),
    ('Data Science 101', 'An introduction to the field of data science.');

    -- Insert sample companies
    INSERT INTO companies (company_name, description, industry, location) 
    VALUES 
    ('Tech Corp', 'A technology company specializing in software development.', 'Technology', 'New York'),
    ('Data Solutions', 'A data analytics company.', 'Data Science', 'San Francisco');

    -- Insert sample internships
    INSERT INTO internships (companyID, title, description, points_rewarded, location) 
    VALUES 
    (1, 'Software Developer Intern', 'Work on developing software applications.', 10, 'New York'),
    (2, 'Data Science Intern', 'Assist in data analysis and research.', 12, 'San Francisco');

    -- Insert sample job listings
    INSERT INTO listings (companyID, title, description, listing_type, location) 
    VALUES 
    (1, 'Junior Developer', 'Work as a junior software developer.', 'Job', 'Remote'),
    (2, 'Data Analyst', 'Analyze and interpret company data.', 'Job', 'Remote');

    -- Insert sample user skills
    INSERT INTO user_skills (userID, skillID, proficiency_level) 
    VALUES 
    (1, 1, 'Beginner'),
    (2, 2, 'Intermediate');

    -- Insert sample user career goals
    INSERT INTO user_career_goals (userID, career_pathID, goal_description)
    VALUES 
    (1, 1, 'Become a senior software engineer.'),
    (2, 2, 'Become a lead data scientist.');

    -- Insert sample user courses
    INSERT INTO user_courses (userID, courseID, completion_status, verification_status)
    VALUES 
    (1, 1, 'Completed', 'Verified'),
    (2, 2, 'In Progress', 'Pending');

    -- Insert sample course completions
    INSERT INTO course_completions (user_courseID, completion_status)
    VALUES 
    (1, 'Completed'),
    (2, 'Not Started');

    -- Insert sample achievements
    INSERT INTO achievements (userID, achievement_type, description, points)
    VALUES 
    (1, 'Course Completion', 'Completed Intro to Python', 10),
    (2, 'Course Completion', 'Completed Data Science 101', 15);

    -- Insert sample user internship applications
    INSERT INTO user_internship_applications (userID, internshipID, application_status, feedback)
    VALUES 
    (1, 1, 'Accepted', 'Great candidate!'),
    (2, 2, 'Pending', 'Awaiting review');

    -- Insert sample employer tasks
    INSERT INTO employer_tasks (listingID, task_description, task_type, points, deadline)
    VALUES 
    (1, 'Develop a basic software application.', 'Project', 15, '2024-12-31'),
    (2, 'Analyze company sales data.', 'Course', 10, '2024-12-31');

    -- Insert sample user task progress
    INSERT INTO user_task_progress (userID, taskID, progress, score, feedback)
    VALUES 
    (1, 1, 'In Progress', 80, 'Doing well'),
    (2, 2, 'Not Started', 0, 'Not started yet');

    -- Insert sample connections
    INSERT INTO connections (userID, followerID)
    VALUES 
    (1, 2),
    (2, 1);

    -- Insert sample activity logs
    INSERT INTO activity_logs (userID, action, details)
    VALUES 
    (1, 'Course Completion', 'Completed Intro to Python'),
    (2, 'Course Progress', 'Started Data Science 101');

    -- Insert sample subscriptions
    INSERT INTO subscriptions (userID, subscription_type, price)
    VALUES 
    (1, 'Premium', 19.99),
    (2, 'Basic', 9.99);

    -- Insert sample ads revenue
    INSERT INTO ads_revenue (companyID, ad_title, ad_description, price)
    VALUES 
    (1, 'Tech Corp Ad', 'Advertisement for Tech Corp', 500.00),
    (2, 'Data Solutions Ad', 'Advertisement for Data Solutions', 300.00);

    -- Insert sample transaction fees
    INSERT INTO transaction_fees (userID, fee_type, fee_amount)
    VALUES 
    (1, 'Application Fee', 10.00),
    (2, 'Task Completion Fee', 5.00);

END$$

DELIMITER ;
