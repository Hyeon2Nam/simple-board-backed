package com.example.campus.dao;


import com.example.campus.dto.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDao {

  List<Board> loadArticleList();

  int registerNewArticle(Board board);

  Board loadArticleDetail(int boardId);

  int deleteArticle(int boardId);

  String findArticleCreated(int boardId);

  int findArticleCurrentGood(int boardId);

  int countArticleGood(int boardId, int good);

  String loadArticleAuthor(int boardId);

  int modifyArticleData(Board board);
}
