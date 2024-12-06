package com.example.campus.Controller;

import com.example.campus.dto.Board;
import com.example.campus.service.BoardService;
import com.example.campus.util.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.TimeZone;

@RestController
@RequestMapping("/api/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/test")
    public void test() {
        logger.info("test");
        String TEXTG = boardService.testConnection();
        logger.info(TEXTG);

        List<Board> lists = boardService.testConnection2();
        for (Board board : lists) {
            logger.info(board.getTitle());
            logger.info(board.getContent());
        }
    }

    @PostMapping("/regist")
    public ResponseEntity<?> regist(@RequestBody Board board) {
        ResponseData data = new ResponseData();
        Timestamp t = new Timestamp(System.currentTimeMillis());
        board.setCreatedAt(t);
        board.setUpdatedAt(t);

        int res = boardService.registerNewArticle(board);

        logger.info(String.valueOf(res));
        return ResponseEntity.ok(data);
    }
}
