package com.project.note.domain.member.entity;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member {
    private String memberId;
    private String name;
    private String password;
    private LocalDate brdt;
    private LocalDate joinDt;

    /**
     * 비밀번호 변경 메소드
     * 
     * @param newPassword 새로운 비밀번호
     */
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    /** 아이디와 비밀번호를 제외한 회원의 정보 수정
     * 
     * @param name 이름
     * @param brdt 생년월일
     */
    public void changeMemberInfo(String name, LocalDate brdt) {
        this.name = name;
        this.brdt = brdt;
    }
}
