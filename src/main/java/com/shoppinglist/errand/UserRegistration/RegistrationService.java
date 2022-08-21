package com.shoppinglist.errand.UserRegistration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    public String register(RegistrationRequest request) {
        return "Kewl";
    }
}
