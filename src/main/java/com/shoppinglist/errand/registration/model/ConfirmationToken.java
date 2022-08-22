package com.shoppinglist.errand.registration.model;

import com.shoppinglist.errand.model.ShopperUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class ConfirmationToken {

    @SequenceGenerator(
            name = "token_sequence",
            sequenceName = "token_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "token_sequence"
    )
    private Long Id;
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime createAt;
    @Column(nullable = false)
    private LocalDateTime expiresAt;
    private LocalDateTime confirmedAt;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "user_id")
    private ShopperUser user;

    public ConfirmationToken(String token,
                             LocalDateTime createAt,
                             LocalDateTime expiresAt,
                             ShopperUser user) {
        this.token = token;
        this.createAt = createAt;
        this.expiresAt = expiresAt;
        this.user = user;
    }
}
