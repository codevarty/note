package com.project.note.domain.member.entity;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member {
    private String Member_Id;
    private String name;
    private String password;
    private LocalDate brdt;
    private LocalDate joinDt;
}
