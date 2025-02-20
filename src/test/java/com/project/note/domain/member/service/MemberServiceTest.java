package com.project.note.domain.member.service;


import com.project.note.domain.member.dto.MemberResponseDto;
import com.project.note.domain.member.dto.RegisterRequestDto;
import com.project.note.domain.member.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void init() {
        memberRepository.deleteAll();
    }

    @Test
    @DisplayName("Save Member")
    void saveMember() {
        RegisterRequestDto requestDto = new RegisterRequestDto();
        requestDto.setId("test1");
        requestDto.setPassword("test");
        requestDto.setName("TEST");
        requestDto.setBirthdate(LocalDate.now());
        MemberResponseDto response = memberService.saveMember(requestDto);

        Assertions.assertThat(response.getMemberId()).isEqualTo(requestDto.getId());
    }

    @Test
    @DisplayName("Delete Member")
    void deleteMember() {
        RegisterRequestDto requestDto = new RegisterRequestDto();
        requestDto.setId("test1");
        requestDto.setPassword("test");
        requestDto.setName("TEST");
        requestDto.setBirthdate(LocalDate.now());

        MemberResponseDto response = memberService.saveMember(requestDto);

        memberService.deleteMember(response.getMemberId());

        List<MemberResponseDto> responseList = memberService.findAll();

        Assertions.assertThat(responseList).isEmpty();
    }

    @Test
    @DisplayName("Find All")
    void finaAll() {

        RegisterRequestDto requestDto1 = new RegisterRequestDto();
        requestDto1.setId("test1");
        requestDto1.setPassword("test");
        requestDto1.setName("TEST");
        requestDto1.setBirthdate(LocalDate.now());

        memberService.saveMember(requestDto1);

        RegisterRequestDto requestDto2 = new RegisterRequestDto();
        requestDto2.setId("test2");
        requestDto2.setPassword("test");
        requestDto2.setName("TEST");
        requestDto2.setBirthdate(LocalDate.now());

        memberService.saveMember(requestDto2);

        List<MemberResponseDto> responseList = memberService.findAll();

        Assertions.assertThat(responseList).hasSize(2);

    }
}