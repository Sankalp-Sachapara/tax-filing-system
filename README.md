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

- Java 8
- Spring MVC 5.3.27
- JDBC Template for database operations
- MySQL Database
- JSP for views
- JSTL for JSP templating
- Bootstrap 5 for UI
- Font Awesome for icons
- jQuery for client-side functionality

## Project Setup in Eclipse IDE

### Prerequisites

- Eclipse IDE (latest version)
- Apache Tomcat 9.0
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
       <property name="url" value="jdbc:mysql://localhost:3306/FilersRecord?createDatabaseIfNotExist=true&amp;useSSL=false" />
       <property name="username" value="root" />
       <property name="password" value="root" />
   </bean>
   ```

### Step 4: Configure Tomcat Server in Eclipse

1. Click on Window > Show View > Servers
2. Right-click in the Servers view and select New > Server
3. Select Apache > Tomcat v9.0 Server and click Next
4. Browse to your Tomcat installation directory and click Finish

### Step 5: Deploy the Application

1. Right-click on the project in Project Explorer
2. Select Run As > Run on Server
3. Choose Tomcat v9.0 Server and click Finish

The application will be deployed and the browser will open to display it.

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
