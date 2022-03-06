

package com.edu.gadgetMart.service;



import com.edu.gadgetMart.entity.Item;

import java.util.List;

public interface ItemService {

    public Item addItem(Item item);

    public Item updateItem(long id, Item item);

    public Item deleteItem(long id);

    public Item searchItem(long id);

    public List<Item> getAllItems();

}
