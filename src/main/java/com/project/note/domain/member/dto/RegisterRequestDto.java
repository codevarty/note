package com.project.note.domain.member.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDto {
    private String id;
    private String password;
    private String name;
    private LocalDate birthdate;
}
