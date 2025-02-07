package com.project.note.domain.member.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    private String Member_Id;
    private String name;
    private String password;
    private LocalDate brdt;
    private LocalDate joinDt;

    @Builder
    public Member(String memberId, String name, String password, LocalDate brdt) {
        this.Member_Id = memberId;
        this.name = name;
        this.password = password;
        this.brdt = brdt;
        this.joinDt =  LocalDate.now(); // 현재 시간 지정.
    }
}
