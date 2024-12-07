package com.example.campus.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@Data
public class Board {

  private int boardIdx;
  private String title;
  private String content;
  private String memberId;
  private int good;
  private Timestamp createdAt;
  private Timestamp updatedAt;
  private String isUpdated;

}
