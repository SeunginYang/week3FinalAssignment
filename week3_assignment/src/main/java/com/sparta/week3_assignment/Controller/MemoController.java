package com.sparta.week3_assignment.Controller;

import com.sparta.week3_assignment.apiresult.ApiResult;
import com.sparta.week3_assignment.apiresult.ResultPrint;
import com.sparta.week3_assignment.domain.Memo;
import com.sparta.week3_assignment.domain.MemoRepository;
import com.sparta.week3_assignment.domain.MemoRequestDto;
import com.sparta.week3_assignment.domain.PassWordRequestDto;
import com.sparta.week3_assignment.service.MemoService;
import com.sparta.week3_assignment.service.PasswordConfirm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {
    private final MemoRepository memoRepository;
    private final MemoService memoService;
    private final PasswordConfirm passwordConfirm;

    @PostMapping("/api/memos")
    public ApiResult<?> createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return ResultPrint.success(memoRepository.save(memo));
    }

    @GetMapping("/api/memos")
    public ApiResult<?> getMemos() {
        return ResultPrint.success(memoRepository.findAllByOrderByModifiedAtDesc());
    }

    @GetMapping("/api/memos/{id}")
    public ApiResult<?> getWrite(@PathVariable Long id) {
        return ResultPrint.success(memoRepository.findById(id));
    }

    @PutMapping ("/api/memos/{id}")
    public ApiResult<?> updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        memoService.update(id, requestDto);
        return ResultPrint.success(memoRepository.findById(id));
    }

    @DeleteMapping("/api/memos/{id}")
    public ApiResult<?> deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);
        return ResultPrint.success(true);
    }
    @PostMapping("/api/memos/{id}")
    public ApiResult<?> passwordConfirm1(@PathVariable Long id, @RequestBody PassWordRequestDto requestDto){
        return ResultPrint.success(passwordConfirm.confirm(id, requestDto));
    }

}