package com.sparta.week3_assignment.service;

import com.sparta.week3_assignment.domain.Memo;
import com.sparta.week3_assignment.domain.MemoRepository;
import com.sparta.week3_assignment.domain.PassWordRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PasswordConfirm {
    private final MemoRepository MemoRepository;

    @Transactional
    public Boolean confirm(Long id, PassWordRequestDto requestDto){
        Memo memo = MemoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );

        return memo.confirm(requestDto);
    }
}
