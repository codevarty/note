package com.project.note.domain.member.service;

import com.project.note.domain.member.dto.MemberResponseDto;
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

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public List<MemberResponseDto> findAll() {
        List<Member> memberList = memberRepository.findAll()
                .orElse(Collections.emptyList());

        return memberList.stream()
                .map(MemberResponseDto::of).toList();
    }

    public MemberResponseDto saveMember(RegisterRequestDto requestDto) {
        // 회원이 있는 경우 에러 발생.
        Optional<Member> findMember = memberRepository.findByMemberId(requestDto.getId());
        // 동일한 아이디를 가지는 회원이 있는 경우 에러 발생.
        if (findMember.isPresent()) {
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

        return MemberResponseDto.of(member);
    }

    public MemberResponseDto updatePassword(String id, UpdatePasswordRequestDto dto) {
        // 회원이 없는 경우 에러 발생.
        Member findMember = memberRepository.findByMemberId(id)
                .orElseThrow(() -> new CustomException(MemberErrorCode.NOT_FOUND_MEMBER));
        // 기존 아이디가 불일치하면 에러 발생.
        if (!passwordEncoder.matches(dto.getOldPassword(), findMember.getPassword())) {
            throw new CustomException(MemberErrorCode.INVALID_PASSWORD);
        }

        findMember.changePassword(passwordEncoder.encode(dto.getNewPassword()));

        memberRepository.update(findMember);

        return MemberResponseDto.of(findMember);
    }
}
