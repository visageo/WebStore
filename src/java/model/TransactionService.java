package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionService {

    public void buyItem(int itemId, int customerId) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/shop", "root", "");) {
            Statement getItemPrice = conn.createStatement();
            getItemPrice.executeQuery("select * from items where id='" + itemId + "'");
            ResultSet rs = getItemPrice.getResultSet();
            Item i = mapItem(rs);

            Statement getCustomerFunds = conn.createStatement();
            getCustomerFunds.executeQuery("select * from customers where id='" + customerId + "'");
            ResultSet rs2 = getCustomerFunds.getResultSet();
            Customer c = mapCustomer(rs2);

            if (c.getBalance() >= i.getPrice() && i.getAmount() > 0) {
                i.setAmount(i.getAmount() - 1);
                c.setBalance(c.getBalance() - i.getPrice());
                i.editItem();
                c.editCustomer();
            }

        }

    }

    public Item mapItem(ResultSet rs) throws SQLException {
        Item i = new Item();

        rs.next();

        i.setId(rs.getInt("id"));
        i.setPrice(rs.getDouble("price"));
        i.setAmount(rs.getInt("amount"));

        return i;
    }

    public Customer mapCustomer(ResultSet rs) throws SQLException {
        Customer c = new Customer();

        rs.next();

        c.setId(rs.getInt("id"));
        c.setBalance(rs.getDouble("balance"));

        return c;
    }

}
