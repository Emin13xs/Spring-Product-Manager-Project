package org.example.springtest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserResponseDtoV2 {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String fullName;
}
