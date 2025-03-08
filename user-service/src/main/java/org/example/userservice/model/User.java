package org.example.userservice.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Getter
@Setter
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int telegramId;
    private String username;
    private String registeredAt;

    public User(Long id, int telegramId, String username, String registeredAt) {
        this.id = id;
        this.telegramId = telegramId;
        this.username = username;
        this.registeredAt = registeredAt;
    }

    public User() {
    }
}
