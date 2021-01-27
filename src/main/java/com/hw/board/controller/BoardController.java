package com.hw.board.controller;

import com.hw.board.domain.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardRepository boardRepository;

    @GetMapping("/ip")
    public ResponseEntity<String> ip(HttpServletRequest request) {
        // 요청을 보낸 클라이언트의 IP 주소를 반환합니다.
        return ResponseEntity.ok(request.getRemoteAddr());
    }
}
