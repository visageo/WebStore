package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Customer {

    private int id;
    private String name;
    private Double balance;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public static String showAllCustomers() throws ClassNotFoundException {
        StringBuilder customerList = new StringBuilder();

        Class.forName("com.mysql.jdbc.Driver");

        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/shop", "root", "");) {
            Statement st = conn.createStatement();
            st.executeQuery("select * from customers");
            ResultSet rs = st.getResultSet();

            while (rs.next()) {
                customerList.append("[ID:").append(rs.getString("id")).append("] ");
                customerList.append(rs.getString("name"));
                customerList.append("'s balance = $");
                customerList.append(rs.getString("balance"));
                customerList.append("\n");
            }

        } catch (SQLException e) {
            customerList.append(e.getMessage());
        }
        return customerList.toString();
    }

    public void addNewCustomer() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/shop", "root", "");) {
            if (name != null && !(name.isEmpty()) && balance != null) {
                Statement st = conn.createStatement();
                st.execute("insert into customers (name, balance) values ('" + name + "', '" + balance + "')");
            }

        } catch (SQLException e) {
            System.out.println("Error in database connection: \n" + e.getMessage());
        }
    }

    public void deleteCustomer() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/shop", "root", "");) {
            if (id != 0) {
                Statement st = conn.createStatement();
                st.execute("delete from customers where id='" + id + "'");
            }

        } catch (SQLException e) {
            System.out.println("Error in database connection: \n" + e.getMessage());
        }
    }

    public void editCustomer() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/shop", "root", "");) {
            if (id != 0) {

                if (name != null && !(name.isEmpty())) {
                    Statement st = conn.createStatement();
                    st.execute("update customers set name = '" + name + "' where id='" + id + "'");
                }
                if (balance != null) {
                    Statement st = conn.createStatement();
                    st.execute("update customers set balance = '" + balance + "' where id='" + id + "'");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error in database connection: \n" + e.getMessage());
        }
    }

}
