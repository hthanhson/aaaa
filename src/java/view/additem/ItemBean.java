/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.additem;


import jakarta.annotation.PostConstruct;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.RequestScoped;

import javax.inject.Inject;
import javax.inject.Named;
import model.Item;

/**
 *
 * @author This PC
 */
@Named("itemBean")
@RequestScoped
public class ItemBean {
    private ItemService itemService;
    private List<Item> items;
    private Item newI;
    @Inject
    public ItemBean(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostConstruct
    public void init() {
        newI =new Item();
        items = itemService.loadItemsFromDatabase();
    }

    public List<Item> getItems() {
        return items;
    }
    public void addProduct() throws SQLException{
    itemService.addItem(newI);
    }
    public void delete(Item item) throws SQLException{
        itemService.deleteI(item);
    }
}

