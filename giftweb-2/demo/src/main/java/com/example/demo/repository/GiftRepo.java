
package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Gift;

@Repository
public interface GiftRepo extends JpaRepository<Gift,Integer>
{
    
}