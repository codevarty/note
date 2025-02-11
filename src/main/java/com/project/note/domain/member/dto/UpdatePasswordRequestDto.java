package com.project.note.domain.member.dto;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePasswordRequestDto {
    private String oldPassword;
    private String newPassword;
}
