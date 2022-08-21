package com.shoppinglist.errand.Repositories;

import com.shoppinglist.errand.Model.ShopperUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface ShopperUserRepository extends JpaRepository<ShopperUser, String> {

    Optional<ShopperUser> findByEmail(String email);
}
