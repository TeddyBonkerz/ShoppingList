package com.shoppinglist.errand.userRegistration;

import com.shoppinglist.errand.configuration.ShopperUserRole;
import com.shoppinglist.errand.helper.EmailValidator;
import com.shoppinglist.errand.model.ShopperUser;
import com.shoppinglist.errand.service.ShopperUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final ShopperUserService userService;
    private final EmailValidator emailValidator;
    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());

        if(!isValidEmail){
            throw new IllegalStateException("email not valid");
        }
        ShopperUser user =  new ShopperUser();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setUserRole(ShopperUserRole.USER);
        return userService.signUp(user);
    }
}
