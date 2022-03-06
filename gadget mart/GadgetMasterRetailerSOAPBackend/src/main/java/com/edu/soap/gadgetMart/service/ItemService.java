

package com.edu.soap.gadgetMart.service;



import com.edu.soap.gadgetMart.entity.Item;

import java.util.List;

public interface ItemService {

    public Item addItem(Item item);

    public Item updateItem(long id, Item item);

    public Item deleteItem(long id);

    public Item searchItem(long id);

    public List<Item> getAllItems();

}
