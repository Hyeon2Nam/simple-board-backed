package com.example.campus.dao;


import com.example.campus.dto.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardDao {

    @Select("SELECT 'TEST' FROM DUAL")
    String testConnection();

    List<Board> testConnection2();

    int registerNewArticle(Board board);
}
