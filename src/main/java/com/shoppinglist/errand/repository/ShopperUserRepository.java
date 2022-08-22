package com.shoppinglist.errand.repository;

import com.shoppinglist.errand.model.ShopperUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface ShopperUserRepository extends JpaRepository<ShopperUser, String> {

    Optional<ShopperUser> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE ShopperUser user " +
            "SET user.isEnabled = TRUE WHERE user.email = ?1")
    void enableAppUser(String email);
}
