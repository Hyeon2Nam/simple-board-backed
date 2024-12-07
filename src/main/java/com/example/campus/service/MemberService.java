package com.example.campus.service;

import com.example.campus.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberDao memberDao;

    public String testConnection() {
        return memberDao.testConnection();
    }

    public String findMember(String memberId){
        return memberDao.findMember(memberId);
    }

}

