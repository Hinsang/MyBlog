package com.MyBlog.service.board;

import com.MyBlog.domain.dto.BoardDto;
import com.MyBlog.domain.entity.board.BoardEntity;
import com.MyBlog.domain.entity.board.BoardRepository;
import com.MyBlog.domain.entity.member.MemberEntity;
import com.MyBlog.domain.entity.member.MemberRepository;
import com.MyBlog.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private MemberService memberservice;

    // 글 등록
    @Transactional
    public boolean bwrite(BoardDto boardDto) {
        System.out.println(boardDto);

        MemberEntity memberEntity = memberservice.getloginInfo();

        if(memberEntity == null) {
            return false;
        }

        BoardEntity boardEntity = boardRepository.save(boardDto.toEntity());

        if(boardEntity.getBno() != 0) {

            boardEntity.setMemberEntity(memberEntity);
            memberEntity.getBoardEntityList().add(boardEntity);
            return true;
        } else {
            return false;
        }
    }

    // 글 리스트 출력
    @Transactional
    public List<BoardDto> blist() {
        List<BoardEntity> entityList = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "bno"));

        List<BoardDto> dtoList = new ArrayList<>();

        for(BoardEntity entity : entityList) {
            dtoList.add( entity.toDto() );
        }
        return dtoList;
    }

    // 글 조회
    @Transactional
    public BoardDto getview(int bno) {
        Optional<BoardEntity> optional = boardRepository.findById(bno);
        if(optional.isPresent()) {
            BoardEntity boardEntity = optional.get();
            return boardEntity.toDto();
        } else {
            return null;
        }
    }

    // 글 수정
    @Transactional
    public boolean bupdate(BoardDto boardDto) {
        Optional<BoardEntity> optional = boardRepository.findById(boardDto.getBno());
        if(optional.isPresent()) {
            BoardEntity boardEntity = optional.get();

            boardEntity.setBtitle(boardDto.getBtitle());
            boardEntity.setBcontent(boardDto.getBcontent());
            return true;
        } else {
            return false;
        }
    }

    // 글 삭제
    @Transactional
    public boolean bdelete(int bno) {
        Optional<BoardEntity> optional = boardRepository.findById(bno);

        if(optional.isPresent()) {
            BoardEntity boardEntity = optional.get();

            boardRepository.delete(boardEntity);
            return true;
        } else {
            return false;
        }
    }

}















