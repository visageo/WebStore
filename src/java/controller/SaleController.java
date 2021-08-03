package controller;

import java.sql.SQLException;
import model.Customer;
import model.Info;
import model.Item;
import model.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class SaleController {
    
    TransactionService transaction = new TransactionService();
    
    @RequestMapping(value = "/sale", method = RequestMethod.GET)
    public String createSale(ModelMap model) throws ClassNotFoundException, SQLException {
        model.addAttribute("sale", new Info());
        model.addAttribute("customers", Customer.showAllCustomers());
        model.addAttribute("items", Item.showAllItems());
        return "sale";
    }
    
    @RequestMapping(value = "/sale", method = RequestMethod.POST)
    public String temp(@ModelAttribute("info") Info info, ModelMap model) throws ClassNotFoundException, SQLException {
        
        transaction.buyItem(info.getItemId(), info.getCustomerId());
        createSale(model);
                
        return "sale";    
    }
    
}
    

