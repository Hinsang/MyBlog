package com.MyBlog.controller.board;

import com.MyBlog.domain.dto.BoardDto;
import com.MyBlog.domain.entity.board.BoardEntity;
import com.MyBlog.service.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 글 등록
    @PostMapping("/bwrite")
    public boolean bwrite(@RequestBody BoardDto boardDto) {
        return boardService.bwrite(boardDto);
    }

    // 글 리스트 출력
    @GetMapping("/blist")
    public List<BoardDto> blist() {
        return boardService.blist();
    }

    // 글 조회
    @GetMapping("/getview")
    public BoardDto getview(@RequestParam("bno") int bno) {
        return boardService.getview(bno);
    }

    // 글 수정
    @PutMapping("/bupdate")
    public boolean bupdate(@RequestBody BoardDto boardDto) {
        return boardService.bupdate(boardDto);
    }

    // 글 삭제
    @DeleteMapping("/bdelete")
    public boolean bdelete(@RequestParam("bno") int bno) {
        System.out.println(123);
        return boardService.bdelete(bno);
    }

}
