package com.taxfiling.dao;

import java.util.List;

import com.taxfiling.model.Tax_Filers;

/**
 * DAO Interface for Tax Filers
 */
public interface TaxFilersDAO {
    
    // Get all tax filers
    List<Tax_Filers> getAllTaxFilers();
    
    // Get a single tax filer by ID
    Tax_Filers getTaxFilerById(int filerId);
    
    // Save a new tax filer
    int saveTaxFiler(Tax_Filers taxFiler);
    
    // Update an existing tax filer
    int updateTaxFiler(Tax_Filers taxFiler);
    
    // Delete a tax filer
    int deleteTaxFiler(int filerId);
    
    // Initialize the database with sample data
    void initDatabase();
}
