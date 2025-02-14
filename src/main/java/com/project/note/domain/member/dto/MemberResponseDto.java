package com.project.note.domain.member.dto;

import com.project.note.domain.member.entity.Member;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponseDto {
    private String memberId;
    private String name;
    private LocalDate brdt;
    private LocalDate joinDt;

    // Member entity -> response dto
    public static MemberResponseDto of(Member member) {
        return MemberResponseDto.builder()
                .memberId(member.getMemberId())
                .name(member.getName())
                .brdt(member.getBrdt())
                .joinDt(member.getJoinDt())
                .build();
    }
}
