package com.project.note.domain.member.mapper;

import com.project.note.domain.member.entity.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberMapper {

    @Select("SELECT * FROM MEMBER")
    @Results({
            @Result(column = "MEMBER_ID", property = "memberId"),
            @Result(column = "NAME", property = "name"),
            @Result(column = "PASSWORD", property = "password"),
            @Result(column = "BRDT", property = "brdt"),
            @Result(column = "JOIN_DT", property = "joinDt")})
    List<Member> findAll();

    @Select("SELECT * FROM MEMBER WHERE MEMBER_ID=#{id}")
    @Results({
            @Result(column = "MEMBER_ID", property = "memberId"),
            @Result(column = "NAME", property = "name"),
            @Result(column = "PASSWORD", property = "password"),
            @Result(column = "BRDT", property = "brdt"),
            @Result(column = "JOIN_DT", property = "joinDt")})
    Member findByMemberId(@Param("id") String id);

    @Insert("INSERT INTO MEMBER(MEMBER_ID, PASSWORD, NAME, BRDT, JOIN_DT) " +
            "VALUES(#{memberId}, #{password}, #{name}, #{brdt}, DEFAULT)")
    void insertMember(Member member);

    @Update("UPDATE MEMBER " +
            "SET PASSWORD = #{password}," +
            "NAME = #{name}," +
            "BRDT = #{brdt} " +
            "WHERE MEMBER_ID = #{memberId}")
    void updateMember(Member member);

    @Delete("DELETE MEMBER " +
            "WHERE MEMBER_ID = #{id}")
    void deleteMember(@Param("id") String id);
}
