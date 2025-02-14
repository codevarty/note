package com.project.note.domain.member.repository;

import com.project.note.domain.member.entity.Member;
import com.project.note.domain.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final MemberMapper mapper;

    public Optional<List<Member>> findAll() {
        return Optional.ofNullable(mapper.findAll());
    }

    public Optional<Member> findByMemberId(String id) {
        return Optional.ofNullable(mapper.findByMemberId(id));
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
