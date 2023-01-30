package com.MyBlog.service.board;

import com.MyBlog.domain.dto.CommentDto;
import com.MyBlog.domain.entity.board.BoardEntity;
import com.MyBlog.domain.entity.board.BoardRepository;
import com.MyBlog.domain.entity.board.CommentEntity;
import com.MyBlog.domain.entity.board.CommentRepository;
import com.MyBlog.domain.entity.member.MemberEntity;
import com.MyBlog.domain.entity.member.MemberRepository;
import com.MyBlog.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author 황인상
 */
@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberService memberService;

    // 댓글 등록
    @Transactional
    public boolean cwrite(CommentDto commentDto) {

        // mno
        MemberEntity memberEntity = memberService.getloginInfo();

        if(memberEntity == null) {
            return false;
        }

        // bno
        Optional<BoardEntity> optional = boardRepository.findById(commentDto.getBno());

        if(!optional.isPresent()) {
            return false;
        }

        BoardEntity boardEntity = optional.get();

        CommentEntity commentEntity = commentRepository.save(commentDto.toEntity());

        if(commentEntity.getCno() != 0) {
            commentEntity.setMemberEntity(memberEntity);
            memberEntity.getCommentEntityList().add(commentEntity);

            commentEntity.setBoardEntity(boardEntity);
            boardEntity.getCommentEntityList().add(commentEntity);
            return true;
        } else {
            return false;
        }

    }

    // 댓글 출력
    @Transactional
    public List<CommentDto> clist(int bno) {
        List<CommentEntity> entityList = commentRepository.Test(bno);

        List<CommentDto> dtoList = new ArrayList<>();


        for(CommentEntity entity : entityList) {
            dtoList.add(entity.toDto());
        }
        return dtoList;
    }


}













