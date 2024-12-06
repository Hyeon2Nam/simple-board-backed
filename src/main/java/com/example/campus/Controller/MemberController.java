package com.example.campus.Controller;

import com.example.campus.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/member")
public class MemberController {
    @Autowired
    private MemberService memberService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/")
    public void test() {
        memberService.testConnection();
    }
}
