package com.shoppinglist.errand.Controller;

import com.shoppinglist.errand.Model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private static final String message = "I am a product of so many things";

    @GetMapping("/product")
    public List<Product> getAllProducts(){
        return List.of(new Product(1L, "IJ", "live, love, laugh"));
    }
}
