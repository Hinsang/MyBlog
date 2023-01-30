package com.MyBlog.controller.board;

import com.MyBlog.domain.dto.CommentDto;
import com.MyBlog.service.board.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 황인상
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // 댓글 등록
    @PostMapping("/cwrite")
    public boolean cwrite(@RequestBody CommentDto commentDto) {
        return commentService.cwrite(commentDto);
    }

    // 댓글 출력
    @GetMapping("/clist")
    public List<CommentDto> clist(@RequestParam("bno") int bno) {
        return commentService.clist(bno);
    }

}
