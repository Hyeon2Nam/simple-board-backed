package com.example.campus.service;

import com.example.campus.dao.BoardDao;
import com.example.campus.dto.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardDao boardDao;

    public String testConnection() {
        return boardDao.testConnection();
    }


    public List<Board> testConnection2() {
        return boardDao.testConnection2();
    }
}
