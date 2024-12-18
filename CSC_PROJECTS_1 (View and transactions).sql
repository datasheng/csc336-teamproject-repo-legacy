
CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`%` 
    SQL SECURITY DEFINER
VIEW `job_listing_revenue` AS
    SELECT 
        `l`.`listingID` AS `listingID`,
        `l`.`title` AS `job_title`,
        `l`.`description` AS `job_description`,
        `l`.`location` AS `location`,
        `l`.`created_at` AS `listing_date`,
        `a`.`ad_title` AS `ad_title`,
        `a`.`price` AS `ad_revenue`,
        `a`.`start_date` AS `ad_start_date`,
        `a`.`end_date` AS `ad_end_date`
    FROM
        (`listings` `l`
        LEFT JOIN `ads_revenue` `a` ON ((`l`.`companyID` = `a`.`companyID`)))
    WHERE
        (`l`.`listing_type` = 'Job')



-- Transaction Example: Add Job Listing, Transaction Fee, and Ad Revenue
START TRANSACTION;

-- Add a new job listing to the listings table
INSERT INTO listings (companyID, title, description, required_skills, category, location, listing_type)
VALUES (1, 'Senior Software Engineer', 'Looking for an experienced Senior Software Engineer with expertise in full-stack development...', 'Java, JavaScript, React, Node.js', 'Tech', 'Remote', 'Job');

-- Charge a transaction fee for the job listing (Example: $50 fee)
INSERT INTO transaction_fees (userID, fee_type, fee_amount)
VALUES (1, 'Job Listing Fee', 50.00);

-- Add ad revenue for the company (Example: $50 revenue for posting the job)
INSERT INTO ads_revenue (companyID, ad_title, ad_description, price)
VALUES (1, 'Senior Software Engineer Job Posting', 'A job listing for a senior software engineer position in a tech company', 50.00);

-- Commit the transaction to save the changes permanently
COMMIT;

-- View: Create a view for job listings and their associated ad revenue
CREATE VIEW job_listing_revenue AS
SELECT 
    l.listingID,
    l.title AS job_title,
    l.description AS job_description,
    l.location,
    l.created_at AS listing_date,
    a.ad_title AS ad_title,
    a.price AS ad_revenue,
    a.start_date AS ad_start_date,
    a.end_date AS ad_end_date
FROM 
    listings l
LEFT JOIN 
    ads_revenue a ON l.companyID = a.companyID
WHERE 
    l.listing_type = 'Job';

-- Querying the view
SELECT * FROM job_listing_revenue;
