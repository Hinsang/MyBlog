package com.MyBlog.controller.member;

import com.MyBlog.domain.dto.MemberDto;
import com.MyBlog.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/member/signup")
    public boolean signup(@RequestBody MemberDto memberDto) {
        return memberService.signup(memberDto);
    }

}
