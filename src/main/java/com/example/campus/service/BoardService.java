package com.example.campus.service;

import com.example.campus.dao.BoardDao;
import com.example.campus.dto.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class BoardService {

    @Autowired
    private BoardDao boardDao;

    public List<Board> loadArticleList(String keyword, String created) {
        List<Board> boardList = boardDao.loadArticleList();
        List<Board> filterList = new ArrayList<>();

        if (!boardList.isEmpty())
            filterList = boardList.stream().filter(i -> i.getTitle().contains(keyword))
                    .filter(i -> i.getMemberId().contains(created))
                    .toList();

        return filterList;
    }

    public int registerNewArticle(Board board) {
        return boardDao.registerNewArticle(board);
    }

    public Board loadArticleDetail(int boardId) {
        return boardDao.loadArticleDetail(boardId);
    }
}
