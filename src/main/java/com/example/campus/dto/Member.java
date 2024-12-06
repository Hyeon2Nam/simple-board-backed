package com.example.campus.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member {
    private int memberSeq;
    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberEmail;

}
