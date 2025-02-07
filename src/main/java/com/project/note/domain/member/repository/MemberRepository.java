package com.project.note.domain.member.repository;

import com.project.note.domain.member.entity.Member;
import com.project.note.domain.member.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {
    private MemberMapper mapper;

    @Autowired
    public MemberRepository(MemberMapper mapper) {
        this.mapper = mapper;
    }

    public List<Member> findAll() {
        return mapper.findAll();
    }

    public Member findByMemberId(String id) {
        return mapper.findByMemberId(id);
    }
}
