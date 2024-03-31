package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.UserDTO;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public User readUserById(Long userId){
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Такого пользователя нету"));
    }

    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }

    public User createUser(UserDTO dto){
        return userRepository.save(User.builder()
                .nickname(dto.getNickname())
                .build());
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }
}
