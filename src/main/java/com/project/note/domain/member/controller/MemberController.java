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
        try {
            return ResponseEntity.ok(memberService.findAll());
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Member> register(@RequestBody RegisterRequestDto requestDto) {
        try {
            Member savedMember = memberService.saveMember(requestDto);
            return ResponseEntity.ok(savedMember);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

    @PutMapping("/{id}/change-password")
    public ResponseEntity<Member> updatePassword(@PathVariable String id, @RequestBody UpdatePasswordRequestDto requestDto) {
        try {
            Member member = memberService.updatePassword(id, requestDto);
            return ResponseEntity.ok(member);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }
}
