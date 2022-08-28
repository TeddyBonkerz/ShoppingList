package com.shoppinglist.errand.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shoppinglist.errand.configuration.ShopperUserRole;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class ShopperUser implements UserDetails {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Schema(description = "First name of user")
    @JsonProperty(required=true)
    private String firstName;

    @Schema(description = "Last name of user")
    @JsonProperty(required=true)
    private String lastName;

    @Schema(description = "Email or Username of user")
    @JsonProperty(required=true)
    private String email;

    @Schema(description = "User encrypted password")
    @JsonProperty(required=true)
    private String password;

    @Schema(description = "User roles")
    @JsonProperty(required=true)
    @Enumerated(EnumType.STRING)
    private ShopperUserRole userRole;
    private Boolean isLocked = false;
    private Boolean isEnabled = false;

    public ShopperUser(String firstName, String lastName, String email, String password,
                       ShopperUserRole userRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
