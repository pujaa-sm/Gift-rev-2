package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Gift {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String giftname;
     
    @JsonManagedReference
    @OneToMany(mappedBy = "gift",cascade = CascadeType.ALL)
    private List<Customer> customers;
}

