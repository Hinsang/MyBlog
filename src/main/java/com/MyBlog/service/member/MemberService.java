package com.MyBlog.service.member;

import com.MyBlog.domain.dto.MemberDto;
import com.MyBlog.domain.entity.member.MemberEntity;
import com.MyBlog.domain.entity.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private HttpServletRequest request;

    // 로그인 정보 확인
    @Transactional
    public MemberEntity getloginInfo(){

        Object object = request.getSession().getAttribute("loginMno");

        if( object == null ) { return null; }
        int mno = (Integer)object;
        Optional<MemberEntity> optional =  memberRepository.findById(mno);
        if( !optional.isPresent() ){ return null; }
        // 4. 로그인된 회원의 엔티티
        return optional.get();

    }

    // 회원가입
    @Transactional
    public boolean signup(MemberDto memberDto) {
        MemberEntity memberEntity = memberRepository.save(memberDto.toEntity());
        if(memberEntity.getMno() != 0) {
            return true;
        }
        return false;
    }

    // 로그인
    @Transactional
    public int login(MemberDto memberDto) {
        List<MemberEntity> entityList = memberRepository.findAll();
        for(MemberEntity entity : entityList) {
            if(entity.getMid().equals(memberDto.getMid())) {
                if(entity.getMpw().equals(memberDto.getMpw())) {
                    request.getSession().setAttribute("loginMno", entity.getMno());
                    return 1;
                } else {
                    return 2;
                }
            }
        }
        return 0;
    }

    // 로그아웃
    public void logout() {
        request.getSession().setAttribute("loginMno", null);
    }

}














