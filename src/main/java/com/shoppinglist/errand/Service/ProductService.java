package com.shoppinglist.errand.Service;

import com.shoppinglist.errand.Model.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    public List<Product> getProducts(){
        return List.of(new Product(1L, "IJ", "live, love, laugh"));
    }
}
