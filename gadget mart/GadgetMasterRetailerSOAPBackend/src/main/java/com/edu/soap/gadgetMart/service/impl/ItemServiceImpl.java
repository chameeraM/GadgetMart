

package com.edu.soap.gadgetMart.service.impl;


import com.edu.soap.gadgetMart.entity.Item;
import com.edu.soap.gadgetMart.exception.RecordNotFoundException;
import com.edu.soap.gadgetMart.repository.ItemRepository;
import com.edu.soap.gadgetMart.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;
    private static final String MSG = "Item not Found";

    @Override
    public Item addItem(Item item) {
        item.setStatus("1");
        return itemRepository.save(item);
    }

    @Override
    public Item updateItem(long id, Item item) {
        Item item1 = itemRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(MSG));
        if (item1 == null) {
            return null;
        } else {
            if (item1.getStatus().equalsIgnoreCase("1")){
                item.setStatus("1");
                item.setId(item1.getId());
                return itemRepository.save(item);
            }else{
                return null;
            }
        }
    }

    @Override
    public Item deleteItem(long id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(MSG));
        if (item == null) {
            return null;
        } else {
            item.setStatus("0");
            return itemRepository.save(item);
        }
    }

    @Override
    public Item searchItem(long id) {
        return itemRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(MSG));
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
}
