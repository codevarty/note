package com.project.note.domain.member.service;

import com.project.note.domain.member.entity.Member;
import com.project.note.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Member findMember(String id) {
        return memberRepository.findByMemberId(id);
    }
}
