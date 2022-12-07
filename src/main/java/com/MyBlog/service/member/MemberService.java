package com.MyBlog.service.member;

import com.MyBlog.domain.dto.MemberDto;
import com.MyBlog.domain.entity.member.MemberEntity;
import com.MyBlog.domain.entity.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public boolean signup(MemberDto memberDto) {
        MemberEntity memberEntity = memberRepository.save(memberDto.toEntity());
        if(memberEntity.getMno() != 0) {
            return true;
        }
        return false;
    }

}
