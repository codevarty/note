package com.project.note.domain.member.controller;

import com.project.note.domain.member.dto.RegisterRequestDto;
import com.project.note.domain.member.dto.UpdatePasswordRequestDto;
import com.project.note.domain.member.entity.Member;
import com.project.note.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/find-all")
    public ResponseEntity<List<Member>> findAll() {
        return ResponseEntity.ok(memberService.findAll());
    }

    @PostMapping("/register")
    public ResponseEntity<Member> register(@RequestBody RegisterRequestDto requestDto) {
        Member savedMember = memberService.saveMember(requestDto);
        return ResponseEntity.ok(savedMember);
    }

    @PutMapping("/{id}/change-password")
    public ResponseEntity<Member> updatePassword(@PathVariable("id") String id, @RequestBody UpdatePasswordRequestDto requestDto) {
        Member updatedMember = memberService.updatePassword(id, requestDto);
        return ResponseEntity.ok(updatedMember);
    }
}
