package com.shoppinglist.errand.registration;

import com.shoppinglist.errand.configuration.ShopperUserRole;
import com.shoppinglist.errand.helper.EmailValidator;
import com.shoppinglist.errand.model.ShopperUser;
import com.shoppinglist.errand.registration.ConfirmationToken;
import com.shoppinglist.errand.registration.ConfirmationTokenService;
import com.shoppinglist.errand.registration.RegistrationRequest;
import com.shoppinglist.errand.service.ShopperUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final ShopperUserService userService;
    private final EmailValidator emailValidator;

    private final ConfirmationTokenService confirmationTokenService;
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

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));
        if(confirmationToken.getConfirmedAt() != null){
            throw new IllegalStateException("email already confirmed");
        };

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();
        if(expiredAt.isBefore(LocalDateTime.now())){
            throw new IllegalStateException("token has expired");
        }

        confirmationToken.setConfirmedAt(LocalDateTime.now());
        userService.enableUser(confirmationToken.getUser().getEmail());

        return "confirmed";
    }
}
