package org.example.userservice.service;

import lombok.RequiredArgsConstructor;
import org.example.userservice.model.User;
import org.example.userservice.model.UserDto;
import org.example.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void registerUser(UserDto userDto) {

        if (userRepository.findByTelegramId(userDto.getTelegramId()) != null)
            throw new RuntimeException("User already exists");


        var user = new User();
        user.setTelegramId(userDto.getTelegramId());
        user.setUsername(userDto.getUsername());
        user.setRegisteredAt(Instant.now().toString());

        userRepository.save(user);
    }

    public UserDto getUserById(Long id) {

        var user = userRepository.findById(id);
        if (user.isEmpty())
            throw new RuntimeException("User not found");

        return UserDto.builder()
                .id(user.get().getId())
                .telegramId(user.get().getTelegramId())
                .username(user.get().getUsername())
                .registeredAt(user.get().getRegisteredAt())
                .build();
    }

    public UserDto getUserByTelegramId(int telegramId) {
        var user = userRepository.findByTelegramId(telegramId);
        if (user == null)
            throw new RuntimeException("User not found");

        return UserDto.builder()
                .id(user.getId())
                .telegramId(user.getTelegramId())
                .username(user.getUsername())
                .registeredAt(user.getRegisteredAt())
                .build();
    }

    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }
}
