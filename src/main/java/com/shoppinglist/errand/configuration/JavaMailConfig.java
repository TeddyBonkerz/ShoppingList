package com.shoppinglist.errand.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class JavaMailConfig {

    @Bean
    public JavaMailSender javaMailSender(){
        return new JavaMailSenderImpl();
    }
//    CommandLineRunner commandLineRunner(RecipeRepository recipeRepository){
//        return args -> {
//            Recipe recipe = new Recipe("Gozleme", "Recipe for turkis dish");
//            recipeRepository.save(hmm);
//        };
//    }
}
