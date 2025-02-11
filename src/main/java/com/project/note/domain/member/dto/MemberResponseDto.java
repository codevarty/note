package com.project.note.domain.member.dto;

import lombok.*;

import java.time.LocalDate;

@Data
public class MemberResponseDto {
    private String memberId;
    private String name;
    private LocalDate brdt;
    private LocalDate joinDt;
}
