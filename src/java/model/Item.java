package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Item {

    private int id;
    private String name;
    private Double price;
    private Integer amount;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public static String showAllItems() throws ClassNotFoundException {
        StringBuilder itemResults = new StringBuilder();

        Class.forName("com.mysql.jdbc.Driver");

        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/shop", "root", "");) {
            Statement st = conn.createStatement();
            st.executeQuery("select * from items");
            ResultSet rs = st.getResultSet();

            while (rs.next()) {
                itemResults.append("[ID:").append(rs.getString("id")).append("] ");
                itemResults.append(rs.getString("name"));
                itemResults.append(" - $");
                itemResults.append(rs.getString("price"));
                itemResults.append(" (").append(rs.getString("amount")).append(" available)");
                itemResults.append("\n");
            }

        } catch (SQLException e) {
            itemResults.append(e.getMessage());
        }
        return itemResults.toString();
    }

    public void addNewItem() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/shop", "root", "");) {
            if (name != null && !(name.isEmpty()) && price != null && amount != null) {
                Statement st = conn.createStatement();
                st.execute("insert into items (name, price, amount) values ('" + name + "', '" + price + "', '" + amount + "')");
            }

        } catch (SQLException e) {
            System.out.println("Error in database connection: \n" + e.getMessage());
        }
    }

    public void deleteItem() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/shop", "root", "");) {
            if (id != 0) {
                Statement st = conn.createStatement();
                st.execute("delete from items where id='" + id + "'");
            }

        } catch (SQLException e) {
            System.out.println("Error in database connection: \n" + e.getMessage());
        }
    }

    public void editItem() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/shop", "root", "");) {
            if (id != 0) {

                if (name != null && !(name.isEmpty())) {
                    Statement st = conn.createStatement();
                    st.execute("update items set name = '" + name + "' where id='" + id + "'");
                }
                if (price != null) {
                    Statement st = conn.createStatement();
                    st.execute("update items set price = '" + price + "' where id='" + id + "'");
                }
                if (amount != null) {
                    Statement st = conn.createStatement();
                    st.execute("update items set amount = '" + amount + "' where id='" + id + "'");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error in database connection: \n" + e.getMessage());
        }
    }

}
