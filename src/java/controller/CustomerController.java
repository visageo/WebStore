package controller;

import java.sql.SQLException;
import model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class CustomerController {
    
    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String createCustomer(ModelMap model) throws ClassNotFoundException, SQLException {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customers", Customer.showAllCustomers());
        return "customer";
    }
    
    @RequestMapping(value = "/customer", method = RequestMethod.POST, params="add")
    public String addCustomer(@ModelAttribute("customer") Customer customer, ModelMap model) throws ClassNotFoundException, SQLException {
        customer.addNewCustomer();
        createCustomer(model);
        
        return "customer";
    }
    
    @RequestMapping(value = "/customer", method = RequestMethod.POST, params="delete")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer, ModelMap model) throws ClassNotFoundException, SQLException {
        customer.deleteCustomer();
        createCustomer(model);
        
        return "customer";
    }
    
    @RequestMapping(value = "/customer", method = RequestMethod.POST, params="edit")
    public String editCustomer(@ModelAttribute("customer") Customer customer, ModelMap model) throws ClassNotFoundException, SQLException {
        customer.editCustomer();
        createCustomer(model);
        
        return "customer";
    }
    
}
