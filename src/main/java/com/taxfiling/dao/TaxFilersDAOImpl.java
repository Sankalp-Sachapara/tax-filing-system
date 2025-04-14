package com.taxfiling.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.taxfiling.model.Tax_Filers;

/**
 * Implementation of the TaxFilersDAO interface
 */
@Repository
public class TaxFilersDAOImpl implements TaxFilersDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    // RowMapper for Tax_Filers
    private static final class TaxFilersRowMapper implements RowMapper<Tax_Filers> {
        @Override
        public Tax_Filers mapRow(ResultSet rs, int rowNum) throws SQLException {
            Tax_Filers taxFiler = new Tax_Filers();
            taxFiler.setFilerId(rs.getInt("FilerID"));
            taxFiler.setName(rs.getString("Name"));
            taxFiler.setContact(rs.getString("Contact"));
            taxFiler.setAnnualIncome(rs.getDouble("AnnualIncome"));
            taxFiler.setExpenses(rs.getDouble("Expenses"));
            taxFiler.setTaxYear(rs.getInt("TaxYear"));
            return taxFiler;
        }
    }
    
    /**
     * Initialize the database with sample data
     */
    @PostConstruct
    @Override
    public void initDatabase() {
        // Create database tables if they don't exist
        createTables();
        
        // Check if data exists
        int count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM TaxFilers", Integer.class);
        
        // Insert sample data if the table is empty
        if (count == 0) {
            insertSampleData();
        }
    }
    
    /**
     * Create database tables
     */
    private void createTables() {
        // Create the TaxFilers table if it doesn't exist
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS TaxFilers (" +
                "FilerID INT AUTO_INCREMENT PRIMARY KEY, " +
                "Name VARCHAR(100) NOT NULL, " +
                "Contact VARCHAR(50) NOT NULL, " +
                "AnnualIncome DECIMAL(12,2) NOT NULL, " +
                "Expenses DECIMAL(12,2) NOT NULL, " +
                "TaxYear INT NOT NULL)");
    }
    
    /**
     * Insert sample data into the database
     */
    private void insertSampleData() {
        // Insert sample records
        String sql = "INSERT INTO TaxFilers (Name, Contact, AnnualIncome, Expenses, TaxYear) VALUES (?, ?, ?, ?, ?)";
        
        jdbcTemplate.update(sql, "John Smith", "123-456-7890", 75000.00, 15000.00, 2024);
        jdbcTemplate.update(sql, "Jane Doe", "987-654-3210", 92000.00, 18500.00, 2024);
        jdbcTemplate.update(sql, "Robert Johnson", "555-123-4567", 68000.00, 12000.00, 2024);
        jdbcTemplate.update(sql, "Sarah Williams", "444-789-1234", 115000.00, 25000.00, 2024);
        jdbcTemplate.update(sql, "Michael Brown", "777-888-9999", 55000.00, 9500.00, 2024);
        jdbcTemplate.update(sql, "Emily Davis", "222-333-4444", 82000.00, 17000.00, 2024);
    }

    /**
     * Get all tax filers from the database
     */
    @Override
    public List<Tax_Filers> getAllTaxFilers() {
        String sql = "SELECT * FROM TaxFilers ORDER BY FilerID";
        return jdbcTemplate.query(sql, new TaxFilersRowMapper());
    }

    /**
     * Get a single tax filer by ID
     */
    @Override
    public Tax_Filers getTaxFilerById(int filerId) {
        String sql = "SELECT * FROM TaxFilers WHERE FilerID = ?";
        return jdbcTemplate.queryForObject(sql, new TaxFilersRowMapper(), filerId);
    }

    /**
     * Save a new tax filer
     */
    @Override
    public int saveTaxFiler(Tax_Filers taxFiler) {
        String sql = "INSERT INTO TaxFilers (Name, Contact, AnnualIncome, Expenses, TaxYear) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, 
                taxFiler.getName(),
                taxFiler.getContact(),
                taxFiler.getAnnualIncome(),
                taxFiler.getExpenses(),
                taxFiler.getTaxYear());
    }

    /**
     * Update an existing tax filer
     */
    @Override
    public int updateTaxFiler(Tax_Filers taxFiler) {
        String sql = "UPDATE TaxFilers SET Name = ?, Contact = ?, AnnualIncome = ?, Expenses = ?, TaxYear = ? WHERE FilerID = ?";
        return jdbcTemplate.update(sql, 
                taxFiler.getName(),
                taxFiler.getContact(),
                taxFiler.getAnnualIncome(),
                taxFiler.getExpenses(),
                taxFiler.getTaxYear(),
                taxFiler.getFilerId());
    }

    /**
     * Delete a tax filer
     */
    @Override
    public int deleteTaxFiler(int filerId) {
        String sql = "DELETE FROM TaxFilers WHERE FilerID = ?";
        return jdbcTemplate.update(sql, filerId);
    }
}
