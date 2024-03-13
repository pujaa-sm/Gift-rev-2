
package com.example.demo.controller;


//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

//import com.example.demo.model.Customer;
import com.example.demo.model.Gift;
import com.example.demo.service.GiftService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class GiftController {
    @Autowired
    private GiftService giftService;

    @PostMapping("/gift")
    public Gift create(@RequestBody Gift gift)
    {
        return giftService.post(gift);
    }
    @GetMapping("/gift/{id}")
    public Gift getGift(@PathVariable int id)
    {
        return giftService.getGift(id);
    }
    @GetMapping("/api/gift/{offset}/{pagesize}")
    public ResponseEntity<Page<Gift>> get(@PathVariable int offset,@PathVariable int pagesize)
    {
        Page<Gift>list=giftService.getByPage(offset,pagesize);
        if(list.isEmpty())
        {
            return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
    }
    @GetMapping("/gift/{offset}/{pagesize}/{field}")
    public ResponseEntity<Page<Gift>> getPageSortGift(@PathVariable("offset") int offset,@PathVariable("pagesize") int pagesize,@PathVariable("field") String field) {
        Page<Gift> sort=giftService.pageSortGift(offset,pagesize,field);
        if(sort!=null){
            return new ResponseEntity<>(sort,HttpStatus.OK);
        }
        return new ResponseEntity<>(sort,HttpStatus.NOT_FOUND);
    }
}