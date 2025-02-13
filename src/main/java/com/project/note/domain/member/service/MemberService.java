package com.project.note.domain.member.service;

import com.project.note.domain.member.dto.RegisterRequestDto;
import com.project.note.domain.member.dto.UpdatePasswordRequestDto;
import com.project.note.domain.member.entity.Member;
import com.project.note.domain.member.enums.MemberErrorCode;
import com.project.note.domain.member.repository.MemberRepository;
import com.project.note.global.error.exception.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    private Member findMember(String id) {
        return memberRepository.findByMemberId(id);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Member saveMember(RegisterRequestDto requestDto) {
        Member findMember = findMember(requestDto.getId());
        if (findMember != null) {
            throw new CustomException(MemberErrorCode.DUPLICATE_MEMBER);
        }

        Member member = Member.builder()
                .memberId(requestDto.getId())
                .password(passwordEncoder.encode(requestDto.getPassword())) // 비밀번호는 암호화해서 저장.
                .name(requestDto.getName())
                .brdt(requestDto.getBirthdate())
                .build();

        log.info("저장하는 멤버: {}", member);

        memberRepository.save(member);

        return member;
    }

    public Member updatePassword(String id, UpdatePasswordRequestDto dto) {
        Member findMember = findMember(id);
        if (findMember == null) {
            throw new CustomException(MemberErrorCode.NOT_FOUND_MEMBER);
        }

        // 기존 아이디가 불일치하면 에러 발생.
        if (!passwordEncoder.matches(dto.getOldPassword(), findMember.getPassword())) {
            throw new CustomException(MemberErrorCode.INVALID_PASSWORD);
        }

        findMember.changePassword(passwordEncoder.encode(dto.getNewPassword()));

        memberRepository.update(findMember);

        return findMember;
    }
}
