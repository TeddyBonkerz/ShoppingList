package com.shoppinglist.errand.service;

import com.shoppinglist.errand.model.ShopperUser;
import com.shoppinglist.errand.registration.ConfirmationTokenRepository;
import com.shoppinglist.errand.registration.model.ConfirmationToken;
import com.shoppinglist.errand.repository.ShopperUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ShopperUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND = "user with email %s not found";
    private final ShopperUserRepository userRepository;
    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, email)));
    }

    public String signUp(ShopperUser user){
        boolean userExists = userRepository.findByEmail(user.getEmail()).isPresent();

        if(userExists){
            throw new IllegalStateException("email already exists");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token, LocalDateTime.now(), LocalDateTime.now().plusMinutes(15), user);

        confirmationTokenRepository.save(confirmationToken);

        return token;
    }

    public void enableUser(String email) {
        userRepository.enableAppUser(email);
    }
}
