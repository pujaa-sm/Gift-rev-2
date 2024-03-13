
package com.example.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Gift;

import com.example.demo.repository.GiftRepo;

@Service
public class GiftService {
    @Autowired
    private GiftRepo giftRepo;
     
    public Gift post(Gift gift)
    {
        return giftRepo.save(gift);
    }
    public Gift getGift(int id)
    {
        return giftRepo.findById(id).orElse(null);
    }
     public Page<Gift> getByPage(int offset,int pagesize)
     {
        return giftRepo.findAll(PageRequest.of(offset,pagesize));
     }
     public Page<Gift> pageSortGift(int offset,int pagesize,String field)
     {
        PageRequest pageRequest=PageRequest.of(offset, pagesize , Sort.by(field));
        return giftRepo.findAll(pageRequest);
    }
}