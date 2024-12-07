package com.example.campus.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
    String testConnection();
    String findMember(String memberId);
}
