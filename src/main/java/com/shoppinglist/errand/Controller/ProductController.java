package com.shoppinglist.errand.Controller;

import com.shoppinglist.errand.Model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private static final String message = "I am a product of so many things";

    @GetMapping
    public String test(){
        return "This is a test";
    }

    public Product getProduct(@RequestParam(value = "name") String name){

    }
}
