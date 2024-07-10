This project is a desktop application built with Java Swing in Apache NetBeans, designed to manage gym operations efficiently. It utilizes an on-premises SQL Server database for data management, connected via the JDBC driver.
The app is giving the CRUD operation and other functionalities for the database.

## Thechnologies Used:
- **Java**
- **Java Swing**
- **SQL Server**
- **SSMS**
- **Triggers and stored procedures**

## Database:

I created a relational on-premises SQL Server database using SSMS , this is the diagram of the database, generated by SSMS.
<img src="https://github.com/VladRo26/GymManagementSwing/assets/100710098/5d43e2e5-745f-42af-badd-7be0980dd8da">

## Functionalities:

Firstly, I created a loading screen to improve the user experience:
<img src="https://github.com/VladRo26/GymManagementSwing/assets/100710098/0c804a08-1fd1-4c98-b0a6-ed611454ad35">
</br>
After that, you have the Log In, here you connect with your username and password.
Also will show the messages for succes or for the failure, if the username or the password does not exsist.
<img src="https://github.com/VladRo26/GymManagementSwing/assets/100710098/d76259b5-0a81-469e-8342-482c5c4daaaf">

Next, I created a page, for every table with CRUD options and other specific functionalities.
I also used triggers and stored procedures for some of the tables.

### Members
<img src="https://github.com/VladRo26/GymManagementSwing/assets/100710098/0b0ce643-8081-4b81-a9cf-b44f1af3f003">

I used a common layout for all the tables, when i click on a row for a table, the text fields will be completed with the selected row data.
This is for the edit and for the delete functionalities.
<img src="https://github.com/VladRo26/GymManagementSwing/assets/100710098/4545e0cb-411f-4555-8c81-a71e0eb49b0d">

Moreover, for adding and editting are validation for the given inputs, for example for the dates, age, email, etc.
<img src="https://github.com/VladRo26/GymManagementSwing/assets/100710098/a2726243-76f1-4e60-afdc-55238fc85884">

If I select a row and then click on the view membership button, a new tab will be opened and will show the memberships for that member.
<img src="https://github.com/VladRo26/GymManagementSwing/assets/100710098/00cd977d-52ee-4846-b255-dce4408ef005">

I have also validation for this, the same member can not have two memberships on the same time.
<img src="https://github.com/VladRo26/GymManagementSwing/assets/100710098/3bc2ea60-b41f-4de9-8d3c-0f7b2b6f23b0">
This table has two triggers, one for the end date to auto complete the end-date in the table, based on the length of the memberships(1 months, 3 months, 6 months).
I also have used a trigger to insert into payments table, after a member is registered with a new membership.

Code for end date trigger:
ALTER TRIGGER [dbo].[trg_AutoUpdateEndDate]
ON [dbo].[Memberships]
AFTER INSERT
AS
BEGIN
    SET NOCOUNT ON;

    -- Update the EndDate in the Memberships table based on the MembershipType's duration
    UPDATE m
    SET m.EndDate = DATEADD(MONTH, mt.DurationMonths, m.StartDate)
    FROM Memberships m
    INNER JOIN inserted i ON m.MembershipID = i.MembershipID
    INNER JOIN MembershipTypes mt ON m.MembershipTypeID = mt.MembershipTypeID;
    END;

Code for insert into the payments:
ALTER TRIGGER [dbo].[trg_InsertPaymentAfterMembership]
ON [dbo].[Memberships]
AFTER INSERT
AS
BEGIN
    SET NOCOUNT ON;

    -- Insert a payment record for the new membership
    INSERT INTO dbo.Payments (MemberID, Amount, PaymentDate, PaymentType, Description)
    SELECT 
        i.MemberID,
        mt.PricePerMonth * mt.DurationMonths, -- Updated to use the new column name PricePerMonth
        GETDATE(), -- Payment date as the current date
        'Membership Fee',
        'Initial full membership payment'
    FROM 
        inserted i
        INNER JOIN dbo.MembershipTypes mt ON i.MembershipTypeID = mt.MembershipTypeID;
        END;

### Memberships Types:

<img src="https://github.com/VladRo26/GymManagementSwing/assets/100710098/f3978416-1954-450c-91c0-f712eda7e6df">

### Class Types:

<img src="https://github.com/VladRo26/GymManagementSwing/assets/100710098/f04dac2a-61a3-4d20-8b80-e84975f6397f">

### Class :

<img src="https://github.com/VladRo26/GymManagementSwing/assets/100710098/1e6abfb7-45e0-4b81-bdc7-ff8e4434b26b">

### Equipament:

<img src="https://github.com/VladRo26/GymManagementSwing/assets/100710098/c4088b45-6eee-4989-b434-32e7984d0955">

### Trainers:

<img src="https://github.com/VladRo26/GymManagementSwing/assets/100710098/69ff321c-ee41-458e-a539-57eb21c04093">

If you select a trainer and then press on the see members, you will see all the members that have contracts with this trainer.
The red ones are members with no active subscriptions and the green ones have avalabile training program with the trainer.
<img src="https://github.com/VladRo26/GymManagementSwing/assets/100710098/ac2546f7-5a99-45e9-a4a9-72c885d78c7c">


    ALTER TRIGGER [dbo].[trg_InsertPaymentForTraining]
    ON [dbo].[MemberTrainers]
    AFTER INSERT
    AS
    BEGIN
        SET NOCOUNT ON;

    -- Insert a payment record for each new member trainer association
    INSERT INTO dbo.Payments (MemberID, Amount, PaymentDate, PaymentType, Description)
    SELECT 
        i.MemberID,
        DATEDIFF(MONTH, i.StartPeriod, i.EndPeriod) * t.PricePerMonth, -- Calculate total price
        GETDATE(), -- Use current date as payment date
        'Training Fee',
        'Payment for training from ' + CONVERT(VARCHAR, i.StartPeriod, 101) + ' to ' + CONVERT(VARCHAR, i.EndPeriod, 101)
    FROM 
        inserted i
        JOIN dbo.Trainers t ON i.TrainerID = t.TrainerID;
    END;











