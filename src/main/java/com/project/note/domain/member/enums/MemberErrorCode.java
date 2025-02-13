package com.project.note.domain.member.enums;

import com.project.note.global.error.code.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MemberErrorCode implements ErrorCode {
    NOT_FOUND_MEMBER(HttpStatus.BAD_REQUEST, "Member not found"),
    INVALID_PASSWORD(HttpStatus.BAD_REQUEST, "Invalid password"),
    DUPLICATE_MEMBER(HttpStatus.CONFLICT, "Duplicate member"),
    ;

    private final HttpStatus httpStatus;

    private final String message;
}
