/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.additem;

import java.util.*;
import java.sql.*;

import model.Item;
import static DAO.dao.con;
import javax.ejb.Stateless;

@Stateless
public class ItemService {

    public List<Item> loadItemsFromDatabase() {
        List<Item> items = new ArrayList<>();

        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("SELECT * FROM addproduct");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Item item = new Item();
                item.setName(rs.getString("ProductName"));
                item.setQuantity(rs.getInt("Quantity"));
                item.setDate(rs.getString("Date"));
                items.add(item);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return items;
    }
    public void addItem(Item item) throws SQLException{
    PreparedStatement pst = (PreparedStatement) con.prepareStatement("Insert into addproduct(ProductName,Quantity,Date) values(?,?,?)");
    pst.setString(1,item.getName());
    pst.setInt(2,item.getQuantity());
    pst.setString(3,item.getDate());
    pst.executeUpdate();
    }
    public void deleteI(Item item) throws SQLException{ 
        PreparedStatement pst =(PreparedStatement) con.prepareStatement("delete from addproduct where ProductName like " +item.getName());
        pst.executeUpdate();
    }
}

