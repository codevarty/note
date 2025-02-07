package com.project.note.domain.member.mapper;

import com.project.note.domain.member.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberMapper {

    @Select("SELECT * FROM MEMBER")
    List<Member> findAll();

    @Select("SELECT * FROM MEMBER WHERE MEMBER_ID=#{MemberId}")
    Member findByMemberId(@Param("MemberId") String memberId);
}
