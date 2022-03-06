

package com.edu.soap.gadgetMart.controller;

import com.edu.soap.gadgetMart.entity.Item;
import com.edu.soap.gadgetMart.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemservice;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity addItem(@RequestBody Item item) {
        Item item1 = itemservice.addItem(item);
        if (item1 == null) {
            return new ResponseEntity(item1, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(item1, HttpStatus.OK);
        }

    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity deleteItem(@PathVariable(value = "id") long id) {
        Item item = itemservice.deleteItem(id);
        if (item == null) {
            return new ResponseEntity(item, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(item, HttpStatus.OK);
        }
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getAllItems() {
        List<Item> allItems = itemservice.getAllItems();
        if (allItems == null) {
            return new ResponseEntity(allItems, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(allItems, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity updateItem(@PathVariable(value = "id") long id, @RequestBody Item item) {
        Item item1 = itemservice.updateItem(id, item);
        if (item1 == null) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(item1, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity searchItem(@PathVariable(value = "id") long id) {
        Item item = itemservice.searchItem(id);
        if (item == null) {
            return new ResponseEntity(item, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(item, HttpStatus.OK);
        }
    }
}
