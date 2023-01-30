package com.MyBlog.domain.dto;

import com.MyBlog.domain.entity.board.BoardEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BoardDto {

    private int bno;
    private String btitle;
    private String bcontent;
    private String mid;
    private String bdate;

    public BoardEntity toEntity() {
        return BoardEntity.builder()
                .bno(this.bno)
                .btitle(this.btitle)
                .bcontent(this.bcontent)
                .build();
    }

}
