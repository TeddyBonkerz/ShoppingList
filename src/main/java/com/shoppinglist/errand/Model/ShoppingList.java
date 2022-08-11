package com.shoppinglist.errand.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="SHOPLIST")
public class ShoppingList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="SHOPLIST_ID")
    private long id;
    @Column(name="LIST_NAME")
    private String name;
    @OneToMany(mappedBy="shopList", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Product> products;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }





}
