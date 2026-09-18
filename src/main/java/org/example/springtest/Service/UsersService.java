package org.example.springtest.Service;

import lombok.RequiredArgsConstructor;
import org.example.springtest.Repository.UserRepository;
import org.example.springtest.exception.ResourceNotFoundException;
import org.example.springtest.model.dto.UserResponseDto;
import org.example.springtest.model.dto.UserResponseDtoV2;
import org.example.springtest.model.entity.UserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<UserResponseDto> getAllUsersV1() {
        return userRepository.findAll().stream().map(this::toDto).toList();
    }

    @Transactional(readOnly = true)
    public List<UserResponseDtoV2> getAllUsersV2() {
        return userRepository.findAll().stream().map(this::toDto2).toList();
    }

    public UserResponseDto toDto(UserEntity user) {
        return new UserResponseDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }

    public UserResponseDtoV2 toDto2(UserEntity user) {
        return new UserResponseDtoV2(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getFirstName() + " " + user.getLastName()
        );
    }

    @Transactional(readOnly = true)
    public UserEntity getUserById(Long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id müsbət ədəd olmalıdır: " + id);
        }
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("İstifadəçi tapılmadı: " + id));
    }
}