package org.example.springtest.controller;

import lombok.RequiredArgsConstructor;
import org.example.springtest.Service.UsersService;
import org.example.springtest.model.dto.UserResponseDto;
import org.example.springtest.model.dto.UserResponseDtoV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UsersService usersService;

    @GetMapping("v1/users")
    public List<UserResponseDto> getAllUsersV1(){
        return usersService.getAllUsersV1();
    }
    @GetMapping("v2/users")
    public List<UserResponseDtoV2> getAllUsersV2(){
        return usersService.getAllUsersV2();
    }

}
