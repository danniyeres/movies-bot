package org.example.userservice.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserDto {
    private Long id;
    private int telegramId;
    private String username;
    private String registeredAt;
}
