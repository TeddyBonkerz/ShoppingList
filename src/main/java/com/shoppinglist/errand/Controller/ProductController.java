package com.shoppinglist.errand.Controller;

import com.shoppinglist.errand.Model.Product;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private static final String message = "I am a product of so many things";


    public Product getProduct(@RequestParam(value = "name") String name){

    }
}
