# Tax Filing System

A Spring MVC web application for managing tax filer records. This application provides a user interface to create, read, update, and delete tax filer information.

## Features

- View all tax filers in a responsive table
- Add new tax filers with validation
- Update existing tax filer information
- Delete tax filers from the system
- Calculate taxable income automatically
- Responsive design with Bootstrap

## Technologies Used

- Java 11+
- Spring MVC 6.0.15
- JDBC Template for database operations
- MySQL Database
- JSP for views
- Jakarta EE 10 (for Tomcat 10.1 compatibility)
- Bootstrap 5 for UI
- Font Awesome for icons
- jQuery for client-side functionality

## Project Setup in Eclipse IDE

### Prerequisites

- Eclipse IDE (latest version)
- Apache Tomcat 10.1
- MySQL Server
- Maven

### Step 1: Clone the Repository

```bash
git clone https://github.com/Sankalp-Sachapara/tax-filing-system.git
```

### Step 2: Import the Project in Eclipse

1. Open Eclipse IDE
2. Click on File > Import
3. Select "Existing Maven Projects" under Maven
4. Browse to the location where you cloned the repository
5. Select the project and click Finish

### Step 3: Configure MySQL Database

1. Open MySQL and create a database named `FilersRecord` (the application will create it automatically if it doesn't exist)
2. Update the database connection settings in `src/main/webapp/WEB-INF/spring-mvc.xml` if needed:
   ```xml
   <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
       <property name="driverClassName" value="com.mysql.cj.jdbc.Driver" />
       <property name="url" value="jdbc:mysql://localhost:3306/FilersRecord?createDatabaseIfNotExist=true&amp;useSSL=false&amp;allowPublicKeyRetrieval=true" />
       <property name="username" value="root" />
       <property name="password" value="root" />
   </bean>
   ```

### Step 4: Configure Tomcat Server in Eclipse

1. Click on Window > Show View > Servers
2. Right-click in the Servers view and select New > Server
3. Select Apache > Tomcat v10.1 Server and click Next
4. Browse to your Tomcat installation directory and click Finish

### Step 5: Deploy the Application

1. Right-click on the project in Project Explorer
2. Select Run As > Run on Server
3. Choose Tomcat v10.1 Server and click Finish

The application will be deployed and the browser will open to display it.

## Assignment Requirements Fulfilled

This application fulfills all the requirements specified in the assignment:

1. **Database Setup**:
   - Created a database named "FilersRecord"
   - Created a table named "TaxFilers" with fields: FilerID, Name, Contact, AnnualIncome, Expenses, TaxYear
   - Inserted 6 sample records into the table

2. **Display Tax Filer Records**:
   - All tax filer records are displayed in a table format on the main page

3. **Add New Tax Filer**:
   - A form is provided to add new tax filers
   - Validation is performed on all fields
   - Success/error messages are displayed after submission

4. **Update Tax Filer**:
   - Each record has an "Edit" button
   - Clicking the button opens a form pre-filled with the record data
   - Updated data is saved to the database

5. **Delete Tax Filer**:
   - Each record has a "Delete" button
   - Confirmation is requested before deletion
   - Record is removed from the database upon confirmation

6. **Code Organization**:
   - Separate DAO class for CRUD operations
   - Spring MVC architecture with clear separation of concerns
   - Model class for Tax_Filers

## Database Schema

The application automatically creates the following database table:

```sql
CREATE TABLE IF NOT EXISTS TaxFilers (
    FilerID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Contact VARCHAR(50) NOT NULL,
    AnnualIncome DECIMAL(12,2) NOT NULL,
    Expenses DECIMAL(12,2) NOT NULL,
    TaxYear INT NOT NULL
);
```

The application also populates the table with sample data if it's empty.

## Project Structure

- `src/main/java/com/taxfiling/model`: Contains the model class
- `src/main/java/com/taxfiling/dao`: Contains DAO interface and implementation
- `src/main/java/com/taxfiling/controller`: Contains Spring MVC controller
- `src/main/webapp/WEB-INF/views`: Contains JSP views
- `src/main/webapp/WEB-INF`: Contains configuration files

## Jakarta EE Migration Notes

This project has been migrated from Java EE (javax.*) to Jakarta EE (jakarta.*) to support running on Tomcat 10.1+. Key changes include:

- Updated servlet and JSP API dependencies to Jakarta EE 10
- Changed JSTL tags from `http://java.sun.com/jsp/jstl/core` to `jakarta.tags.core`
- Updated web.xml to use Jakarta EE 10 schema
- Updated Spring version to 6.0+ for Jakarta EE compatibility
- Added Jakarta Annotation API for @PostConstruct support
