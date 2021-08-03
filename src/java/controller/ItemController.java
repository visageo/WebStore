package controller;

import java.sql.SQLException;
import model.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ItemController {
    
    @RequestMapping(value = "/item", method = RequestMethod.GET)
    public String createItem(ModelMap model) throws ClassNotFoundException, SQLException {
        model.addAttribute("item", new Item());
        model.addAttribute("items", Item.showAllItems());
        
        return "item";
    }
    
    @RequestMapping(value = "/item", method = RequestMethod.POST, params="add")
    public String addItem(@ModelAttribute("item") Item item, ModelMap model) throws ClassNotFoundException, SQLException {
        item.addNewItem();
        createItem(model);
        
        return "item";
    }
    
    @RequestMapping(value = "/item", method = RequestMethod.POST, params="delete")
    public String deleteItem(@ModelAttribute("item") Item item, ModelMap model) throws ClassNotFoundException, SQLException {
        item.deleteItem();
        createItem(model);
                
        return "item";
    
    }
    @RequestMapping(value = "/item", method = RequestMethod.POST, params="edit")
    public String editItem(@ModelAttribute("item") Item item, ModelMap model) throws ClassNotFoundException, SQLException {
        item.editItem();
        createItem(model);
        
        return "item";
        
    }
    
}
