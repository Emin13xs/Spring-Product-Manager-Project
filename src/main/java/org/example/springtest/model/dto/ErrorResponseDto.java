package org.example.springtest.model.dto;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
public class ErrorResponseDto {
    private String message;
    private int status;
    private String path;
    private LocalDateTime timestamp;
}
