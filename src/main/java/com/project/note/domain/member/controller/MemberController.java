package com.project.note.domain.member.controller;

import com.project.note.domain.member.dto.MemberResponseDto;
import com.project.note.domain.member.dto.RegisterRequestDto;
import com.project.note.domain.member.dto.UpdateMemberInfoDto;
import com.project.note.domain.member.dto.UpdatePasswordRequestDto;
import com.project.note.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/find-all")
    public ResponseEntity<List<MemberResponseDto>> findAll() {
        return ResponseEntity.ok(memberService.findAll());
    }

    @PostMapping("/register")
    public ResponseEntity<MemberResponseDto> register(@RequestBody RegisterRequestDto requestDto) {
        MemberResponseDto savedMember = memberService.saveMember(requestDto);
        return ResponseEntity.ok(savedMember);
    }

    @PutMapping("/{id}/change-password")
    public ResponseEntity<MemberResponseDto> updatePassword(@PathVariable("id") String id, @RequestBody UpdatePasswordRequestDto requestDto) {
        MemberResponseDto updatedMember = memberService.updatePassword(id, requestDto);
        return ResponseEntity.ok(updatedMember);
    }

    @PutMapping("/{id}/change-info")
    public ResponseEntity<MemberResponseDto> changeInfo(@PathVariable("id") String id, @RequestBody UpdateMemberInfoDto requestDto) {
        MemberResponseDto updatedMember = memberService.updateMember(id, requestDto);
        return ResponseEntity.ok(updatedMember);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id) {
        memberService.deleteMember(id);

        return ResponseEntity.ok("Deleted");
    }
}
