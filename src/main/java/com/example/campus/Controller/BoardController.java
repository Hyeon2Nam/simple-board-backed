package com.example.campus.Controller;

import com.example.campus.dto.Board;
import com.example.campus.service.BoardService;
import com.example.campus.util.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional
    @GetMapping("/list")
    public ResponseEntity<?> loadArticleList(
            @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
            @RequestParam(value = "created", required = false, defaultValue = "") String created
    ) {
        ResponseData data = new ResponseData();

        List<Board> lists = boardService.loadArticleList(keyword, created);
//        for (Board board : lists)
//            logger.info(board.getTitle() + " " + board.getContent());

        if (!lists.isEmpty())
            data.setData(lists);
        else
            data.setMsg("null");

        return ResponseEntity.ok(data);
    }

    @Transactional
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

    @Transactional
    @PostMapping("/modify")
    public ResponseEntity<?> modify(@RequestBody Board board) {
        ResponseData data = new ResponseData();
        Timestamp t = new Timestamp(System.currentTimeMillis());
        board.setUpdatedAt(t);

        return ResponseEntity.ok(data);
    }

    @Transactional
    @GetMapping("/find")
    public ResponseEntity<?> findArticle(
            @RequestParam(value = "boardId", required = false, defaultValue = "") String boardId
    ) {
        ResponseData data = new ResponseData();
        Board article = boardService.loadArticleDetail(Integer.parseInt(boardId));

        if (article == null)
            data.setMsg("null");

        data.setData(article);

        return ResponseEntity.ok(data);
    }

    @Transactional
    @PostMapping("/remove")
    public ResponseEntity<?> removeArticle(@RequestBody Board board) {
        ResponseData data = new ResponseData();

        int res = boardService.deleteArticle(board.getBoardIdx());

        return ResponseEntity.ok(data);
    }

    @Transactional
    @PostMapping("/good")
    public ResponseEntity<?> goodArticle(@RequestBody Board board) {
        ResponseData data = new ResponseData();

        int idx = board.getGood();
        int curGood = boardService.findArticleCurrentGood(idx);
        int newGood = curGood + 1;
        int res = boardService.countArticleGood(idx, newGood);

        return ResponseEntity.ok(data);
    }
}
