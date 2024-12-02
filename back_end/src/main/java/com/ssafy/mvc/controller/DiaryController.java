package com.ssafy.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.mvc.model.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.mvc.model.dto.Diary;
import com.ssafy.mvc.model.service.DiaryService;

@RestController
@RequestMapping("/api-diary")
@CrossOrigin("*")
public class DiaryController {

    private DiaryService diaryService;

    @Autowired
    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    // #1.
    // 일기 생성
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> diaryCreate(@RequestBody Diary diary) {
        HttpStatus status = null;
        Map<String, Object> result = new HashMap<>();
        if (diaryService.diaryCreate(diary)) {
            status = HttpStatus.CREATED;
            result.put("message", "일기 작성 완료");
        } else {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            result.put("message", "일기 작성 실패");
        }

        return new ResponseEntity<>(result, status);
    }

    // #2.
    // 일기 불러오기
    @PostMapping("/read")
    public ResponseEntity<Map<String, Object>> diaryRead(@RequestBody User user) {

        int userNo = user.getUserNo();
        HttpStatus status = null;
        Map<String, Object> result = new HashMap<>();

        List<Diary> list = diaryService.diaryRead(userNo);
        if (list != null) {
            status = HttpStatus.OK;
            result.put("list", list);
        } else {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            result.put("message", "일기가 없습니다.");
        }
        return new ResponseEntity<>(result, status);
    }

    // #3.
    // 일기 요약 불러오기
    @PostMapping("/summary")
    public ResponseEntity<Map<String, Object>> diarySummary(@RequestBody User user) {
        int userNo = user.getUserNo();
        HttpStatus status = null;
        Map<String, Object> result = new HashMap<>();

        List<Diary> list = diaryService.diaryRead(userNo);

        if (list != null) {
            status = HttpStatus.OK;
            result.put("list", list);
        } else {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            result.put("message", "일기가 없습니다.");
        }
        return new ResponseEntity<>(result, status);
    }
}
