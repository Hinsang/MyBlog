package com.MyBlog.controller.member;

import com.MyBlog.domain.dto.MemberDto;
import com.MyBlog.domain.entity.member.MemberEntity;
import com.MyBlog.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // 로그인 정보 불러오기
    @GetMapping("/getloginInfo")
    public MemberEntity getloginInfo() {
        return memberService.getloginInfo();
    }

    // 회원가입
    @PostMapping("/setsignup")
    public boolean signup(@RequestBody MemberDto memberDto) {
        return memberService.signup(memberDto);
    }

    // 로그인
    @PostMapping("/setlogin")
    public int login(@RequestBody MemberDto memberDto) {
        return memberService.login(memberDto);
    }

    // 로그아웃
    @GetMapping("/logout")
    public void logout() {
        memberService.logout();
    }

}
