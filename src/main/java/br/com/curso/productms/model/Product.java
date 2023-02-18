package br.com.curso.productms.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tb_product")
@Data
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false,unique = true)
    private String name;

    @Column(name = "description",nullable = false)
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "available")
    private boolean available;
}
