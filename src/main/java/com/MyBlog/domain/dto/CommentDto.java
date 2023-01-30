package com.MyBlog.domain.dto;

import com.MyBlog.domain.entity.board.CommentEntity;
import lombok.*;

/**
 * @author 황인상
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CommentDto {

    int cno;
    String ccontent;
    String cdate;
    int bno;
    int mno;
    String mid;

    public CommentEntity toEntity() {
        return CommentEntity.builder()
                .cno(this.cno)
                .ccontent(this.ccontent)
                .build();
    }

}
