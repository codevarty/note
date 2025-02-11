package com.project.note.domain.member.repository;

import com.project.note.domain.member.entity.Member;
import com.project.note.domain.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final MemberMapper mapper;

    public List<Member> findAll() {
        return mapper.findAll();
    }

    public Member findByMemberId(String id) {
        return mapper.findByMemberId(id);
    }

    public void save(Member member) {
        mapper.insertMember(member);
    }

    public void update(Member member) {
        mapper.updateMember(member);
    }

    public void delete(String id) {
        mapper.deleteMember(id);
    }
}
