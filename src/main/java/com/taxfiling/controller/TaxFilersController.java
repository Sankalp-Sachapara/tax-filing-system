package com.taxfiling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.taxfiling.dao.TaxFilersDAO;
import com.taxfiling.model.Tax_Filers;

/**
 * Controller for handling Tax Filers web requests
 */
@Controller
public class TaxFilersController {

    @Autowired
    private TaxFilersDAO taxFilersDAO;
    
    /**
     * Show the list of all tax filers
     */
    @GetMapping("/")
    public String listTaxFilers(Model model) {
        // Get all tax filers from the database
        List<Tax_Filers> taxFilers = taxFilersDAO.getAllTaxFilers();
        
        // Add tax filers to the model
        model.addAttribute("taxFilers", taxFilers);
        
        // Add empty tax filer for the add form
        model.addAttribute("taxFiler", new Tax_Filers());
        
        // Return the view name
        return "list-tax-filers";
    }
    
    /**
     * Handle add tax filer form submission
     */
    @PostMapping("/addTaxFiler")
    public String addTaxFiler(@ModelAttribute("taxFiler") Tax_Filers taxFiler, RedirectAttributes redirectAttributes) {
        // Save the tax filer to the database
        int result = taxFilersDAO.saveTaxFiler(taxFiler);
        
        // Set success or error message
        if (result > 0) {
            redirectAttributes.addFlashAttribute("message", "Tax Filer added successfully!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        } else {
            redirectAttributes.addFlashAttribute("message", "Failed to add Tax Filer. Please try again.");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        }
        
        // Redirect to the list page
        return "redirect:/";
    }
    
    /**
     * Show form for editing a tax filer
     */
    @GetMapping("/showUpdateForm")
    public String showUpdateForm(@RequestParam("filerId") int filerId, Model model) {
        // Get the tax filer from the database
        Tax_Filers taxFiler = taxFilersDAO.getTaxFilerById(filerId);
        
        // Add tax filer to the model
        model.addAttribute("taxFiler", taxFiler);
        
        // Return the update form view
        return "update-tax-filer";
    }
    
    /**
     * Handle update tax filer form submission
     */
    @PostMapping("/updateTaxFiler")
    public String updateTaxFiler(@ModelAttribute("taxFiler") Tax_Filers taxFiler, RedirectAttributes redirectAttributes) {
        // Update the tax filer in the database
        int result = taxFilersDAO.updateTaxFiler(taxFiler);
        
        // Set success or error message
        if (result > 0) {
            redirectAttributes.addFlashAttribute("message", "Tax Filer updated successfully!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        } else {
            redirectAttributes.addFlashAttribute("message", "Failed to update Tax Filer. Please try again.");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        }
        
        // Redirect to the list page
        return "redirect:/";
    }
    
    /**
     * Delete a tax filer
     */
    @GetMapping("/deleteTaxFiler")
    public String deleteTaxFiler(@RequestParam("filerId") int filerId, RedirectAttributes redirectAttributes) {
        // Delete the tax filer from the database
        int result = taxFilersDAO.deleteTaxFiler(filerId);
        
        // Set success or error message
        if (result > 0) {
            redirectAttributes.addFlashAttribute("message", "Tax Filer deleted successfully!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        } else {
            redirectAttributes.addFlashAttribute("message", "Failed to delete Tax Filer. Please try again.");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        }
        
        // Redirect to the list page
        return "redirect:/";
    }
}
