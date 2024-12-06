package com.example.campus.Controller;

import com.example.campus.dto.Board;
import com.example.campus.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/test")
    public void test() {
        logger.info("test");
        String TEXTG= boardService.testConnection();
        logger.info(TEXTG);

        List<Board> lists = boardService.testConnection2();
        for(Board board : lists) {
            logger.info(board.getTitle());
            logger.info(board.getContent());
        }
    }

}
