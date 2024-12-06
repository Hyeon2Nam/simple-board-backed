package com.example.campus.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_seq")
    private int memberSeq;

    @Column(name = "member_id", nullable = true, length = 30)
    private String memberId;

    @Column(name = "member_pw", nullable = true, length = 255)
    private String memberPw;

    @Column(name = "member_email", nullable = true, length = 50)
    private String memberEmail;

    @Column(name = "member_name", nullable = true, length = 30)
    private String memberName;
}
